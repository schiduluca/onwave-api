package com.konio.onwave.domain.views;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

/**
 * Created by lschidu on 2/9/17.
 */
public class UserView implements Serializable {

    private Long id;

    private String email;

    private String firstName;

    private String lastName;

    private String photoUrl;

    private String fullName;

    private String uuid;

    private List<SongView> songs;

    public List<SongView> getSongs() {
        return songs;
    }

    public void setSongs(List<SongView> songs) {
        this.songs = songs;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

}
