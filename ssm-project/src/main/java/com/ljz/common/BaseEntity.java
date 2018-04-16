package com.ljz.common;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class BaseEntity {
    private Integer id;
    private Date createTime;
    private Date updateTime;
    private Date deleteTime;
    private Integer isDelete;
}
