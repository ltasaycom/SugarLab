package com.example.katherine.sugarlab.models;

import com.orm.dsl.Table;

@Table
public class User {

    private Long id;
    private String usuario;
    private String password;
    private String fullname;
    private String email;

    public User() {
    }

    public User(String usuario, String fullname, String email, String password) {
        this.usuario = usuario;
        this.fullname = fullname;
        this.email = email;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", usuario='" + usuario + '\'' +
                ", fullname='" + fullname + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
