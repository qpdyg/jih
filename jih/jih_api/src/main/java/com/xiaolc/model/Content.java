package com.xiaolc.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

import static com.fasterxml.jackson.annotation.JsonFormat.Shape.STRING;
@Data
@ApiModel(value = "Content", description = "内容实体")
public class Content {

    @ApiModelProperty(notes = "主键id")
    private String cid;

    @ApiModelProperty(notes = "用戶id")
    private String id;

    @ApiModelProperty(notes = "内容")
    private String ctxt;

    @ApiModelProperty(notes = "日期")
    @JsonFormat(shape = STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private String cdate;

    @ApiModelProperty(notes = "名称")
    private String cname;

    @ApiModelProperty(notes = "状态")
    private String state;

    //用户信息
    @ApiModelProperty(notes = "发布人信息")
    private Users users;
}
