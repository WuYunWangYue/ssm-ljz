package com.ljz.controller.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Setter
@Getter
@ApiModel(value = "UserRequestVO", reference = "我是参考")
@Component
public class UserRequestVO {
    @ApiModelProperty(name = "用户名", value = "ljz-cs", required = true, dataType = "String")
    @NotNull(message = "用户名不能为空")
    private String userName;

    @ApiModelProperty(name = "用户密码", value = "123456", required = true, dataType = "String")
    @NotNull(message = "密码不能为空")
    @Size(min = 6, max = 16, message="密码长度应为{min}-{max}位")
    private String password;

    @ApiModelProperty(name = "年龄", value = "30", required = true, dataType = "Integer")
    @Max(value = 120, message = "年龄最大不能查过120")
    private Integer age;
}
