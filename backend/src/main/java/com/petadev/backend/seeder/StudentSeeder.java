package com.petadev.backend.seeder;

import com.petadev.backend.DatabaseSeeder;
import com.petadev.backend.controller.dao.DaoStore;
import com.petadev.backend.entity.Student;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.sql.SQLException;
import java.util.Date;

public class StudentSeeder implements DatabaseSeeder {
    @Override
    public void fillTable() throws SQLException {
        final var studentDao = DaoStore.getStudentDao();

        String passwordSalt = BCrypt.gensalt();
        String passwordHash = BCrypt.hashpw("password", passwordSalt);

        studentDao.create(
                new Student(
                        "John",
                        "Doe",
                        "johndoe",
                        passwordHash,
                        new Date()
                )
        );

        studentDao.create(
                new Student(
                        "Marry",
                        "Doe",
                        "marrydoe",
                        passwordHash,
                        new Date()
                )
        );
    }
}
