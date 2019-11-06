package com.petadev.backend.controller;

import com.petadev.backend.controller.dao.DaoStore;
import com.petadev.backend.entity.Comment;
import com.petadev.backend.entity.Post;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

@RestController
public class PostController {
    private static final Logger LOG = LoggerFactory.getLogger(PostController.class);

    @GetMapping("/posts/{postId}")
    public Post getPostById(@PathVariable Integer postId) throws SQLException {
        return DaoStore.getPostDao().queryForId(postId);
    }

    @GetMapping("/posts/{postId}/comments")
    public List<Comment> getCommentsOfPost(@PathVariable Integer postId, HttpServletRequest request) throws SQLException {
        return DaoStore.getCommentDao().queryForEq("post_id", postId);
    }
}
