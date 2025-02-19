package com.mvc.models.ocean;

import com.errors.OutOfRangeException;
import com.utils.Height;

public class Ocean extends Height {
    
    public Ocean() {}
    public Ocean(float height) throws OutOfRangeException {

        super(height);

    }

}
