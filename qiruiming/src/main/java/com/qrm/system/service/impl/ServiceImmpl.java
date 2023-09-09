package com.qrm.system.service.impl;


import cn.hutool.core.date.DateUtil;
import cn.hutool.crypto.digest.MD5;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qrm.system.entity.Login;
import com.qrm.system.entity.User;
import com.qrm.system.mapper.UserMapper;
import com.qrm.system.service.UserService;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ServiceImmpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Transactional
    @Override
    public PageInfo<User> selectUsr(int pageNmumber, int pageSize, User user) {
        PageHelper.startPage(pageNmumber,pageSize);
        List<User> userList = userMapper.selectUsr(user);
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        return pageInfo;
    }

    @Transactional
    @Override
    public boolean deleteUser(int id) {
        User user = new User();
        user.setId(id);
        List<User> userList = userMapper.selectUsr(user);
        User getUser = userList.get(0);
        getUser.setId(id);
        getUser.setState("0");
        getUser.setLastTime(DateUtil.now());
        userMapper.deleteUser(getUser);
        return false;
    }

    @Transactional
    @Override
    public boolean updateUser(User user) {
        user.setLastTime(DateUtil.now());
        userMapper.updateUser(user);
        return false;
    }

    @Transactional
    @Override
    public boolean insertUser(User user) {
        user.setState("1");
        user.setCrTime(DateUtil.now());
        user.setLastTime(DateUtil.now());
        return userMapper.insertUser(user);
    }


}
