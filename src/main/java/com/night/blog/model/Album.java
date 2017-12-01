package com.night.blog.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Album implements Serializable {

    private Integer id;
    private String name;
    private List<Photograph> photographs;
    private String description;
    private Date createDate;

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

    public List<Photograph> getPhotographs() {
        return photographs;
    }

    public void setPhotographs(List<Photograph> photographs) {
        this.photographs = photographs;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
