package com.mycompany.coffeebeans;
//Author: Ilir Tzaferai//
public class CoffeeBean {
    private int id;
    private String name;
    private String origin;
    private String roastLevel;
    private String flavorNotes;
    private double pricePerKg;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getOrigin() { return origin; }
    public void setOrigin(String origin) { this.origin = origin; }

    public String getRoastLevel() { return roastLevel; }
    public void setRoastLevel(String roastLevel) { this.roastLevel = roastLevel; }

    public String getFlavorNotes() { return flavorNotes; }
    public void setFlavorNotes(String flavorNotes) { this.flavorNotes = flavorNotes; }

    public double getPricePerKg() { return pricePerKg; }
    public void setPricePerKg(double pricePerKg) { this.pricePerKg = pricePerKg; }
}
