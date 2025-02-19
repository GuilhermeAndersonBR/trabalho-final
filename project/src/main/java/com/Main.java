package com;

import java.util.Optional;

import com.data.DataBase;
import com.errors.CannotCreateException;
import com.errors.InvalidIndexException;
import com.mvc.controllers.LockController;
import com.mvc.controllers.OceanController;
import com.mvc.controllers.RiverController;
import com.mvc.controllers.ShipController;
import com.mvc.models.lock.Lock;
import com.mvc.models.ocean.Ocean;
import com.mvc.models.river.River;
import com.mvc.models.ship.classes.Ship;
import com.mvc.views.LockView;
import com.mvc.views.OceanView;
import com.mvc.views.RiverView;
import com.mvc.views.ShipView;

public class Main {

    private static boolean closeApp = false;

    private static DataBase database = new DataBase();

    private static void showSimulation(OceanView oceanView, RiverView riverView, LockView lockView) throws InvalidIndexException {
        
        Ocean ocean = Main.database.getOcean();
        River river = Main.database.getRiver();
        Lock lock = Main.database.getLock();

        Optional<Ship> currentShip = lock.getShips().first();

        while(currentShip.isPresent()) {

            Ship verifiedCurrentShip = currentShip.get();

            lock.setValue(verifiedCurrentShip.getMoney());

        }

    }

    public static void main(String[] args) {

        OceanView oceanView = new OceanView();
        RiverView riverView = new RiverView();
        LockView lockView = new LockView();

        while(true) {

            System.out.println("1. Rodar simulação");
            System.out.println("2. Configurações");
            System.out.println("3. Sair");

            System.err.print("Digite a opção: ");
            int input = Integer.parseInt(System.console().readLine());

            switch (input) {

                case 1 -> {

                    try {

                        Main.showSimulation(oceanView, riverView, lockView);

                    } catch (InvalidIndexException ex) {
                        
                        System.err.println(ex.getMessage());

                    }

                }
                case 2 -> {

                    try {
                        
                        System.out.println("1. Criar Oceano");
                        System.out.println("2. Criar Rio");
                        System.out.println("3. Criar Eclusa");
                        System.out.println("4. Resetar");

                        System.err.print("Digite a opção: ");
                        int createInput = Integer.parseInt(System.console().readLine());

                        switch (createInput) {
                            case 1 -> {

                                OceanController oceanController = new OceanController(oceanView);

                                Ocean ocean = oceanController.createOcean();

                                Main.database.setOcean(ocean);

                            }
                            case 2 -> {

                                RiverController riverController = new RiverController(riverView);

                                River river = riverController.createRiver();

                                Main.database.setRiver(river);

                            }
                            case 3 -> {

                                ShipView shipView = new ShipView();

                                ShipController shipController = new ShipController(shipView);

                                LockController lockController = new LockController(lockView, shipController);

                                Lock lock = lockController.createLock();

                                Main.database.setLock(lock);

                            }
                            case 4 -> {

                                Main.database.reset();

                            }
                            default -> throw new AssertionError();
                        }

                    } catch(CannotCreateException e) {

                        System.err.println(e.getMessage());

                    }

                }
                case 3 -> { Main.closeApp = true; } 
                default -> throw new AssertionError();

            }

            if(closeApp) break;

        }
        
    }

}