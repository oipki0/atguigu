package com.atguigu;

import com.atguigu.mapper.ProductMapper;
import com.atguigu.mapper.UserMapper;
import com.atguigu.pojo.Product;
import com.atguigu.pojo.User;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class InterceptorTests {
    @Resource
    private UserMapper userMapper;
    @Resource
    private ProductMapper productMapper;

    @Test
    public void test03() {
        Product product = productMapper.selectById(1l);
        Product product1 = productMapper.selectById(1l);
        product.setPrice(product.getPrice()+50);
        int update = productMapper.updateById(product);
        System.out.println("update = " + update);
        //减四十
        product1.setPrice(product1.getPrice()-40);
        int i = productMapper.updateById(product1);
        System.out.println("i = " + i);
        if (i == 0) {
            Product product2 = productMapper.selectById(1l);
            System.out.println("i重试");
            product2.setPrice(product2.getPrice()-40);
            productMapper.updateById(product2);
        }

    }



    @Test
    public void test01() {
        Page<User> userPage = new Page<>(2, 5);
        userMapper.selectPage(userPage,null);
        System.out.println(userPage);
    }

    @Test
    public void test02() {
        Page<User> userPage = new Page<>(3, 5);
        userMapper.selectPageByPage(userPage,20);
        List<User> records = userPage.getRecords();
        for (User record : records) {
            System.out.println("record = " + record);
        }
        //records.forEach(System.out::println);
    }

}
