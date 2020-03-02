package com.dj.boot.student;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Subject {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String description;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,targetEntity = User.class)
    @JsonIgnore
    private User user;
    public Subject() {
        super();
        // TODO Auto-generated constructor stub
    }
    public Subject(int id, String name, String description) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    
}
