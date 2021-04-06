package sunghs.rest.api.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;
import sunghs.rest.api.model.UserInfo;

@Mapper
@Repository
public interface UserMapper {

    UserInfo selectUserInfo(final String userId);

    int insertUserInfo(final UserInfo userInfo);
}
