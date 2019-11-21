package com.petadev.backend.seeder;

import com.petadev.backend.DatabaseSeeder;
import com.petadev.backend.controller.dao.DaoStore;
import com.petadev.backend.entity.FriendRequest;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class FriendRequestSeeder implements DatabaseSeeder {
    @Override
    public void fillTable() throws SQLException {

        final var userDao = DaoStore.getUserDao();
        final var friendRequestDao = DaoStore.getFriendRequestDao();
        final var user1 = userDao.queryForId(1);
        final var user2 = userDao.queryForId(2);

        friendRequestDao.create(List.of(
                new FriendRequest(user1, user2, new Date())

        ));
    }
}