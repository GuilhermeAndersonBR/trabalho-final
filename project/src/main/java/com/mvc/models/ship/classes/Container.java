package com.mvc.models.ship.classes;

import com.constants.Messages;
import com.errors.OutOfRangeException;

public class Container {
    
    private float weight;

    public Container() {}
    public Container(float weight) throws OutOfRangeException {

        this.setWeight(weight);

    }

    public float getWeight() {
        
        return this.weight;
    
    }

    public final void setWeight(float newWeight) throws OutOfRangeException {
        
        if(newWeight < 0) throw new OutOfRangeException(
            String.format(Messages.OutOfRangeError.getMessage(), "peso", "contêiner")
        );

        this.weight = newWeight;
    
    }

    

}
