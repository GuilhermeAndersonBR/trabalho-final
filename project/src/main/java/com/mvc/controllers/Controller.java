package com.mvc.controllers;

import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;

public class Controller {
    
    private String path;

    private final Gson gson = new Gson();

    public Controller(String path) {

        this.setPath(path);

    }

    public void save(Object object) throws IOException {

        String jsonObject = this.gson.toJson(object);

        try(FileWriter writer = new FileWriter(this.getPath())) {

            writer.write(jsonObject);

        }

    }

    public String getPath() {
        
        return this.path;
    
    }

    public final void setPath(String newPath) {
        
        this.path = newPath;
    
    }

}
