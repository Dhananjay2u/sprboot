package com.dj.boot.student;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String address;
    @OneToMany(mappedBy = "user" , targetEntity = Subject.class,cascade = CascadeType.ALL )
    private List<Subject> subjectList=new ArrayList<>();
    
    public User(int id, String name, String address) {
        super();
        this.id = id;
        this.name = name;
        this.address = address;
    }
    
    public User() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public List<Subject> getSubjectList() {
        return subjectList;
    }

    public void addSubject(Subject subject) {
        this.subjectList.add(subject);
        subject.setUser(this);
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
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    

}
