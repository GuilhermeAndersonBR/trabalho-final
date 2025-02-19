package com.mvc.controllers;

import com.errors.CannotBeNullException;
import com.errors.CannotCreateException;
import com.mvc.models.lock.Lock;
import com.mvc.models.ship.classes.Ship;
import com.mvc.views.LockView;
import com.mvc.views.ShipView;
import com.utils.Size2;

public class LockController extends Controller {
    
    private final LockView lockView;
    private final ShipController shipController;

    public LockController(LockView lockView, ShipController shipController) {

        super("project/src/main/resources/data/data.json");

        this.lockView = lockView;
        this.shipController = shipController;

    }

    public Lock createLock() throws CannotCreateException {
        
        try {

            Size2 size = this.lockView.getSize();

            float flow = this.lockView.getFlow();

            Lock lock = this.lockView.creatLock(size, flow);

            this.lockView.defineCapacity(lock);

            this.createShips(lock);

            return lock;
            
        } catch (CannotCreateException ex) {

            throw new CannotCreateException(ex.getMessage());

        }

    }

    private boolean continueInput(String input) {
        
        System.out.println(input);
        
        String response = System.console().readLine();

        return response.toUpperCase().equals("Y");

    }

    public void createShips(Lock lock) {

        System.out.println("Criando navios...");

        while(true) {

            try {

                Ship ship = this.shipController.createShip();

                lock.getShips().add(ship);
            
            } catch (CannotCreateException | CannotBeNullException e) {

                System.err.println(String.format("Ocorreu um erro: %s", e.getMessage()));
            
            }

            if(!this.continueInput("Deseja criar outro navio? (Y/N)")) break;

        }

    }

}
