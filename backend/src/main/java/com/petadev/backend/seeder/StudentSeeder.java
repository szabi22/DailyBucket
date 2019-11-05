package com.petadev.backend.seeder;

import com.petadev.backend.DatabaseSeeder;
import com.petadev.backend.controller.dao.DaoStore;
import com.petadev.backend.entity.Student;

import java.sql.SQLException;
import java.util.Date;

public class StudentSeeder implements DatabaseSeeder {
    @Override
    public void fillTable() throws SQLException {
        final var studentDao = DaoStore.getStudentDao();

        studentDao.create(
                new Student(
                        "John",
                        "Doe",
                        "johndoe",
                        new Date()
                )
        );

        studentDao.create(
                new Student(
                        "Marry",
                        "Doe",
                        "marrydoe",
                        new Date()
                )
        );
    }
}
