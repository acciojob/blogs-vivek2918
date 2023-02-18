package com.driver.models;

import javax.persistence.*;


@Entity
@Table(name="image")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String description;

    private String dimensions;

    //Image is wrt to blog is child
    //is mapping with blog and join column
    @ManyToOne
    @JoinColumn
    private Blog blog;

    public Image() {
    }


    public Image(Blog blog, String description, String dimensions) {
        this.description = description;
        this.dimensions = dimensions;
        this.blog = blog;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }
}