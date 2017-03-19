package br.com.appanatomy.model;

import java.util.List;


public class SubTheme {
    private int id;
    private String name;
    private List<Question> questions;

    public SubTheme() {

    }

    public SubTheme(int id, String name, List<Question> questions) {
        this.id = id;
        this.name = name;
        this.questions = questions;
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

