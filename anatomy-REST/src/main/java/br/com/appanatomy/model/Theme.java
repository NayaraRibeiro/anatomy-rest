package br.com.appanatomy.model;

public class Theme {
    private int id;
    private String name;

    public Theme(String name){
       this.name = name;
    }

    public Theme() {

    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }
}