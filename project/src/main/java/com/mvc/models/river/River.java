package com.mvc.models.river;

import com.errors.OutOfRangeException;
import com.utils.Height;

public class River extends Height {
    
    public River() {}
    public River(float height) throws OutOfRangeException {

        super(height);

    }

}
