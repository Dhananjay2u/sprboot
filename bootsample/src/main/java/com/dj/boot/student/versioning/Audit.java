package com.dj.boot.student.versioning;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Audit {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String description;
    private String category;
    private Long timestamp;
    private String userId;
    public Audit(String description, String category, Long timestamp, String userId) {
        super();
        this.description = description;
        this.category = category;
        this.timestamp = timestamp;
        this.userId = userId;
    }
    public Audit() {
        super();
        // TODO Auto-generated constructor stub
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public Long getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    
}
