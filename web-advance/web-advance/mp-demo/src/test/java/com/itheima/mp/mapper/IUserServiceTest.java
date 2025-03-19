package com.itheima.mp.mapper;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.mp.domain.po.User;
import com.itheima.mp.service.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class IUserServiceTest {

    @Autowired
    private IUserService userService;
    @Test
    void testPageQuery() {
        //1.准备分页条件
        int pageNO = 1;
        int pageSize = 5;
        Page<User> page = Page.of(pageNO, pageSize);
        //2.排序条件
        page.addOrder(new OrderItem("balance",true));
        page.addOrder(new OrderItem("id",true));
        Page<User> p = userService.page(page);
        //3.解析结果
        System.out.println("总页数："+p.getPages());
        System.out.println("总记录数："+p.getTotal());
        p.getRecords().forEach(System.out::println);
    }
}
