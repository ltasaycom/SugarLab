package com.example.katherine.sugarlab.models;

import com.orm.dsl.Table;

import java.util.Date;

@Table
public class Note {

    private Long id;
    private String username;
    private String title;
    private String content;
    private Date date;
    private Boolean favorite;

    public Note() {
    }

    public Note(String username, String title, String content, Date date, Boolean favorite) {
        this.username = username;
        this.title = title;
        this.content = content;
        this.date = date;
        this.favorite = favorite;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getFavorite() {
        return favorite;
    }

    public void setFavorite(Boolean favorite) {
        this.favorite = favorite;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", date=" + date +
                ", favorite=" + favorite +
                '}';
    }
}
