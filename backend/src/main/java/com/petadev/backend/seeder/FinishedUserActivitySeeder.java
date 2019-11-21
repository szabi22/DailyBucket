package com.petadev.backend.seeder;

import com.petadev.backend.DatabaseSeeder;
import com.petadev.backend.controller.dao.DaoStore;
import com.petadev.backend.entity.FinishedUserActivity;
import com.petadev.backend.entity.WIPUserActivity;

import java.sql.SQLException;
import java.util.Date;

public class FinishedUserActivitySeeder implements DatabaseSeeder {
    @Override
    public void fillTable() throws SQLException {
        final var userActivityDao=DaoStore.getUserActivityDao();
final var finishedUserActivityDao=DaoStore.getFinishedUserActivityDao();
        final var wipUserActivityDao=DaoStore.getWipUserActivityDao();

        WIPUserActivity wipUserActivity = wipUserActivityDao.queryForId(1);
        wipUserActivityDao.delete (wipUserActivity);

        final var activity = wipUserActivity.getActivity();
        final var  user = wipUserActivity.getUser();
        finishedUserActivityDao.create(new FinishedUserActivity(user ,activity ,new Date()));

    }
}