package br.com.appanatomy.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;


public class SubTheme {
    private int id;
    private String name;
    private int themeId;
    private List<Question> questions;

    public SubTheme(int id, String name, int themeId, List<Question> questions) {
        this.id = id;
        this.name = name;
        this.questions = questions;
        this.themeId = themeId;
    }

    public SubTheme(int id, String name, int themeId) {
        this.id = id;
        this.name = name;
        this.themeId = themeId;
    }

    public SubTheme() {

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Question> getQuestions() {
        return questions;
    }
}

