package com.petadev.backend.seeder;

import com.petadev.backend.DatabaseSeeder;
import com.petadev.backend.controller.dao.DaoStore;
import com.petadev.backend.entity.Reaction;

import java.sql.SQLException;
import java.util.List;

import static com.petadev.backend.ReactionType.LIKE;


public class ReactionSeeder implements DatabaseSeeder {
    @Override
    public void fillTable() throws SQLException {
        final var postDao = DaoStore.getPostDao();
        final var userDao = DaoStore.getUserDao();
        final var reactionDao = DaoStore.getReactionDao();
        final var user1 = userDao.queryForId(1);
        final var user2 = userDao.queryForId(2);
        final var post1 = postDao.queryForId(1);
        final var post2 = postDao.queryForId(2);


        reactionDao.create(List.of(
                new Reaction(user1, post1, LIKE),
                new Reaction(user2, post2, LIKE)
        ));
    }
}