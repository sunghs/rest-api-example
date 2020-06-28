package sunghs.rest.api.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import sunghs.rest.api.model.UserInfo;

@RequiredArgsConstructor
@Service
@Slf4j
public class UserService {

    /**
     * 유저 정보 조회
     * @param id 유저 id
     * @return UserInfo
     */
    public UserInfo get(final long id) {
        log.info("Request User Id : {}", id);
        // TODO storage에서 Data를 가져오는 로직..
        UserInfo userInfo = new UserInfo();
        userInfo.setId(id);
        userInfo.setName("sunghs");
        userInfo.setAddress("서울");
        return userInfo;
    }

    /**
     * 유저 생성
     * @param userInfo 생성할 유저 정보
     * @return HttpStatus
     */
    public String set(final UserInfo userInfo) {
        log.info("Request User Info : {}", userInfo.toString());
        // TODO insert 로직..
        return HttpStatus.OK.toString();
    }
}
