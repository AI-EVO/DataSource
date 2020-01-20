package com.aievo.demo.model;

public class User {
    private Integer id;
    private String name;
    private byte[] password;

    public User(){}

    public User(Integer id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password.getBytes();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return new String(password);
    }

    public void setPassword(String password) {
        this.password = password.getBytes();
    }
}
