package com.utils;

import com.constants.Messages;
import com.errors.OutOfRangeException;

public class Range {
    
    private float min;

    private float max;

    public Range() {}

    public Range(float min, float max) throws OutOfRangeException {

        this.setMin(min);
        this.setMax(max);

    }

    public float getMin() {

        return this.min;
        
    }

    public final void setMin(float newMin) throws OutOfRangeException {

        // if(newMin > this.getMax()) throw new OutOfRangeException(
        //     String.format(Messages.CannotBeAbove.getMessage(), "mínimo", "capacidade", "máximo")
        // );

        this.min = newMin;

    }

    public float getMax() {

        return this.max;

    }

    public final void setMax(float newMax) throws OutOfRangeException {

        if(newMax < this.getMin()) throw new OutOfRangeException(
            String.format(Messages.CannotBeAbove.getMessage(), "máximo", "capacidade", "mínimo")
        );            

        this.max = newMax;

    }

}
