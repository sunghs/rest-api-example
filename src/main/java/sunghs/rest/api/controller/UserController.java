package sunghs.rest.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sunghs.rest.api.model.UserInfo;
import sunghs.rest.api.service.UserService;

@Api(value = "UserController", tags = "유저 컨트롤러")
@RestController
@RequestMapping("/user")
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
