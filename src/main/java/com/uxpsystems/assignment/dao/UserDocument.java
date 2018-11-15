package com.uxpsystems.assignment.dao;

import java.io.Serializable;

/**
 * UserDocument
 */
public class UserDocument implements Serializable{

    private static final long serialVersionUID = 1L;
    private long id;

    private String username;
    private String password;
    private String status;

    public UserDocument(long id, String username, String password, String status){
        this.id = id;
        this.username = username;
        this.password = password;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
