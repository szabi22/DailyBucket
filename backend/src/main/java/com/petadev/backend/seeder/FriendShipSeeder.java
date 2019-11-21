package com.petadev.backend.seeder;

import com.petadev.backend.DatabaseSeeder;
import com.petadev.backend.controller.dao.DaoStore;
import com.petadev.backend.entity.FriendRequest;
import com.petadev.backend.entity.Friendship;

import java.sql.SQLException;
import java.util.Date;

public class FriendShipSeeder implements DatabaseSeeder {
    @Override
    public void fillTable() throws SQLException {
        final var friendRequestDao = DaoStore.getFriendRequestDao();
        final var friendShipDao = DaoStore.getFriendShipDao();

        FriendRequest friendRequest = friendRequestDao.queryForId(1);

        System.out.println(friendRequest);
        friendRequestDao.delete(friendRequest);

        final var user1 = friendRequest.getFromUser();
        final var user2 = friendRequest.getToUser();
        friendShipDao.create(new Friendship(user1, user2, new Date()));
    }
}