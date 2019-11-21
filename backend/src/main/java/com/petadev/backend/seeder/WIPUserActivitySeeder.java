package com.petadev.backend.seeder;

import com.petadev.backend.DatabaseSeeder;
import com.petadev.backend.controller.dao.DaoStore;
import com.petadev.backend.entity.UserActivity;
import com.petadev.backend.entity.WIPUserActivity;

import java.sql.SQLException;
import java.util.Date;

public class WIPUserActivitySeeder implements DatabaseSeeder {
    @Override
    public void fillTable() throws SQLException {
        final var userActivityDao=DaoStore.getUserActivityDao();

final var wipUserActivityDao=DaoStore.getWipUserActivityDao();

        UserActivity userActivity = userActivityDao.queryForId(1);
        userActivityDao.delete (userActivity);

        final var activity = userActivity.getActivity();
        final var  user =userActivity.getUser();
        wipUserActivityDao.create(new WIPUserActivity(user,activity,new Date()));

    }
}