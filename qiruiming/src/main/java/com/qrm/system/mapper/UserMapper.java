package com.qrm.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qrm.system.entity.User;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {
    List<User> selectUsr(User user);

    boolean deleteUser(User user);

    boolean updateUser(User user);

    boolean insertUser(User user);
}
