package com.example.osamaaldawoody.swproject;

public class User {
    String name;
    String email;
    String password;
    String time;
    String post;
    public User(String name,String time,String post){
        this.name = name;
        this.time = time;
        this.post = post;
    }

    public User(String name,String email){
        this.name = name;
        this.email = email;
    }
    public String getName() {
        return name;
    }

    public String getPost() {
        return post;
    }

    public String getTime() {
        return time;
    }

    public String getEmail() {
        return email;
    }
}
