package com.xiaolc.controller;

import com.xiaolc.model.Content;
import com.xiaolc.service.ContentService;
import com.xiaolc.util.JSONResponse;
import com.xiaolc.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author lc
 * @Date: 2018/11/28 10:24
 */
@RestController
@RequestMapping(value = "/content")
@Api(value = "内容接口", description = "内容接口")
public class ContentController {
    @Autowired
    private ContentService service;

    @GetMapping("fandAll")
    @ApiOperation("查询所有内容")
    @CrossOrigin
    public JSONResponse fandAll() {
        return ResultUtil.success("", service.fandAll());
    }

    @GetMapping("findById")
    @ApiOperation("根据id查询内容")
    @CrossOrigin
    public JSONResponse findById(String cid) {
        return ResultUtil.success("", service.findById(cid));
    }

    @PostMapping("fandName")
    @ApiOperation("根据名称查询内容")
    @CrossOrigin
    public JSONResponse fandName(String cname) {
        return ResultUtil.success("", service.fandName(cname));
    }

    @PostMapping("save")
    @ApiOperation("发布内容")
    @CrossOrigin
    public JSONResponse save(Content content) {
        int save = service.save(content);
        if (save > 0) {
            return ResultUtil.success("发布成功");
        }
        return ResultUtil.success("发布失败");
    }

    @PostMapping("update")
    @ApiOperation("更新")
    @CrossOrigin
    public JSONResponse update(Content content) {
        int update = service.update(content);
        if (update > 0) {
            return ResultUtil.success("修改成功");
        }
        return ResultUtil.success("修改失败");
    }

    @DeleteMapping("delete")
    @ApiOperation("根据id删除内容")
    @CrossOrigin
    public JSONResponse delete(String cid) {
        int delete = service.delete(cid);
        if (delete > 0) {
            return ResultUtil.success("删除成功");
        }
        return ResultUtil.success("删除失败");
    }
}
