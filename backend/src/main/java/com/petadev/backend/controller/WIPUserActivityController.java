package com.petadev.backend.controller;

import com.petadev.backend.controller.dao.DaoStore;
import com.petadev.backend.entity.WIPUserActivity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
@RestController
public class WIPUserActivityController {
    private static final Logger LOG = LoggerFactory.getLogger(com.petadev.backend.controller.WIPUserActivityController.class);

    @GetMapping("/WIPUserActivities/{WIPUserActivityId}")
    public WIPUserActivity getWipUserActivityById(@PathVariable Integer wipUserActivityId) throws SQLException {
        LOG.info("Sending WIPUserActivities by id");
        return DaoStore.getWipUserActivityDao().queryForId(wipUserActivityId);
    }
}



