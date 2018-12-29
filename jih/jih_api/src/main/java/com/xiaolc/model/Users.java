package com.xiaolc.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import static com.fasterxml.jackson.annotation.JsonFormat.Shape.STRING;

@Data
@ApiModel(value = "Users", description = "用户实体")
public class Users {

    @ApiModelProperty(notes = "主键id")
    private String id;

    @ApiModelProperty(notes = "用户名称")
    private String name;

    @ApiModelProperty(notes = "性别")
    private String sex;

    @ApiModelProperty(notes = "年龄")
    private String age;

    @ApiModelProperty(notes = "头像")
    private String url;

    @ApiModelProperty(notes = "密码")
    private String password;

    @ApiModelProperty(notes = "昵称")
    private String nickname;

    @ApiModelProperty(notes = "注册日期")
    @JsonFormat(shape = STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private String udate;

    @ApiModelProperty(notes = "状态")
    private String userstate;

    @ApiModelProperty(notes = "盐")
    private String salt;

    @ApiModelProperty(notes = "权限id")
    private String jid;
}
