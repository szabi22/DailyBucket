package com.petadev.backend;

import com.petadev.backend.seeder.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;
import java.util.List;

// @SpringBootApplication is the entry point of our server.
@SpringBootApplication
public class Main {
    private static final Logger LOG = LoggerFactory.getLogger(Main.class);

    public static void main(String... args) {
        runSeeders(List.of(
                new UserSeeder(),
                new ApplicationSeeder(),
                new ActivitySeeder(),
                new UserActivitySeeder(),
                new WIPUserActivitySeeder(),
                new FinishedUserActivitySeeder(),
                new PostSeeder(),
                new CommentSeeder(),
                new ReactionSeeder(),
                new FriendRequestSeeder(),
                new FriendShipSeeder()
        ));
        SpringApplication.run(Main.class, args);
    }

    public static void runSeeders(final List<DatabaseSeeder> seeders) {
        for (DatabaseSeeder seeder : seeders) {
            LOG.info("Running seeder " + seeder.getClass().getName());
            try {
                seeder.fillTable();
            } catch (SQLException e) {
                e.printStackTrace();
                LOG.error("Error running seeder " + seeder.getClass().getName() + "\n" + e.getMessage());
                System.exit(1);
            }
        }
    }
}
