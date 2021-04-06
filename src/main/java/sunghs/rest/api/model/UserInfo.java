package sunghs.rest.api.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@ApiModel("유저 정보에 대한 설명")
@Data
public class UserInfo {

    @Size(max = 11)
    private long seq;

    @ApiModelProperty(value = "유저 id", required = true)
    @Size(max = 30)
    private String userId;

    @ApiModelProperty(value = "유저 id", required = true)
    @Size(max = 512)
    private String userPassword;

    @ApiModelProperty(value = "유저 이름", required = true)
    @Size(max = 20)
    private String userName;

    @ApiModelProperty(value = "주소1")
    @Size(max = 256)
    private String userAddress1;

    @ApiModelProperty(value = "주소2")
    @Size(max = 256)
    private String userAddress2;

    @ApiModelProperty(value = "유저 기록", hidden = true)
    private List<String> userLog;

    @ApiModelProperty(value = "추가 데이터", position = 2)
    private List<String> addData;
}
