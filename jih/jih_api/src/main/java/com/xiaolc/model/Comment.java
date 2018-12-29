package com.xiaolc.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import static com.fasterxml.jackson.annotation.JsonFormat.Shape.STRING;

@ApiModel(value = "Comment", description = "评论实体")
@Data
public class Comment {

    @ApiModelProperty(notes = "主键id")
    private String mid;

    @ApiModelProperty(notes = "用户id")
    private String id;

    @ApiModelProperty(notes = "内容id")
    private String cid;

    @ApiModelProperty(notes = "评论内容")
    private String cmtxt;

    @ApiModelProperty(notes = "评论时间")
    @JsonFormat(shape = STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private String cmdate;

    @ApiModelProperty(notes = "评论状态")
    private String ctate;
}
