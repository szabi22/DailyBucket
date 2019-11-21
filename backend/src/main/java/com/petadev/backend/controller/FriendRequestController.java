package com.petadev.backend.controller;

import com.petadev.backend.controller.dao.DaoStore;
import com.petadev.backend.entity.FriendRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
public class FriendRequestController {
    private static final Logger LOG = LoggerFactory.getLogger(FriendRequestController.class);

    @GetMapping("/friendrequests/{friendrequestId}")
    public FriendRequest getFriendRequestById(@PathVariable Integer friendrequestId) throws SQLException {
        return DaoStore.getFriendRequestDao().queryForId(friendrequestId);
    }



}
