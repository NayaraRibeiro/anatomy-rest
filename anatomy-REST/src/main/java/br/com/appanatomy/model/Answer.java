package br.com.appanatomy.model;

public class Answer {
    private int id;
    private String answer;

    public Answer(int id, String answer) {
        this.id = id;
        this.answer = answer;
    }

    public int getId() {
        return id;
    }

    public String getAnswer() {
        return answer;
    }
}

