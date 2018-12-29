package com.xiaolc.controller;

import com.xiaolc.model.SwaggerTestModel;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * swagger测试
 */
@RestController
@RequestMapping("/swtest")
@Api(value="swagger测试", description="用来测试swagger请求")
public class SwaggerTestController {
    /**
     * 获取一个列表
     */
    @RequestMapping(value="/detail",method= RequestMethod.GET)
    @ApiOperation(value="获取一个列表")
    public List<SwaggerTestModel> detail(){
        return new ArrayList<SwaggerTestModel>();
    }
    /**
     * 获取一个列表
     */
    @RequestMapping(value="/detail/{id}",method= RequestMethod.GET, produces = "application/json")
    @ApiOperation(value="获取一个条数据")
    public SwaggerTestModel detail(@ApiParam(value="数据主键", required=true) @PathVariable String id){
        return new SwaggerTestModel();
    }

    /**
     * 创建一个元素
     */
    @RequestMapping(value="/create",method= RequestMethod.POST, produces = "application/json", consumes="application/json")
    @ApiOperation(value="创建新的",consumes="application/json")
    public ResponseEntity create(@RequestBody SwaggerTestModel model){
        return ResponseEntity.ok().build();
    }

    /**
     * 获取一个条数据
     */
    @RequestMapping(value="/detailMap/{id}",method= RequestMethod.GET, produces = "application/json")
    @ApiOperation(value="获取一个条数据", response=Map.class)
    @ApiImplicitParams({
        @ApiImplicitParam(name="id",value="主键", required=true, dataType="string", paramType="path")
    })
    @ApiResponses({
        @ApiResponse(code=200, message="id:string, name:string")
    })
    public Map detailMap(@PathVariable String id){
        return new HashMap();
    }
    
    /***
     * 修改一个数据
     */
    @RequestMapping(value="/update/{id}",method= RequestMethod.GET,produces="application/json")
    @ApiOperation(value="修改一个数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name="id",value="参数", required=true, dataType="string", paramType="path")
    })
    @ApiResponses({
        @ApiResponse(code=200, message="id:string, name:string")
    })
    public String updateById(@PathVariable String id){
    	
    	return id;
    }


}