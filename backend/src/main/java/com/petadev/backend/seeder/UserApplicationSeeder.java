package com.petadev.backend.seeder;

import com.j256.ormlite.dao.Dao;
import com.petadev.backend.DatabaseSeeder;
import com.petadev.backend.controller.dao.DaoStore;

import com.petadev.backend.entity.UserApplication;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class UserApplicationSeeder implements DatabaseSeeder {
    @Override
    public void fillTable() throws SQLException {
        Dao<UserApplication, Integer> userApplicationDao= DaoStore.getUserApplicationDao();

        final var userDao = DaoStore.getUserDao();
        final var applicationDao = DaoStore.getApplicationDao();
        final var user1 = userDao.queryForId(1);

        final var application1 = applicationDao.queryForId(1);


        userApplicationDao.create(
                List.of(

                        new UserApplication(

                                user1,
                                application1,
                                new Date()

                        )
                )
        );
    }
}

