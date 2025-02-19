package com.mvc.models.ship.classes;

import java.util.Optional;

import com.constants.Messages;
import com.errors.CannotBeNullException;
import com.errors.OutOfRangeException;
import com.mvc.models.ship.enums.Country;
import com.mvc.models.ship.enums.Type;
import com.mvc.models.ship.mapping.Containers;
import com.utils.Size2;

public final class Ship {

    private String code;
    
    private Size2 size;

    private final Containers containers;

    private final Destiny destiny = new Destiny();

    private Type type;

    private Country country;

    private String captain;

    private final Direction direction = new Direction();

    public Ship() {this.containers = new Containers();
}
    public Ship(Size2 size, Country country, Type type, String captain, float maxLoad) throws CannotBeNullException, OutOfRangeException {
        
        this.containers = new Containers(maxLoad);

        this.setSize(size);
        this.setCountry(country);
        this.setType(type);
        this.setCaptain(captain);
        this.setMaxLoad(maxLoad);

    }

    public String getCode() {

        return this.code;

    }

    public void setCode(String newCode) {

        this.code = newCode;

    }

    public float getMaxLoad() {
        
        return this.containers.getMaxLoad();
    
    }

    public void setMaxLoad(float newMaxLoad) throws OutOfRangeException {

        this.containers.setMaxLoad(newMaxLoad);

    }

    public Destiny getDestiny() {

        return this.destiny;

    }

    public Country getCountry() {

        return this.country;

    }

    public void setCountry(Country newCountry) throws CannotBeNullException {

        Optional<Country> verifiedNewCountry = Optional.ofNullable(newCountry);

        if(!verifiedNewCountry.isPresent()) throw new CannotBeNullException(
            String.format(
                Messages.CannotBeNull.getMessage(), 
                "país", 
                "Navio"
            )
        );

        this.country = newCountry;

    }

    public String getCaptain() {

        return this.captain;

    }

    public void setCaptain(String newCaptain) throws CannotBeNullException {
        
        Optional<String> verifiedNewCaptain = Optional.ofNullable(newCaptain);

        if(!verifiedNewCaptain.isPresent()) throw new CannotBeNullException(
            String.format(
                Messages.CannotBeNull.getMessage(), 
                "capitão", 
                "Navio"
            )
        );

        this.captain = verifiedNewCaptain.get();

    }

    public Containers getContainers() {

        return this.containers;
        
    }

    public Size2 getSize() {

        return this.size;

    }

    public void setSize(Size2 newSize) throws CannotBeNullException {

        Optional<Size2> verifiedNewSize = Optional.ofNullable(newSize);

        if(!verifiedNewSize.isPresent()) throw new CannotBeNullException(
            String.format(
                Messages.CannotBeNull.getMessage(), 
                "tamanho", 
                "Navio"
            )
        );

        this.size = newSize;

    }

    public Direction getDirection() {

        return this.direction;

    }

    public Type getType() {
        
        return this.type;

    }

    public void setType(Type newType) throws CannotBeNullException {

        Optional<Type> verifiedNewType = Optional.ofNullable(newType);

        if(!verifiedNewType.isPresent()) throw new CannotBeNullException(
            String.format(
                Messages.CannotBeNull.getMessage(), 
                "tamanho", 
                "Navio"
            )
        );

        this.type = newType;

    }

    public float getMoney() {

        return this.type.getFixedValue() + this.type.getPerContainer() * this.containers.all().size() + this.type.getPerKilo() * this.containers.getTotalContainersWeight();

    }

}
