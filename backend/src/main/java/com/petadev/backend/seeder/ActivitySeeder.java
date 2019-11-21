package com.petadev.backend.seeder;
import com.j256.ormlite.dao.Dao;
import com.petadev.backend.DatabaseSeeder;
import com.petadev.backend.Difficulty;
import com.petadev.backend.controller.dao.DaoStore;
import com.petadev.backend.entity.Activity;

import java.sql.SQLException;
import java.util.List;

public class ActivitySeeder implements DatabaseSeeder {
    @Override
    public void fillTable() throws SQLException {
        Dao<Activity, Integer> activityDao = DaoStore.getActivityDao();

        activityDao.create(
                List.of(
                        new Activity("seta",
                                Difficulty.HARD,
                                "menj el setalni",
                                15
                        )
                        )


        );
    }
}
