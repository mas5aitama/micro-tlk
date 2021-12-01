package com.pandhuta.jwt.logout.service;

import com.pandhuta.jwt.logout.exception.FailedToLoginException;
import com.pandhuta.jwt.logout.exception.JwtAuthenticationException;
import com.pandhuta.jwt.logout.jwt.JwtService;
import com.pandhuta.jwt.logout.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@Component
public class UserAuthenticationService {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserService userService;

    public String authenticateUser(String username, String password) throws FailedToLoginException {
        boolean isAuthenticated = false;
        if (username.equals("talika") && password.equals("talika123")) {
            isAuthenticated = true;
        } else if (username.equals("hati2") && password.equals("covid9")) {
            isAuthenticated = true;
        }

        if (isAuthenticated) {
            try {
                return jwtService.generateToken(username);
            } catch (URISyntaxException | IOException e) {
                throw new FailedToLoginException(e.getMessage());
            }
        }
        throw new FailedToLoginException(String.format("unable to authenticate user [%s]", username));
    }

    public User authenticateToken(String jwtToken) throws JwtAuthenticationException {

        try {
            String username = jwtService.verifyToken(jwtToken);
            List<String> userRoles = userService.getUserRoles(username);

            User user = new User();
            user.setUsername(username);
            user.setUserRoles(userRoles);
            return user;
        } catch (IOException | URISyntaxException e) {
            throw new JwtAuthenticationException(e.getMessage(), e);
        }
    }
}