package com.mvc.models.ship.classes;

import com.errors.CannotBeSameException;
import com.utils.Local;


public class Destiny extends Local<String> {

    public Destiny() {}
    public Destiny(String from, String to) throws CannotBeSameException {

        super(from, to);

    }

    @Override
    public String getFrom() {

        return super.getFrom();

    }

    @Override
    public String getTo() {

        return super.getTo();

    }

}
