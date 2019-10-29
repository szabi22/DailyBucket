package com.petadev.backend;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;

import static com.petadev.backend.ConnectionConstants.*;

// this is called a singleton class
// there will always only exist one instance in the memory
// this is used when we want an object that we want to access in multiple classes
final class ConnectionManager {
    private static final Logger LOG = LoggerFactory.getLogger(ConnectionManager.class);

    // INSTANCE is private so it can be accessed only through the getInstance getter
    private static final ConnectionManager INSTANCE = new ConnectionManager();
    private ConnectionSource connectionSource;

    // Constructor is private so it is impossible to instantiate another object
    private ConnectionManager() {
        try {
            this.connectionSource = new JdbcConnectionSource("jdbc:mysql://" + HOST + "/" + DATABASE, USER, PASSWORD);
        } catch (SQLException e) {
            LOG.error(e.getMessage());
        }
    }

    static ConnectionManager getInstance() {
        return INSTANCE;
    }

    ConnectionSource getConnectionSource() {
        return this.connectionSource;
    }
}
