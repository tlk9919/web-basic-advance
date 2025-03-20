package com.itheima.mp.controller;

import com.itheima.mp.domain.po.User;
import com.itheima.mp.domain.query.PageQuery;
import com.itheima.mp.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("/users/page")
    public List<User> queryUsersPage(PageQuery pageQuery) {

        return userService.queryUsersPage(pageQuery);
    }
}
