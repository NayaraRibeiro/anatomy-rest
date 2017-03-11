package br.com.appanatomy.model;

public class Question {
    private int id;
    private String title;

    public Question(int id, String title) {
    this.id = id;
    this.title = title;

    }

    public int getId() {
        return id;
    }

    public String getTitle(){
        return title;
    }
}
