package com.example.community.service;

import com.example.community.dao.DiscussPostMapper;
import com.example.community.dao.UserMapper;
import com.example.community.entity.DiscussPost;
import com.example.community.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.Date;

@Service
public class TestService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DiscussPostMapper postMapper;

    @Autowired
    private TransactionTemplate transactionTemplate;

    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public Object save1(){

        User user = new User();
        user.setUsername("www");
        user.setCreateTime(new Date());
        user.setEmail("111");
        user.setHeaderUrl("111");
        user.setSalt("11111");
        user.setPassword("111");
        userMapper.insertUser(user);

        DiscussPost post = new DiscussPost();
        post.setTitle("wwwww");
        post.setContent("wwwwwwwww");
        post.setUserId(user.getId());
        post.setCreateTime(new Date());
        postMapper.insertDiscussPost(post);

        Integer.valueOf("aaa");
        return "ok";

    }

    public Object save2(){
        transactionTemplate.setIsolationLevel(TransactionDefinition.ISOLATION_READ_COMMITTED);
        transactionTemplate.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

        return transactionTemplate.execute(new TransactionCallback<Object>() {
            @Override
            public Object doInTransaction(TransactionStatus status) {
                User user = new User();
                user.setUsername("www");
                user.setCreateTime(new Date());
                user.setEmail("111");
                user.setHeaderUrl("111");
                user.setSalt("11111");
                user.setPassword("111");
                userMapper.insertUser(user);

                DiscussPost post = new DiscussPost();
                post.setTitle("wwwww");
                post.setContent("wwwwwwwww");
                post.setUserId(user.getId());
                post.setCreateTime(new Date());
                postMapper.insertDiscussPost(post);

                Integer.valueOf("aaa");
                return "ok";
            }
        });

    }

}
