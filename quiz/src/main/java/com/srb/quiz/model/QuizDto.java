package com.srb.quiz.model;

public class QuizDto {
    private String category;
    private int num;
    private String title;

    public QuizDto()
    {

    }

    public QuizDto(String category, int num, String title) {
        this.category = category;
        this.num = num;
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
