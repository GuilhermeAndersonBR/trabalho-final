package com.mvc.controllers;

import java.io.IOException;

import com.errors.CannotCreateException;
import com.errors.OutOfRangeException;
import com.mvc.models.ship.classes.Ship;
import com.mvc.models.ship.enums.Country;
import com.mvc.models.ship.enums.Type;
import com.mvc.views.ShipView;
import com.utils.Size2;

public class ShipController extends Controller {
    
    private final ShipView view;

    public ShipController(ShipView view) {

        super("project/src/main/resources/data/data.json");

        this.view = view;

    }

    public Ship createShip() throws CannotCreateException {

        try {

            Size2 size = this.view.getSize();

            String captain = this.view.getCaptain();

            Type type = this.view.getType();

            Country country = this.view.getCountry();

            float maxLoad = this.view.getMaxLoad();

            Ship ship = this.view.createShip(size, country, type, captain, maxLoad);

            this.view.defineContainers(ship);

            this.view.defineDestiny(ship);

            this.view.defineDirection(ship);

            return ship;
            
        } catch (CannotCreateException | OutOfRangeException ex) {

            throw new CannotCreateException(ex.getMessage());

        }

    }

}
