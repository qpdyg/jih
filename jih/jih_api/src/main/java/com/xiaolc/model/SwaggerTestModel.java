package com.xiaolc.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/***
 *@author Created by wyx
 *@date 2018/8/8 16:41
 */
@ApiModel(value="Swagger测试实体",description="Swagger测试实体描述")
public class SwaggerTestModel {




    @ApiModelProperty(notes="主键")
    private String id;

    @ApiModelProperty(notes="名称")
    private String name;

    public String getId(){
        return this.id;
    }
    public void setId(String id){
        this.id = id;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }


}
