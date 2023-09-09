package com.qrm.system.service;

import com.github.pagehelper.PageInfo;
import com.qrm.system.entity.User;

import java.util.List;

public interface UserService {
    PageInfo<User> selectUsr(int pageNmumber, int pageSize, User user);

    boolean deleteUser(int id);

    boolean updateUser(User user);

    boolean insertUser(User user);

}
