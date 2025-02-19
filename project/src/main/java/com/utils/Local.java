package com.utils;

import com.constants.Messages;
import com.errors.CannotBeSameException;

public abstract class Local<T> {
    
    private T from;
    private T to;

    public Local() {}
    public Local(T from, T to) throws CannotBeSameException {
        
        this.setFrom(from);
        this.setTo(to);

    }

    public T getFrom() {

        return this.from;

    }

    public final void setFrom(T newFrom) throws CannotBeSameException {

        if(newFrom.equals(this.getTo())) throw new CannotBeSameException(
            String.format(Messages.CannotBeSameError.getMessage(), "de", "para")
        );

        this.from = newFrom;

    }

    public T getTo() {
        
        return this.to;

    }

    public final void setTo(T newTo) throws CannotBeSameException {

        if(newTo.equals(this.getFrom())) throw new CannotBeSameException(
            String.format(Messages.CannotBeSameError.getMessage(), "para", "de")
        );

        this.to = newTo;

    }

}
