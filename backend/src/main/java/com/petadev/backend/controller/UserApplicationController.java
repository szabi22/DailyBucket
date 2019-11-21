package com.petadev.backend.controller;

import com.petadev.backend.controller.dao.DaoStore;
import com.petadev.backend.entity.UserApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.sql.SQLException;

public class UserApplicationController {private static final Logger LOG = LoggerFactory.getLogger(UserApplicationController.class);

    @GetMapping("/userapplocations/{userapplicationId}")
    public UserApplication getUserApplicationById(@PathVariable Integer UserApplicationId) throws SQLException {
        LOG.info("Sending useractivity by id");
        return DaoStore.getUserApplicationDao().queryForId(UserApplicationId);
    }
}

