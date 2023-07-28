package com.example.community;

import com.example.community.dao.DiscussPostMapper;
import com.example.community.dao.LoginTicketMapper;
import com.example.community.dao.MessageMapper;
import com.example.community.dao.UserMapper;
import com.example.community.entity.DiscussPost;
import com.example.community.entity.LoginTicket;
import com.example.community.entity.Message;
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
    private UserMapper userMapper;

    @Autowired
    private DiscussPostMapper postMapper;

    @Autowired
    private LoginTicketMapper loginTicketMapper;

    @Autowired
    private MessageMapper messageMapper;

    @Test
    public void testUser(){
        User user = userMapper.selectById(11);
        System.out.println(user);

        User user1 = userMapper.selectByName("nowcoder11");
        System.out.println(user1);

        User user2 = userMapper.selectByEmail("nowcoder11@sina.com");
        System.out.println(user2);
    }

    @Test
    public void testInsert(){
        User user = new User(1111, "test", "123", "abc", "test@qq.com", 1, 0, null, "http://1.png", new Date());
        int i = userMapper.insertUser(user);
        System.out.println(i);

    }

    @Test
    public void testUpdate(){
        int i = userMapper.updateHeader(150, "http://2.png");
        System.out.println(i);

        int i1 = userMapper.updatePassword(150, "hello");
        System.out.println(i1);

        int i2 = userMapper.updateStatus(150, 11);
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

    @Test
    public void testTicketMapper(){
        LoginTicket loginTicket = new LoginTicket();
        loginTicket.setUserId(100);
        loginTicket.setTicket("aaa");
        loginTicket.setStatus(0);
        loginTicket.setExpired(new Date(System.currentTimeMillis()+1000*60*10));
        loginTicketMapper.insertLoginTicket(loginTicket);
    }

    @Test
    public void testSelectTicket(){
        LoginTicket loginTicket = loginTicketMapper.selectByTicket("aaa");
        System.out.println(loginTicket);

        loginTicketMapper.updateStatus("aaa", 1);
//        loginTicket = loginTicketMapper.selectByTicket("aaa");
//        System.out.println(loginTicket);

    }

    @Test
    public void messageTest(){
        List<Message> messages = messageMapper.selectConversations(111, 0, 20);
        messages.forEach(System.out::println);

        int count = messageMapper.selectConversationsCount(111);
        System.out.println(count);

        List<Message> messages1 = messageMapper.selectLetters("111_112", 0, 20);
        messages1.forEach(System.out::println);

        int i = messageMapper.selectLetterCount("111_112");
        System.out.println(i);

        int i1 = messageMapper.selectLetterUnreadCount(131, "111_131");
        System.out.println(i1);

    }
}
