package com.petadev.backend.seeder;

import com.petadev.backend.DatabaseSeeder;
import com.petadev.backend.controller.dao.DaoStore;
import com.petadev.backend.entity.User;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class UserSeeder implements DatabaseSeeder {
    @Override
    public void fillTable() throws SQLException {
        final var  userDao = DaoStore.getUserDao();

        String passwordSalt = BCrypt.gensalt();
        String passwordHash = BCrypt.hashpw("password", passwordSalt);

        userDao.create(
                List.of(
                        new User(
                                "John",
                                "Doe",
                                "johndoe",
                                new Date(),
                                new Date(),
                                passwordHash,
                                10
                        ),
                        new User(
                                "Marry",
                                "Doe",
                                "marrydoe",
                                new Date(),
                                new Date(),
                                passwordHash,
                                15

                        )
                )
        );
    }
}
