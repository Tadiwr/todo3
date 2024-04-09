package com.shangwa.todo3.lib;

public class TodoNotFound extends Exception {
    @Override
    public String getMessage() {
        return "The todo was not found";
    }
}