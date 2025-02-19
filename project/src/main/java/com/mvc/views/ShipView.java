package com.mvc.views;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.errors.CannotBeNullException;
import com.errors.CannotBeSameException;
import com.errors.CannotCreateException;
import com.errors.OutOfRangeException;
import com.mvc.models.ship.classes.Container;
import com.mvc.models.ship.classes.Ship;
import com.mvc.models.ship.enums.Country;
import com.mvc.models.ship.enums.Directions;
import com.mvc.models.ship.enums.Type;
import com.utils.Size2;

public class ShipView {

    public Ship createShip(Size2 size, Country country, Type type, String captain, float maxLoad) throws CannotCreateException, OutOfRangeException {

        try {

            Ship ship = new Ship(size, country, type, captain, maxLoad);

            ship.setCode("code-" + LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));

            System.out.println("Navio criado com sucesso!");

            return ship;

        } catch (CannotBeNullException ex) {

            throw new CannotCreateException(
                String.format("Ocorreu um erro ao criar o navio: %s", ex.getMessage())
            );
        
        }

    }
    
    public Size2 getSize() throws CannotCreateException {

        try {
            
            System.out.print("Digite a altura do navio (em metros): ");

            float height = Float.parseFloat(System.console().readLine());

            System.out.print("Digite a largura do navio (em metros): ");

            float width = Float.parseFloat(System.console().readLine());

            return new Size2(width, height);

        } catch (OutOfRangeException | NumberFormatException e) {
            
            throw new CannotCreateException(
                String.format("Não foi possível criar \"tamanho\": %s", e.getMessage())
            );
        
        }

    }

    public Type getType() throws CannotCreateException {

        try {
            
            System.out.println("1. Graneleiro");
            System.out.println("1. Carga Geral");
            System.out.println("3. Contêiner");

            System.out.print("Digite o tipo do navio: ");

            int type = Integer.parseInt(System.console().readLine());

            switch (type) {
                case 1 -> {
                    return Type.BulkCarriers;
                }
                case 2 -> {
                    return Type.GeneralCago;
                }
                case 3 -> {
                    return Type.Container;
                }
                default -> throw new AssertionError();
            } 

        } catch (NumberFormatException e) {
            
            throw new CannotCreateException(
                String.format("Não foi possível criar \"tipo\": %s", e.getMessage())
            );
        
        }

    }

    public String getCaptain() throws CannotCreateException {

        try {

            System.out.print("Digite o nome do capitão: ");

            String captain = System.console().readLine();

            return captain;

        } catch (Exception e) {
            
            throw new CannotCreateException(
                String.format("Não foi possível criar \"capitão\": %s", e.getMessage())
            );
        
        }

    }

    public Country getCountry() throws CannotCreateException {

        try {
            
            System.out.println("1. Estados Unidos da América");
            System.out.println("2. China");
            System.out.println("3. Chile");
            System.out.println("4. Canadá");
            System.out.println("5. França");
            System.out.println("6. Alemanha");
            System.out.println("7. Polônia");
            System.out.println("8. Índia");
            System.out.println("9. Brasil");

            System.out.print("Digite a nacionalidade do navio: ");

            int country = Integer.parseInt(System.console().readLine());

            switch (country) {
                case 1 -> {
                    return Country.Eua;
                }
                case 2 -> {
                    return Country.China;
                }
                case 3 -> {
                    return Country.Chile;
                }
                case 4 -> {
                    return Country.Canada;
                }
                case 5 -> {
                    return Country.France;
                }
                case 6 -> {
                    return Country.Germany;
                }
                case 7 -> {
                    return Country.Polony;
                }
                case 8 -> {
                    return Country.India;
                }
                case 9 -> {
                    return Country.Brazil;
                }
                default -> throw new AssertionError();
            } 

        } catch (NumberFormatException e) {
            
            throw new CannotCreateException(
                String.format("Não foi possível criar \"nacionalidade\": %s", e.getMessage())
            );
        
        }

    }

    public float getMaxLoad() throws CannotCreateException {

        try {

            System.out.print("Digite a carga máxima do navio (em toneladas): ");

            float maxLoad = Float.parseFloat(System.console().readLine());

            return maxLoad;

        } catch (NumberFormatException e) {
            
            throw new CannotCreateException(
                String.format("Não foi possível criar \"carga máxima\": %s", e.getMessage())
            );
        
        }

    }

    private boolean continueInput(String input) {
        
        System.out.println(input);
        
        String response = System.console().readLine();

        return response.toUpperCase().equals("Y");

    }

    public Container getContainer() throws CannotCreateException {

        try {

            System.out.print("Digite o peso do contêiner (em toleladas): ");

            float weight = Float.parseFloat(System.console().readLine());

            return new Container(weight);

        } catch (NumberFormatException | OutOfRangeException e) {
            
            throw new CannotCreateException(
                String.format("Não foi possível criar \"contêiner\": %s", e.getMessage())
            );
        
        }

    }

    public void defineContainers(Ship ship) {

        System.err.println("criando contêiners...");

        while(true) {

            try {

                Container container = this.getContainer();

                ship.getContainers().add(container);

            } catch (CannotCreateException | CannotBeNullException | OutOfRangeException e) {
                
                System.err.println(e.getMessage());

            }

            if(!this.continueInput("Deseja criar outro contêiner? (Y/N)")) break; 

        }

    }

    public void defineDestiny(Ship ship) throws CannotCreateException {

        System.out.print("Digite o porto de saída: ");

        String from = System.console().readLine();

        System.out.print("Digite o porto de chegada: ");

        String to = System.console().readLine();

        try {

            ship.getDestiny().setFrom(from);
            ship.getDestiny().setTo(to);

        } catch (CannotBeSameException e) {

            throw new CannotCreateException(
                String.format("Ocorreu um erro ao definir \"destino\": %s", e.getMessage())
            );

        }

    }

    public void defineDirection(Ship ship) throws CannotCreateException {

        System.out.println("1. Rio");
        System.out.println("2. Oceano");
        System.out.print("Digite o local de saída: ");

        int from = Integer.parseInt(System.console().readLine());

        System.out.print("Digite o local de chegada: ");

        int to = Integer.parseInt(System.console().readLine());

        try {

            switch (from) {
                case 1 -> {
                    ship.getDirection().setFrom(Directions.River);
                }
                case 2 -> {
                    ship.getDirection().setFrom(Directions.Ocean);
                }
                default -> throw new AssertionError();
            }

            switch (to) {
                case 1 -> {
                    ship.getDirection().setTo(Directions.River);
                }
                case 2 -> {
                    ship.getDirection().setTo(Directions.Ocean);
                }
                default -> throw new AssertionError();
            }

        } catch (CannotBeSameException e) {

            throw new CannotCreateException(
                String.format("Ocorreu um erro ao definir \"destino\": %s", e.getMessage())
            );
            
        }

    }

    public void drawShip(Ship ship) {

        System.out.println(String.format("código: %s", ship.getCode()));
        System.out.println(String.format("tipo de navio: %s", ship.getType().getType()));
        System.out.println(String.format("capitão: %s", ship.getCaptain()));
        System.out.println(String.format("tamanho: largura:%.2f, altura:%.2f", ship.getSize().getWidth(), ship.getSize().getHeight()));
        System.out.println(String.format("número de contêiners: %d", ship.getContainers().all().size()));
        System.out.println(String.format("país: %s", ship.getCountry().getCountry()));
        System.out.println(String.format("saída: %s, chegada: %s", ship.getDestiny().getFrom(), ship.getDestiny().getTo()));
        System.out.println(String.format("do: %s, para: %s", ship.getDirection().getFrom(), ship.getDirection().getTo()));
        System.out.println(String.format("carga máxima: %.2f", ship.getMaxLoad()));

    } 

}
