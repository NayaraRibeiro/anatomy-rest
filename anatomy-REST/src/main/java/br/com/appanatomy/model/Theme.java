package br.com.appanatomy.model;

public class Theme {
    private int themeId;
    private String themeName;

    public Theme(String themeName){
       this.themeName = themeName;
    }

    public Theme() {

    }

    public int getThemeId(){
        return themeId;
    }

    public String getThemeName(){
        return themeName;
    }

    public void setThemeId(int themeId){
        this.themeId = themeId;
    }

    public void setThemeName(String themeName){
        this.themeName = themeName;
    }
}