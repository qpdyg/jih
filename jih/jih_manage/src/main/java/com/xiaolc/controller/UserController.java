package com.xiaolc.controller;

import com.xiaolc.model.Users;
import com.xiaolc.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * @author lc
 * @Date: 2018/11/27 11:02
 */

@RestController
@Api(value = "用戶信息接口", description = "用戶信息接口")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users/login", method = RequestMethod.POST)
    @ApiOperation("用户登陆")
    @CrossOrigin
    public Users login(@RequestBody Users users) {
        return userService.login(users);
    }

    @RequestMapping(value = "/users/list", method = RequestMethod.GET)
    @ApiOperation("查询所有用户")
    @CrossOrigin
    public List<Users> list(){
        return userService.list();
    }
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    @ApiOperation("用户注册")
    @CrossOrigin
    public Boolean add(@RequestBody Users users){
        users.setId(UUID.randomUUID().toString());
        int salt = (int) (Math.random() * 1000);
        // 将密码加盐
        String pwd = new Md5Hash(users.getPassword().getBytes(), salt + "", 1).toString();
        users.setSalt(pwd);
        int save = userService.add(users);
        if(save>0){
            return true;
        }
        return false;
    }
    @RequestMapping(value = "/users", method = RequestMethod.PUT)
    @ApiOperation("用户更新信息")
    @CrossOrigin
    public Boolean update(@RequestBody Users users){
        int update = userService.update(users);
        if(update>0){
            return true;
        }
        return false;
    }
    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    @ApiOperation("刪除用户")
    @CrossOrigin
    public Boolean delete(@PathVariable("id") String id){
        int delete = userService.delete(id);
        if(delete>0){
            return true;
        }
        return false;
    }
}
