package com.petadev.backend.controller;

import com.petadev.backend.controller.dao.DaoStore;
import com.petadev.backend.entity.Comment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
public class CommentController {
    private static final Logger LOG = LoggerFactory.getLogger(CommentController.class);

    @GetMapping("/comments/{commentId}")
    public Comment getCommentById(@PathVariable Integer commentId) throws SQLException {
        LOG.info("Sending comment by id");
        return DaoStore.getCommentDao().queryForId(commentId);
    }
}
//mashol meg csak ennyi van