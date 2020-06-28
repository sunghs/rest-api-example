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

    public String get(final String id) {
        log.info("Request User Id : {}", id);
        return HttpStatus.OK.toString();
    }

    public String set(final UserInfo userInfo) {
        log.info("Request User Info : {}", userInfo.toString());
        return HttpStatus.OK.toString();
    }
}
