package com;

import com.data.DataBase;
import com.errors.CannotCreateException;
import com.mvc.controllers.LockController;
import com.mvc.controllers.ShipController;
import com.mvc.models.lock.Lock;
import com.mvc.views.LockView;
import com.mvc.views.ShipView;

public class Main {

    private static boolean closeApp = false;

    private static DataBase database = new DataBase();

    public static void main(String[] args) {

        while(true) {

            System.out.println("1. Rodar simulação");
            System.out.println("2. Configurações");
            System.out.println("3. Sair");

            System.err.print("Digite a opção: ");
            int input = Integer.parseInt(System.console().readLine());

            switch (input) {

                case 1 -> {
                    System.out.println("A ser implementado :)");
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
                            case 3 -> {

                                ShipView shipView = new ShipView();

                                ShipController shipController = new ShipController(shipView);

                                LockView lockView = new LockView();

                                LockController lockController = new LockController(lockView, shipController);

                                Lock lock = lockController.createLock();

                                Main.database.setLock(lock);

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