package com.petadev.backend.controller;

import com.petadev.backend.controller.dao.DaoStore;
import com.petadev.backend.entity.FinishedUserActivity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.sql.SQLException;

public class FinishedUserActivityController {private static final Logger LOG = LoggerFactory.getLogger(UserActivityController.class);

    @GetMapping("/finisheduseractivities/{finisheduseracticityId}")
    public FinishedUserActivity getUserActivityById(@PathVariable Integer FinishedUserActivityId) throws SQLException {
        LOG.info("Sending finisheduseractivity by id");
        return DaoStore.getFinishedUserActivityDao().queryForId(FinishedUserActivityId);
    }
}


