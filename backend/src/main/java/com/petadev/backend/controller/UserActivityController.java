package com.petadev.backend.controller;

import com.petadev.backend.controller.dao.DaoStore;
import com.petadev.backend.entity.UserActivity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.sql.SQLException;

public class UserActivityController {private static final Logger LOG = LoggerFactory.getLogger(UserActivityController.class);

    @GetMapping("/useractivities/{userActivityId}")
    public UserActivity getUserActivityById(@PathVariable Integer userActivityId) throws SQLException {
        LOG.info("Sending userActivity by id");
        return DaoStore.getUserActivityDao().queryForId(userActivityId);
    }
}

