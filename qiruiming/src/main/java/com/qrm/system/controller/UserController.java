package com.qrm.system.controller;

import com.github.pagehelper.PageInfo;
import com.qrm.system.entity.Login;
import com.qrm.system.entity.ResultVO;
import com.qrm.system.entity.User;
import com.qrm.system.service.UserService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/test")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/selectUser")
    public ResultVO selectUser(@RequestParam(defaultValue = "1") int pageNumber,
                               @RequestParam(defaultValue = "5") int pageSize,
                               @RequestBody User user){
        PageInfo<User> userPageInfo = userService.selectUsr(pageNumber, pageSize, user);
        return ResultVO.success(userPageInfo);
    }

    @PostMapping("/deleteUser")
    public ResultVO deleteUser(@RequestParam int id){
        userService.deleteUser(id);
        return ResultVO.success("删除成功!");
    }

    @PostMapping("/updateUser")
    public ResultVO updateUser(@RequestBody User user){
        userService.updateUser(user);
        return ResultVO.success("修改成功!");
    }

    @PostMapping("/insertUser")
    public ResultVO insertUser(@RequestBody User user){
        userService.insertUser(user);
        return ResultVO.success("添加成功!");
    }
}
