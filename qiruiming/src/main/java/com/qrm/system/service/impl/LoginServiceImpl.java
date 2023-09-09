package com.qrm.system.service.impl;

import cn.hutool.crypto.digest.MD5;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qrm.exception.ParamException;
import com.qrm.system.entity.Login;
import com.qrm.system.entity.User;
import com.qrm.system.mapper.LoginMapper;
import com.qrm.system.service.LoginService;
import com.qrm.utils.JwtUtil;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl extends ServiceImpl<LoginMapper, Login> implements LoginService {

    @Override
    public Login getLogin(String username) {
        QueryWrapper<Login> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",username);

        return getOne(queryWrapper);
    }

    @Override
    public String Login(Login login) {

        Login login1 = this.getLogin(login.getUsername());
        if (ObjectUtils.isEmpty(login1)) {
            throw new ParamException("用户名错误!");
        }

        // MD5
        String password = MD5.create().digestHex(login.getPassword());
        if (!StringUtils.equals(password,login1.getPassword())) {
            throw new ParamException("密码错误!");
        }
        return JwtUtil.create(login1.getUsername());
    }

}
