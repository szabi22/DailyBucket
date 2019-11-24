package com.petadev.backend.filter;

import com.petadev.backend.service.TokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

import static com.petadev.backend.filter.AuthenticationFilterConstants.HEADER_NAME;

@Component
public class AuthenticationFilter implements Filter {
    private static final Logger LOG = LoggerFactory.getLogger(AuthenticationFilter.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        boolean isLoginRequest = httpServletRequest.getRequestURI().equals("/login");
        boolean isRegisterRequest = httpServletRequest.getRequestURI().equals("/register");

        if (Objects.isNull(httpServletRequest.getHeader(HEADER_NAME))) {
            if (isLoginRequest || isRegisterRequest) {
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                httpServletResponse.sendError(401, "Unauthorized!");
            }
        } else {
            String authHeader = httpServletRequest.getHeader(HEADER_NAME);

            try {
                if (TokenService.isTokenValid(authHeader) && !isLoginRequest && !isRegisterRequest) {
                    final var userByToken = TokenService.getUserByToken(authHeader);
                    if (userByToken.isPresent()) {
                        httpServletRequest.setAttribute("user", userByToken.get());
                        filterChain.doFilter(servletRequest, servletResponse);
                    } else {
                        httpServletResponse.sendError(401, "Unauthorized!");
                    }
                } else {
                    httpServletResponse.sendError(401, "Unauthorized!");
                }
            } catch (SQLException e) {
                LOG.error(e.getMessage());
                httpServletResponse.sendError(500);
            }
        }

    }

    @Override
    public void destroy() {

    }
}