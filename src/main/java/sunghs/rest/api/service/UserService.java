package sunghs.rest.api.service;

import java.time.LocalTime;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sunghs.rest.api.exception.UserException;
import sunghs.rest.api.mapper.UserMapper;
import sunghs.rest.api.model.AfterTransactionEvent;
import sunghs.rest.api.model.BeforeTransactionEvent;
import sunghs.rest.api.model.UserEventDto;
import sunghs.rest.api.model.UserInfo;

@RequiredArgsConstructor
@Service
@Slf4j
public class UserService {

    private final UserMapper userMapper;

    private final ApplicationEventPublisher applicationEventPublisher;

    /**
     * 유저 정보 조회
     *
     * @param userId 유저 id
     * @return UserInfo
     */
    public UserInfo get(final String userId) {
        applicationEventPublisher.publishEvent(new UserEventDto(userId));
        return userMapper.selectUserInfo(userId);
    }

    /**
     * 유저 생성
     *
     * @param userInfo 생성할 유저 정보
     * @return HttpStatus
     */
    @Transactional(rollbackFor = UserException.class)
    public boolean set(final UserInfo userInfo) {
        final int insertCount = userMapper.insertUserInfo(userInfo);

        // beforeTransactionEvent 생성
        BeforeTransactionEvent beforeTransactionEvent = () -> log.info("commit 시작, {}", LocalTime.now());
        // afterTransactionEvent 생성
        AfterTransactionEvent afterTransactionEvent = new AfterTransactionEvent() {
            @Override
            public void completed() {
                log.info("트랜잭션 끝, {}", LocalTime.now());
            }

            @Override
            public void callback() {
                log.info("commit 종료, {}", LocalTime.now());
            }
        };
        // 이벤트 발행
        applicationEventPublisher.publishEvent(beforeTransactionEvent);
        applicationEventPublisher.publishEvent(afterTransactionEvent);

        if (insertCount == 1) {
            log.info("실제 인서트가 완료되는 시점, {}", LocalTime.now());
            return true;
        }
        throw new UserException("user info insert error, insertCount : " + insertCount);
    }
}
