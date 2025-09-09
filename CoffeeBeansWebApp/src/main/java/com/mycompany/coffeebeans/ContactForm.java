package com.mycompany.coffeebeans;
//Author: Ilir Tzaferai//
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named("contactForm")
@RequestScoped
public class ContactForm {

    private String name;
    private String email;
    private String message;

    public String send() {
        // Simulate sending message (log or print)
        System.out.println("Contact Form Submitted:");
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Message: " + message);
        return null; // stay on same page
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}
