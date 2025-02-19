package com.mvc.views;

import com.errors.CannotCreateException;
import com.errors.OutOfRangeException;
import com.mvc.models.ocean.Ocean;

public class OceanView {
    
    public Ocean createOcean(float height) throws CannotCreateException {

        try {

            Ocean ocean = new Ocean(height);

            System.out.println("Oceano criado com sucesso!");

            return ocean;

        } catch (OutOfRangeException ex) {

            throw new CannotCreateException(
                String.format("Ocorreu um erro ao criar o oceano: %s", ex.getMessage())
            );

        }

    }

    public float getHeight() throws CannotCreateException {

        try {
            
            System.out.print("Digite a altura do oceano (em metros): ");

            float height = Float.parseFloat(System.console().readLine());

            return height;

        } catch (NumberFormatException e) {
            
            throw new CannotCreateException(
                String.format("Não foi possível criar \"altura\": %s", e.getMessage())
            );
        
        }

    }

}
