package br.com.appanatomy.model;

public class Question {
    private int id;
    private String title;
    private Answer correctAnswer;

    public Question(int id, String title, Answer answer) {
        this.id = id;
        this.title = title;
        this.correctAnswer = answer;

    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Answer getCorrectAnswer() {
        return correctAnswer;
    }
}
