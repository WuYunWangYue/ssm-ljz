package com.ljz.controller.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Setter
@Getter
@ApiModel(value = "UserRequestVO", reference = "我是参考")
@Component
public class UserRequestVO {
    @NotNull
    @ApiModelProperty(name = "用户名", value = "ljz-cs", required = true, dataType = "String")
    private String userName;
    @NotNull
    @ApiModelProperty(name = "用户密码", value = "123456", required = true, dataType = "String")
    private String password;
    @ApiModelProperty(name = "年龄", value = "30", required = true, dataType = "Integer")
    private Integer age;
}
