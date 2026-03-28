package com.bezkoder.spring.datajpa.model;

public class StepDTO {

    private Long id;
    private String title;
    private String text;
    private Long number;
    private Long tutorialId;
    private String tutorialTitle;

    public StepDTO() {
    }

    public StepDTO(Step step) {
        this.id =step.getId();
        this.title = step.getTitle();
        this.text = step.getText();
        this.number = step.getNumber();
        this.tutorialTitle = step.getTutorial().getTitle();
        this.tutorialId = step.getTutorial().getId();
    }

    public Long getId () {return id;}

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public Long getNumber() {
        return number;
    }

    public Long getTutorialId() {
        return tutorialId;
    }

    public String getTutorialTitle() {
        return tutorialTitle;
    }

}
