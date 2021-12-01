package com.pandhuta.jwt.logout.exception;


public class FailedToLoginException extends Exception {

    public FailedToLoginException(String username) {
        super(username);
    }
}