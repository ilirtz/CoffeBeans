package com.mycompany.coffeebeans;
//Author: Ilir Tzaferai//
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Named("coffeeBeanManager")
@SessionScoped
public class CoffeeBeanManager implements Serializable {

    private static final Logger logger = Logger.getLogger(CoffeeBeanManager.class.getName());

    private List<CoffeeBean> beans = new ArrayList<>();
    private CoffeeBean selectedBean = new CoffeeBean();
    private String statusMessage = "No beans loaded yet.";

    // Connect to Derby database in network mode
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
            "jdbc:derby://localhost:1527/coffeebeans", "user1", "pass"
        );
    }

    // Load all beans from the database
public void loadBeans() {
    System.out.println("⚙ loadBeans() method called");
    beans.clear();

    try (Connection conn = getConnection();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery("SELECT * FROM coffeebeans")) {

        int count = 0;
        while (rs.next()) {
            CoffeeBean bean = new CoffeeBean();
            bean.setId(rs.getInt("id"));
            bean.setName(rs.getString("name"));
            bean.setOrigin(rs.getString("origin"));
            bean.setRoastLevel(rs.getString("roast_level"));
            bean.setFlavorNotes(rs.getString("flavor_notes"));
            bean.setPricePerKg(rs.getDouble("price_per_kg"));
            beans.add(bean);
            count++;

            System.out.println("✅ Bean loaded: " + bean.getName());
        }

        System.out.println("✅ Total beans loaded: " + count);

    } catch (SQLException e) {
        System.err.println("❌ SQLException in loadBeans()");
        e.printStackTrace();
    }
}



    // Add a new bean to the database
    public void addBean() {
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(
                 "INSERT INTO coffeebeans (name, origin, roast_level, flavor_notes, price_per_kg) VALUES (?, ?, ?, ?, ?)")) {

            ps.setString(1, selectedBean.getName());
            ps.setString(2, selectedBean.getOrigin());
            ps.setString(3, selectedBean.getRoastLevel());
            ps.setString(4, selectedBean.getFlavorNotes());
            ps.setDouble(5, selectedBean.getPricePerKg());
            ps.executeUpdate();

            logger.info("Added bean: " + selectedBean.getName());
            loadBeans();  // Refresh list
            selectedBean = new CoffeeBean();  // Clear form
            statusMessage = "Coffee bean added successfully.";

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Failed to add bean", e);
            statusMessage = "Error adding bean.";
        }
    }

    // Getters and Setters
    public List<CoffeeBean> getBeans() {
        return beans;
    }

    public CoffeeBean getSelectedBean() {
        return selectedBean;
    }

    public void setSelectedBean(CoffeeBean selectedBean) {
        this.selectedBean = selectedBean;
    }

    public String getStatusMessage() {
        return statusMessage;
    }
}
