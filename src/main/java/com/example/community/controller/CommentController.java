package com.example.community.controller;

import com.example.community.entity.Comment;
import com.example.community.entity.DiscussPost;
import com.example.community.entity.Event;
import com.example.community.event.EventProducer;
import com.example.community.service.CommentService;
import com.example.community.service.DiscussPostService;
import com.example.community.util.CommunityConstant;
import com.example.community.util.HostHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@Controller
@RequestMapping("/comment")
public class CommentController implements CommunityConstant {

    @Autowired
    private CommentService commentService;

    @Autowired
    private HostHolder hostHolder;

    @Autowired
    private DiscussPostService postService;

    @Autowired
    private EventProducer eventProducer;

    @RequestMapping(value = "/add/{discussPostId}", method = RequestMethod.POST)
    public String addComment(@PathVariable("discussPostId") int discussPostId, Comment comment){
        comment.setUserId(hostHolder.getUser().getId());
        comment.setStatus(0);
        comment.setCreateTime(new Date());
        commentService.addComment(comment);

        Event event = new Event().setTopic(TOPIC_COMMENT).setUserId(hostHolder.getUser().getId())
                .setEntityType(comment.getEntityType()).setEntityId(comment.getEntityId()).setData("postId", discussPostId);
        if(comment.getEntityType()==ENTITY_TYPE_POST){
            DiscussPost target = postService.findDiscussPostById(comment.getEntityId());
            event.setEntityUserId(target.getId());
        }else if(comment.getEntityType()==ENTITY_TYPE_COMMENT){
            Comment target = commentService.findCommentById(comment.getEntityId());
            event.setEntityUserId(target.getId());
        }
        eventProducer.fireEvent(event);

        return "redirect:/discuss/detail/"+discussPostId;
    }

}
