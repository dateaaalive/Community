package com.example.community;

import com.example.community.dao.DiscussPostMapper;
import com.example.community.dao.UserMapper;
import com.example.community.entity.DiscussPost;
import com.example.community.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.Date;
import java.util.List;

@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MapperTest {

    @Autowired
    private UserMapper mapper;

    @Autowired
    private DiscussPostMapper postMapper;

    @Test
    public void testUser(){
        User user = mapper.selectById(11);
        System.out.println(user);

        User user1 = mapper.selectByName("nowcoder11");
        System.out.println(user1);

        User user2 = mapper.selectByEmail("nowcoder11@sina.com");
        System.out.println(user2);
    }

    @Test
    public void testInsert(){
        User user = new User(1111, "test", "123", "abc", "test@qq.com", 1, 0, null, "http://1.png", new Date());
        int i = mapper.insertUser(user);
        System.out.println(i);

    }

    @Test
    public void testUpdate(){
        int i = mapper.updateHeader(150, "http://2.png");
        System.out.println(i);

        int i1 = mapper.updatePassword(150, "hello");
        System.out.println(i1);

        int i2 = mapper.updateStatus(150, 11);
        System.out.println(i2);
    }

    @Test
    public void testPostMapper() {
        List<DiscussPost> discussPostMappers = postMapper.selectDiscussPosts(149, 0, 10);
        discussPostMappers.forEach(post -> {
            System.out.println(post);
        });

        int i = postMapper.selectDiscussPostRows(149);
        System.out.println(i);
    }
}
