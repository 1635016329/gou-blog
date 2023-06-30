package com.gosh.goublog.service;
import java.util.Date;

import com.gosh.goublog.model.eneity.Post;
import com.gosh.goublog.model.eneity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author Gosh
 * @version 1.0
 * @date 2023/6/21 23:07
 * @description 用户服务测试类
 */
@SpringBootTest
public class UserServiceTest {

    @Resource
    private UserService userService;

    @Test
    public void addUserTest() {
        User user = new User();
        user.setUserAccount("gousheng");
        user.setUserPassword("123456");
        user.setUserName("苟生");
        user.setUserAvatar("");
        user.setUserProfile("站主");
        user.setUserRole("");
        boolean save = userService.save(user);
        Assertions.assertTrue(save);
    }
}
