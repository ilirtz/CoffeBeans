package com.mycompany.testapp;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("testBean")
@SessionScoped
public class TestBean implements Serializable {

    private List<String> coffees = new ArrayList<>();
    private String status = "Not loaded";

    public void loadBeans() {
        System.out.println("✅ loadBeans() method called");
        coffees.clear();
        coffees.add("Espresso");
        coffees.add("Latte");
        coffees.add("Cappuccino");
        status = "Beans loaded!";
    }

    public List<String> getCoffees() {
        return coffees;
    }

    public String getStatus() {
        return status;
    }
}
