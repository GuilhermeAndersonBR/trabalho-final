package com.mvc.models.ship.classes;

import com.errors.CannotBeSameException;
import com.mvc.models.ship.enums.Directions;
import com.utils.Local;

public class Direction extends Local<Directions> {

    public Direction() {}
    public Direction(Directions from, Directions to) throws CannotBeSameException {

        super(from, to);

    }

}
