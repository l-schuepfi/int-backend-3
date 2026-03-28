package com.bezkoder.spring.datajpa.model;

import jakarta.persistence.*;

@Entity
public class Step {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String text;
    private Long number;

    @ManyToOne(fetch = FetchType.LAZY)
    private Tutorial tutorial;

    public Long getId() {
        return id;
    }

    public Long getNumber() {
        return number;
    }

    public String getText() {
        return text;
    }

    public String getTitle() {
        return title;
    }

    public Tutorial getTutorial(){
        return tutorial;
    }

    public void setTutorial(Tutorial tutorial){
        this.tutorial = tutorial;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setNumber(Long number) {
        this.number = number;
    }
}
