package com.petadev.backend.seeder;

import com.j256.ormlite.dao.Dao;
import com.petadev.backend.DatabaseSeeder;
import com.petadev.backend.controller.dao.DaoStore;
import com.petadev.backend.entity.Application;

import java.sql.SQLException;
import java.util.List;

public class ApplicationSeeder implements DatabaseSeeder {
    @Override
    public void fillTable() throws SQLException {
        Dao<Application, Integer> applicationDao  = DaoStore.getApplicationDao();

        applicationDao.create(
                List.of(
                        new Application(
                                "seta",
                                        "tamas")

                )
        );
    }
}

