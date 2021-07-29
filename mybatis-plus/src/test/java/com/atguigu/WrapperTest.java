package com.atguigu;

import com.atguigu.mapper.UserMapper;
import com.atguigu.pojo.User;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class WrapperTest {
    @Resource
    private UserMapper userMapper;

    @Test
    public void test01() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name","n").between("age",10,20);
        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println("users = " + users);
    }
}
