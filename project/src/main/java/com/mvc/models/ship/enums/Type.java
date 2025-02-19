package com.mvc.models.ship.enums;

public enum Type {
    
    BulkCarriers("Graneleiro",2.25f, 20.0f, 2000.0f),
    GeneralCago("Carga Geral", 5.25f, 0.0f, 15000f),
    Container("Contêiner", 0.0f, 30.0f, 10000f);

    private final String type;
    private final float perKilo;
    private final float perContainer;
    private final float fixedValue;

    Type(String type, float perKilo, float perContainer, float fixedValue) {

        this.type = type;
        this.perKilo = perKilo;
        this.perContainer = perContainer;
        this.fixedValue = fixedValue;

    }

    public String getType() {

        return this.type;

    }

    public float getPerKilo() {
        
        return this.perKilo;
    
    }

    public float getPerContainer() {
        
        return this.perContainer;
    
    }

    public float getFixedValue() {
        
        return this.fixedValue;
    
    }

}
