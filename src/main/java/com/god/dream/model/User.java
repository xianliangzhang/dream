package com.god.dream.model;

/**
 * Created by Willer on 16/4/9.
 */
public class User {
    private Long id;
    private String name;
    private String password;

    public String toString() {
        return this.id + ": " + name + ", " + password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
