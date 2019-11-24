package com.petadev.backend.controller;

import com.petadev.backend.controller.dao.DaoStore;
import com.petadev.backend.entity.Comment;
import com.petadev.backend.entity.Post;
import com.petadev.backend.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

@RestController
public class PostController {
    private static final Logger LOG = LoggerFactory.getLogger(PostController.class);

    @GetMapping("/posts/{postId}")
    public Post getPostById(@PathVariable Integer postId, final @RequestAttribute User user, HttpServletResponse response) throws SQLException {
        final var post = DaoStore.getPostDao().queryForId(postId);

        Post returnVal = null;
        int returnCode = 200;

        if (Objects.nonNull(post)) {
            if (isUsersPost(user, post) || isUsersFriendPost(user, post)) {
                returnVal = post;
            } else {
                returnCode = 401;
            }
        } else {
            returnCode = 404;
        }

        response.setStatus(returnCode);
        return returnVal;
    }


    @GetMapping("/posts/{postId}/comments")
    public List<Comment> getCommentsOfPost(@PathVariable Integer postId, HttpServletRequest request) throws SQLException {
        return DaoStore.getCommentDao().queryForEq("post_id", postId);
    }

    private boolean isUsersPost(final User user, final Post post) {
        return post.getUser().getUserID() == user.getUserID();
    }

    private boolean isUsersFriendPost(final User user, final Post post) {
        // check if the post was posted by one of the students friends.

        return false;
    }
}
