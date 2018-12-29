package com.xiaolc.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "Jurisdiction", description = "权限实体")
public class Jurisdiction {
  @ApiModelProperty(notes = "主键id")
  private String jid;
  @ApiModelProperty(notes = "权限名称")
  private String jname;
}
