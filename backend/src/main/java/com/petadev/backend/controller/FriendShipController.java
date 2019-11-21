package com.petadev.backend.controller;

import com.petadev.backend.controller.dao.DaoStore;
import com.petadev.backend.entity.Friendship;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
public class FriendShipController {
    private static final Logger LOG = LoggerFactory.getLogger(FriendShipController.class);

    @GetMapping("/friendshipes/{friendshipId}")
    public Friendship getFriendShipById(@PathVariable Integer friendshipId) throws SQLException {
        return DaoStore.getFriendShipDao().queryForId(friendshipId);
    }



}

