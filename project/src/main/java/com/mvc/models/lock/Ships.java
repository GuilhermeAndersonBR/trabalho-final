package com.mvc.models.lock;

import java.util.ArrayList;
import java.util.Optional;

import com.constants.Messages;
import com.errors.CannotBeNullException;
import com.errors.InvalidIndexException;
import com.mvc.models.ship.classes.Ship;

public class Ships {

    private final ArrayList<Ship> ships = new ArrayList<>();

    public void add(Ship ship) throws CannotBeNullException {

        Optional<Ship> verifiedShip = Optional.ofNullable(ship);

        if(!verifiedShip.isPresent()) throw new CannotBeNullException(
            String.format(
                Messages.CannotBeNull.getMessage(), 
                "navios", 
                "Navios"
            )
        );

        this.ships.add(ship);

    }

    public Optional<Ship> get(int index) throws InvalidIndexException {

        if(index < 0 || index > this.ships.size() - 1) throw new InvalidIndexException(
            String.format(Messages.InvalidIndexError.getMessage(), "receber um navio", "Navios")
        );

        return Optional.ofNullable(this.ships.get(index));

    }

    public Optional<Ship> first() throws InvalidIndexException {

        return this.get(0);

    }

    public void remove(int index) throws InvalidIndexException {

        if(index < 0 || index > this.ships.size() - 1) throw new InvalidIndexException(
            String.format(Messages.InvalidIndexError.getMessage(), "remover um navio", "Navios")
        );

        this.ships.remove(index);

    }

    public void removeFirst() throws InvalidIndexException {

        this.remove(0);

    }

}
