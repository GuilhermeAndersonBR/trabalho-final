package com.mvc.models.ship.enums;


public enum Country {

    Eua("Estados Unidos da América"),
    China("China"),
    Chile("Chile"),
    Canada("Canadá"),
    France("França"),
    Germany("Alemanha"),
    Polony("Polônia"),
    India("Índia"),
    Brazil("Brasil");

    private final String country;

    Country(String country) {

        this.country = country;

    }

    public String getCountry() {
        
        return this.country;
    
    }

}
