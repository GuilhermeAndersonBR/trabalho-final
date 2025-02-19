package com.mvc.controllers;

import com.errors.CannotCreateException;
import com.errors.OutOfRangeException;
import com.mvc.models.ocean.Ocean;
import com.mvc.models.river.River;
import com.mvc.views.RiverView;

public class RiverController extends Controller {
    
    private final RiverView view;

    public RiverController(RiverView view) {

        super("project/src/main/resources/data/data.json");

        this.view = view;

    }

    public River createRiver() throws CannotCreateException {

        try {

            float height = this.view.getHeight();

            River river = this.view.createRiver(height);

            return river;
            
        } catch (CannotCreateException ex) {

            throw new CannotCreateException(ex.getMessage());

        }

    }

}
