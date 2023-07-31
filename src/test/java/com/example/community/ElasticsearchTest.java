//package com.example.community;
//
//import com.example.community.dao.DiscussPostMapper;
//import com.example.community.dao.elasticsearch.DiscussPostRepository;
//import com.example.community.entity.DiscussPost;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.elasticsearch.client.elc.ElasticsearchTemplate;
//import org.springframework.test.context.ContextConfiguration;
//
//@SpringBootTest
//@ContextConfiguration(classes = CommunityApplication.class)
//public class ElasticsearchTest {
//
//    @Autowired
//    private DiscussPostMapper discussPostMapper;
//
//    @Autowired
//    private DiscussPostRepository discussPostRepository;
//
//    @Autowired
//    private ElasticsearchTemplate elasticsearchTemplate;
//
//    @Test
//    public void testInert(){
//        discussPostRepository.save(discussPostMapper.selectDiscussPostById(241));
//        discussPostRepository.save(discussPostMapper.selectDiscussPostById(242));
//        discussPostRepository.save(discussPostMapper.selectDiscussPostById(243));
//    }
//
//    @Test
//    public void testInsertList(){
//        discussPostRepository.saveAll(discussPostMapper.selectDiscussPosts(101, 0, 100));
//        discussPostRepository.saveAll(discussPostMapper.selectDiscussPosts(102, 0, 100));
//        discussPostRepository.saveAll(discussPostMapper.selectDiscussPosts(103, 0, 100));
//        discussPostRepository.saveAll(discussPostMapper.selectDiscussPosts(104, 0, 100));
//        discussPostRepository.saveAll(discussPostMapper.selectDiscussPosts(101, 0, 100));
//    }
//
//    @Test
//    public void testUpdate(){
//        DiscussPost discussPost = discussPostMapper.selectDiscussPostById(231);
//        discussPost.setContent("xxxxxxxx");
//        discussPostRepository.save(discussPost);
//    }
//
//    @Test
//    public void testDelete(){
//        discussPostRepository.deleteAll();
//    }
//
//    @Test
//    public void testSearch(){
//
//    }
//
//}
