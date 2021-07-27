package com.atguigu;

import com.atguigu.mapper.UserMapper;
import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.*;

@SpringBootTest
public class MybatisPlusApplicationTests {
    @Resource
    private UserMapper userMapper;
    @Resource
    private UserService userService;

    @Test
    public void test01() {
        List<User> users = userMapper.selectList(null);
        for (User user : users) {
            System.out.println("user = " + user);
        }
    }

    @Test
    public void test02() {
        User user = new User();
        user.setAge(20);
        user.setName("zhangsan");
        user.setEmail("55566@qq.com");
        userMapper.insert(user);
    }

    @Test
    public void test03() {
        User user = userMapper.selectById(1);
        System.out.println("user = " + user);
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3, 4, 5, 6));
        //System.out.println("users = " + users);
        Map<String, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("name","zhangsan");
        objectObjectHashMap.put("age",20);
        List<User> users1 = userMapper.selectByMap(objectObjectHashMap);
        System.out.println("users1 = " + users1);
    }

    @Test
    public void test04() {
        User user = new User();
        user.setId(6l);
        user.setName("李四");
        user.setAge(21);
        user.setEmail(null);
        int update = userMapper.updateById(user);
        System.out.println(update);

    }
@Test
    public void test05() {
        int delete = userMapper.deleteById(5);

    }

    @Test
    public void test06() {
        int count = userService.count();
        System.out.println("count = " + count);
    }

    @Test
    public void test07() {
        List list = new ArrayList<>();
        for (int i = 5; i < 9; i++) {
            User user = new User();
            user.setAge(10+i);
            user.setName("王五"+i);
            user.setEmail("86986@dddd"+i);
            list.add(user);
        }
        userService.saveBatch(list);
    }

}

