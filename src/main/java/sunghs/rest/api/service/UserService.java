package sunghs.rest.api.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sunghs.rest.api.exception.UserException;
import sunghs.rest.api.mapper.UserMapper;
import sunghs.rest.api.model.UserInfo;

@RequiredArgsConstructor
@Service
@Slf4j
public class UserService {

    private final UserMapper userMapper;

    /**
     * 유저 정보 조회
     *
     * @param id 유저 id
     * @return UserInfo
     */
    public UserInfo get(final String userId) {
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
        if (insertCount == 1) {
            return true;
        }
        throw new UserException("user info insert error, insertCount : " + insertCount);
    }
}
