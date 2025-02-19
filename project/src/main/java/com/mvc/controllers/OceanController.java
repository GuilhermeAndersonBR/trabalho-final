package com.mvc.controllers;

import com.errors.CannotCreateException;
import com.errors.OutOfRangeException;
import com.mvc.models.ocean.Ocean;
import com.mvc.views.OceanView;

public class OceanController extends Controller {
    
    private final OceanView view;

    public OceanController(OceanView view) {

        super("project/src/main/resources/data/data.json");

        this.view = view;

    }

    public Ocean createOcean() throws CannotCreateException {

        try {

            float height = this.view.getHeight();

            Ocean ocean = new Ocean(height);

            return ocean;
            
        } catch (CannotCreateException | OutOfRangeException ex) {

            throw new CannotCreateException(ex.getMessage());

        }

    }

}
