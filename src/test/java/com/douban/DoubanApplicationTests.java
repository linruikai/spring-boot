package com.douban;

import com.douban.bean.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DoubanApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void resr() {
        User user = new User();
        user.setId(1);
        user.setName("12321");

        redisTemplate.opsForValue().set("lin", user);
        Object lin = redisTemplate.opsForValue().get("lin");
        System.out.println(lin);
    }



}
