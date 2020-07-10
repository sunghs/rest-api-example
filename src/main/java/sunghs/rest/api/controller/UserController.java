package sunghs.rest.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sunghs.rest.api.model.UserInfo;
import sunghs.rest.api.service.UserService;

@Api(value = "UserController", tags = "유저 컨트롤러")
@ApiResponses(value = {
    @ApiResponse(code = 200, message = "OK, 성공"),
    @ApiResponse(code = 201, message = "Created, 리소스 생성 성공"),
    @ApiResponse(code = 307, message = "Temporary Redirect, URI가 변경 됨"),
    @ApiResponse(code = 401, message = "Unauthorized, 인증되지 않음"),
    @ApiResponse(code = 403, message = "Forbidden, 권한이 없음"),
    @ApiResponse(code = 404, message = "Api Not Found, 없는 API 주소"),
    @ApiResponse(code = 500, message = "Internal Server Error, 서버 에러"),
    @ApiResponse(code = 503, message = "Service Unavailable, 서비스 요청 불가"),
    @ApiResponse(code = 504, message = "Gateway Timeout, 응답시간 초과")
})
@RestController
@RequestMapping(value = "/user", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE})
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @ApiOperation("유저 정보 조회")
    @GetMapping("/get/{id}")
    public UserInfo get(@ApiParam(value = "유저 Id", required = true) @PathVariable(value = "id") final long id) {
        return userService.get(id);
    }

    @ApiOperation("유저 정보 등록")
    @PostMapping("/set")
    public String set(@ApiParam(value = "유저 정보", required = true) @RequestBody final UserInfo userInfo) {
        return userService.set(userInfo);
    }
}
