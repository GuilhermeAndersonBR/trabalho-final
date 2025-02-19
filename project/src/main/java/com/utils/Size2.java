package com.utils;

import com.constants.Messages;
import com.errors.OutOfRangeException;

public class Size2 {
    
    private float width;
    private float height;

    public Size2() {}
    public Size2(float width, float height) throws OutOfRangeException {

        this.setWidth(width);
        this.setHeight(height);

    }

    public float getWidth() {

        return this.width;

    }

    public final void setWidth(float newWidth) throws OutOfRangeException {

        if(newWidth < 0) throw new OutOfRangeException(
            String.format(Messages.OutOfRangeError.getMessage(), "largura", "tamanho")
        );

        this.width = newWidth;

    }

    public float getHeight() {

        return this.height;

    }

    public final void setHeight(float newHeight) throws OutOfRangeException {

        if(newHeight < 0) throw new OutOfRangeException(
            String.format(Messages.OutOfRangeError.getMessage(), "altura", "tamanho")
        );

        this.height = newHeight;

    }

}
