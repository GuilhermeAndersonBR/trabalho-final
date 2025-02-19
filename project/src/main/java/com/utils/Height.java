package com.utils;

import com.constants.Messages;
import com.errors.OutOfRangeException;

public class Height {
    
    private float height;

    public Height() {}
    public Height(float height) throws OutOfRangeException {

        this.setHeight(height);

    }

    public float getHeight() {

        return this.height;

    }

    public final void setHeight(float newHeight) throws OutOfRangeException {

        if(newHeight < 0) throw new OutOfRangeException(
            String.format(Messages.OutOfRangeError.getMessage(), "altura", "altura")
        );

        this.height = newHeight;

    }

}
