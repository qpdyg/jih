package com.xiaolc.controller;

import com.xiaolc.model.Comment;
import com.xiaolc.service.CommentService;
import com.xiaolc.util.JSONResponse;
import com.xiaolc.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author lc
 * @Date: 2018/11/28 15:11
 */
@RestController
@RequestMapping(value = "/comment")
@Api(value = "评论接口", description = "评论接口")
public class CommentController {

    @Autowired
    private CommentService service;

    @GetMapping("fandBycid")
    @ApiOperation("根据内容id查询评论")
    @CrossOrigin
    public JSONResponse fandBycid(@ApiParam(value = "搜索参数id") @RequestParam(value = "cid", required = false)String cid) {
        return ResultUtil.success("", service.fandBycid(cid));
    }

    @PostMapping("save")
    @ApiOperation("发布评论")
    @CrossOrigin
    public JSONResponse save(Comment comment) {
        int save = service.save(comment);
        if (save > 0) {
            return ResultUtil.success("发布成功");
        }
        return ResultUtil.success("发布失败");
    }

    @PostMapping("update")
    @ApiOperation("更新评论")
    @CrossOrigin
    public JSONResponse update(Comment comment) {
        int update = service.update(comment);
        if (update > 0) {
            return ResultUtil.success("修改成功");
        }
        return ResultUtil.success("修改失败");
    }

    @DeleteMapping("delete")
    @ApiOperation("根据id删除评论")
    @CrossOrigin
    public JSONResponse delete(String mid) {
        int delete = service.delete(mid);
        if (delete > 0) {
            return ResultUtil.success("删除成功");
        }
        return ResultUtil.success("删除失败");
    }
}
