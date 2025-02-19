package com.mvc.views;

import com.errors.CannotCreateException;
import com.errors.OutOfRangeException;
import com.mvc.models.river.River;

public class RiverView {
    
    public River createRiver(float height) throws CannotCreateException {

        try {

            River river = new River(height);

            System.out.println("Rio criado com sucesso!");

            return river;

        } catch (OutOfRangeException ex) {

            throw new CannotCreateException(
                String.format("Ocorreu um erro ao criar o rio: %s", ex.getMessage())
            );

        }

    }

    public float getHeight() throws CannotCreateException {

        try {
            
            System.out.print("Digite a altura do rio (em metros): ");

            float height = Float.parseFloat(System.console().readLine());

            return height;

        } catch (NumberFormatException e) {
            
            throw new CannotCreateException(
                String.format("Não foi possível criar \"altura\": %s", e.getMessage())
            );
        
        }

    }

}
