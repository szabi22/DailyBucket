package com.petadev.backend.controller;

import com.petadev.backend.entity.User;
import com.petadev.backend.service.AuthenticationService;
import com.petadev.backend.service.TokenService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Objects;

@RestController
public class AuthenticationController {
    @PostMapping("/login")
    public void getLogin(final HttpServletResponse response, final @RequestParam String username, final @RequestParam String password) throws IOException {
        try {
            System.out.println(username + " " + password);

            final User user  = AuthenticationService.exists(username, password);

            if (Objects.isNull(user)) {
                response.sendError(401);
            } else {
                PrintWriter writer = response.getWriter();
                writer.write(TokenService.authenticate(user));
            }
        } catch (SQLException e) {
            response.sendError(500, e.getMessage());
        }
    }
}