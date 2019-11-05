package com.petadev.backend.seeder;

import com.j256.ormlite.dao.Dao;
import com.petadev.backend.DatabaseSeeder;
import com.petadev.backend.controller.dao.DaoStore;
import com.petadev.backend.entity.Post;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class PostSeeder implements DatabaseSeeder {
    @Override
    public void fillTable() throws SQLException {
        final var postDao = DaoStore.getPostDao();
        final var studentDao = DaoStore.getStudentDao();

        final var student1 = studentDao.queryForId(1);
        final var student2 = studentDao.queryForId(2);

        postDao.create(List.of(
           new Post(student1, new Date(), "This is a very cool post!"),
           new Post(student2, new Date(), "This is a very cool second post!")
        ));
    }
}
