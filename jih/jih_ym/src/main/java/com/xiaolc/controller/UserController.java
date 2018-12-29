package com.xiaolc.controller;

import com.xiaolc.model.Users;
import com.xiaolc.service.RedisClientService;
import com.xiaolc.service.UsersClientService;
import com.xiaolc.util.JSONResponse;
import com.xiaolc.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * @author lc
 * @Date: 2018/11/27 11:02
 */

@Controller
@RequestMapping(value = "/users")
@Api(value = "用戶信息接口", description = "用戶信息接口")
public class UserController {

    @Autowired
    private UsersClientService userService;
    @Autowired
    private RedisClientService redisClientService;

    @RequestMapping(value = "user/add", method = RequestMethod.POST)
    @ApiOperation("用户登陆")
    @CrossOrigin
    @ResponseBody
    public JSONResponse queryByName(@ApiParam(value = "用户名") @RequestParam(value = "name", required = false) String name, @ApiParam(value = "密码") @RequestParam(value = "password", required = false) String password) {
        Users users = new Users();
        users.setName(name);
        users.setPassword(password);
        Users users1 = userService.login(users);
        if (users1 != null) {
            return ResultUtil.success("登陆成功", users1);
        }
        return ResultUtil.error("登陆失败", "用户名或密码错误");
    }

    @RequestMapping(value = "/fandAll", method = RequestMethod.GET)
    @ApiOperation("查询所有用户")
    @CrossOrigin
    @ResponseBody
    public JSONResponse fandAll() {
        return ResultUtil.success("", userService.list());
    }

    @PostMapping("users/add")
    @ApiOperation("用户注册")
    @CrossOrigin
    @ResponseBody
    public JSONResponse save(Users users) {
        users.setId(UUID.randomUUID().toString());
        boolean add = userService.add(users);
        if (add) {
            return ResultUtil.success("注册成功");
        }
        return ResultUtil.error("注册失败");
    }

    @PostMapping("/users/update")
    @ApiOperation("用户更新信息")
    @CrossOrigin
    @ResponseBody
    public JSONResponse update(Users users) {
        boolean update = userService.update(users);
        if (update) {
            return ResultUtil.success("更新成功");
        }
        return ResultUtil.error("更新失败");
    }

    @DeleteMapping("delete/{id}")
    @ApiOperation("刪除用户")
    @CrossOrigin
    @ResponseBody
    public JSONResponse delete(@PathVariable("id") String id) {
        boolean delete = userService.delete(id);
        if (delete) {
            return ResultUtil.success("删除成功");
        }
        return ResultUtil.error("删除失败");
    }

    @GetMapping("/get/{key}")
    @ApiOperation("得到redis中的值")
    @CrossOrigin
    @ResponseBody
    public JSONResponse get(@PathVariable("key") String key) {
        String o = redisClientService.get(key);
        return ResultUtil.success("",o);
    }
}