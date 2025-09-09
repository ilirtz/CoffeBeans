package com.mycompany.coffeebeans;
//Author: Ilir Tzaferai//
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;

@Named("orderBean")
@SessionScoped
public class OrderBean implements Serializable {

    private String coffeeName;
    private double pricePerKg;
    private int quantityKg;
    private double total;

    public String placeOrder() {
        total = quantityKg * pricePerKg;
        return null; // stay on same page
    }

    // Getters and Setters
    public String getCoffeeName() {
        return coffeeName;
    }

    public void setCoffeeName(String coffeeName) {
        this.coffeeName = coffeeName;
    }

    public double getPricePerKg() {
        return pricePerKg;
    }

    public void setPricePerKg(double pricePerKg) {
        this.pricePerKg = pricePerKg;
    }

    public int getQuantityKg() {
        return quantityKg;
    }

    public void setQuantityKg(int quantityKg) {
        this.quantityKg = quantityKg;
    }

    public double getTotal() {
        return total;
    }
}
