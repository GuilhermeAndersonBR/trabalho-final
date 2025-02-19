package com.mvc.models.ship.enums;

public enum Directions {
    
    Ocean("ocean"),
    River("river");

    private final String local;
    
    Directions(String local) {

        this.local = local;

    }

    public String getLocal() {

        return this.local;

    }

}
