package com.qrm.system.controller;

import com.qrm.system.entity.Login;
import com.qrm.system.entity.ResultVO;
import com.qrm.system.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping("/login")
    public ResultVO login(Login login) {
        String token = loginService.Login(login);
        return ResultVO.success(token);
    }
}
