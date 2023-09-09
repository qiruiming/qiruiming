package com.qrm.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qrm.system.entity.Login;

public interface LoginService extends IService<Login> {
    Login getLogin(String username);

    String Login(Login login);
}
