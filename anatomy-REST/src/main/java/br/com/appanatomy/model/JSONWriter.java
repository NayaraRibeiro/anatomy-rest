package br.com.appanatomy.model;

import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;


public class JSONWriter
{

    @SuppressWarnings("unchecked")
    public static void main (String[] args) {
        Theme themeObject = new Theme();

        themeObject.setThemeId(1);
        themeObject.setThemeName("Cabeça e pescoço");

        JSONObject jsonObject = new JSONObject();

        FileWriter writeFile = null;

        jsonObject.put("ID", themeObject.getThemeId());
        jsonObject.put("Name", themeObject.getThemeName());

        try {
            writeFile = new FileWriter("theme.json");
            writeFile.write(jsonObject.toString());
            writeFile.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(jsonObject);
    }

}
