package com.self;

import org.junit.jupiter.api.Test;

public class UserServiceTest {
    @Test
    public void testGetAge() {
        UserService userService = new UserService();
        Integer age = userService.getAge("122");
        System.out.println(age);
    }
}
