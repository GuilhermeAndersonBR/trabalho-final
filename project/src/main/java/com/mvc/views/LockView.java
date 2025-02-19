package com.mvc.views;

import com.errors.CannotCreateException;
import com.errors.OutOfRangeException;
import com.mvc.models.lock.Lock;
import com.utils.Size2;

public class LockView {
    
    public Lock creatLock(Size2 size, float flow) throws CannotCreateException {

        try {

            Lock lock = new Lock(size, flow);

            System.out.println("Eclusa criada com sucesso!");

            return lock;

        } catch (OutOfRangeException ex) {

            throw new CannotCreateException(
                String.format("Ocorreu um erro ao criar a eclusa: %s", ex.getMessage())
            );
        
        }

    }
    
    public Size2 getSize() throws CannotCreateException {

        try {
            
            System.out.print("Digite a altura da eclusa (em metros): ");

            float height = Float.parseFloat(System.console().readLine());

            System.out.print("Digite a largura da eclusa (em metros): ");

            float width = Float.parseFloat(System.console().readLine());

            return new Size2(width, height);

        } catch (OutOfRangeException | NumberFormatException e) {
            
            throw new CannotCreateException(
                String.format("Não foi possível criar \"tamanho\": %s", e.getMessage())
            );
        
        }

    }

    public void defineCapacity(Lock lock) throws CannotCreateException {

        try {

            System.out.print("Defina a capacidade mínima (em Litros): ");
            
            float min = Float.parseFloat(System.console().readLine());

            System.out.print("Defina a capacidade máxima (em Litros): ");
            
            float max = Float.parseFloat(System.console().readLine());

            lock.getCapacity().setMin(min);
            lock.getCapacity().setMax(max);

        } catch (NumberFormatException | OutOfRangeException e) {
            
            throw new CannotCreateException(
                String.format("Não foi possível criar \"capacidade\": %s", e.getMessage())
            );
        
        }
    

    }

    public float getFlow() throws CannotCreateException {

        try {
            
            System.out.print("Digite o valor do fluxo de água (em L/s): ");

            float flow = Float.parseFloat(System.console().readLine());

            return flow;

            

        } catch (NumberFormatException e) {
            
            throw new CannotCreateException(
                String.format("Não foi possível criar \"fluxo\": %s", e.getMessage())
            );

        }

    }

    public void drawLock(Lock lock) {

        System.out.println(String.format("tamanho: largura:%.2f, altura:%.2f", lock.getSize().getWidth(), lock.getSize().getHeight()));
        System.out.println(String.format("capacidade: mínima:%.2f, máxima:%.2f", lock.getCapacity().getMin(), lock.getCapacity().getMax()));
        System.out.println(String.format("fluxo: %.2f", lock.getFlow()));

    } 

}
