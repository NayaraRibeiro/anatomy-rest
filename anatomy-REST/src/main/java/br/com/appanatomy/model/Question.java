package br.com.appanatomy.model;

import java.util.List;

public class Question {
    private int id;
    private String title;
    private Answer correctAnswer;
    private List<Answer> incorrectAnswers;

    public Question(int id, String title, Answer answer, List<Answer> incorrectAnswers) {
        this.id = id;
        this.title = title;
        this.correctAnswer = answer;
        this.incorrectAnswers = incorrectAnswers;

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

    public List<Answer> getIncorrectAnswers() {
        return incorrectAnswers;
    }

}
