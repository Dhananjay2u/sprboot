package com.dj.boot.student.versioning;

class Name{
    private String firstName;
    private String lastName;
    public Name() {
        super();
        // TODO Auto-generated constructor stub
    }
    public Name(String firstName, String lastName) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
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
    
    
}
public class StudentV2 {
    private Name name;

    public StudentV2() {
        super();
        // TODO Auto-generated constructor stub
    }

    public StudentV2(Name name) {
        super();
        this.name = name;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }
    
}
