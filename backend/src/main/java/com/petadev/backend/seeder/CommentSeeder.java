package com.petadev.backend.seeder;

import com.petadev.backend.DatabaseSeeder;
import com.petadev.backend.controller.dao.DaoStore;
import com.petadev.backend.entity.Comment;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class CommentSeeder implements DatabaseSeeder {
    @Override
    public void fillTable() throws SQLException {
        final var commentDao = DaoStore.getCommentDao();
        final var studentDao = DaoStore.getStudentDao();
        final var postDao = DaoStore.getPostDao();

        final var student2 = studentDao.queryForId(2);
        final var post1 = postDao.queryForId(1);

        System.out.println(commentDao);

        commentDao.create(List.of(
                new Comment(
                        student2,
                        post1,
                        "Comment on this post!",
                        new Date()
                )
        ));
    }
}
