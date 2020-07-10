package sunghs.rest.api.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@ApiModel("유저 정보에 대한 설명")
@Data
public class UserInfo {

    @ApiModelProperty(value = "유저 id", required = true)
    private long id;

    @ApiModelProperty(value = "유저 이름", required = true)
    private String name;

    @ApiModelProperty(value = "주소", allowableValues = ",인천,서울,대전")
    private String address;

    @ApiModelProperty(value = "유저 기록", hidden = true)
    private List<String> userLog;

    @ApiModelProperty(value = "추가 데이터", position = 2)
    private List<String> addData;
}
