package com.petadev.backend.seeder;

import com.j256.ormlite.dao.Dao;
import com.petadev.backend.DatabaseSeeder;
import com.petadev.backend.controller.dao.DaoStore;
import com.petadev.backend.entity.UserActivity;

import java.sql.SQLException;

import java.util.List;



    public class UserActivitySeeder implements DatabaseSeeder {
        @Override
        public void fillTable() throws SQLException {
            Dao<UserActivity, Integer> userActivityDao = DaoStore.getUserActivityDao();

            final var userDao = DaoStore.getUserDao();
            final var activityDao = DaoStore.getActivityDao();

            final var user2 = userDao.queryForId(2);
            final var activity1 = activityDao .queryForId(1);


            userActivityDao.create(
                    List.of(
                            new UserActivity(

                                    user2,
                                    activity1
                            )
                    )
            );
        }
    }


