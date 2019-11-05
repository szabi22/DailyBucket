package com.petadev.backend;

import java.sql.SQLException;

public interface DatabaseSeeder {
    void fillTable() throws SQLException;
}
