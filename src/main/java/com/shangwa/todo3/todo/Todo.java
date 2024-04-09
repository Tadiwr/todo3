package com.shangwa.todo3.todo;


public class Todo {
    private int id;
    private String title;
    private boolean completed = false;

    Todo(int id, String title) {
        this.id = id;
        this.title = title;
    }

    Todo(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public int getId() {
        return this.id;
    }

    public boolean getCompleted() {
        return this.completed;
    }
}
