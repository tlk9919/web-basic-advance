package com.itheima.mp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.mp.domain.po.User;
import com.itheima.mp.domain.query.PageQuery;
import com.itheima.mp.mapper.UserMapper;

import java.util.List;

public interface IUserService extends IService<User> {
    List<User> queryUsersPage(PageQuery pageQuery);
}