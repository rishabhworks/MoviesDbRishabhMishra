// Student ID: 991753573, Full Name: Rishabh Mishra
package com.example.moviesdbrishabh.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Movie name is required")
    @Size(min = 1, max = 100, message = "Movie name must be between 1 and 100 characters")
    @Column(nullable = false)
    private String name;

    @NotNull(message = "Genre is required")
    @Column(nullable = false)
    private String genre;

    @NotNull(message = "Language is required")
    @Column(nullable = false)
    private String language;

    @NotNull(message = "Duration is required")
    @Min(value = 10, message = "Duration must be at least 10 minutes")
    @Max(value = 300, message = "Duration must not exceed 300 minutes")
    @Column(nullable = false)
    private int duration;

    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.01", message = "Price must be greater than 0")
    @Column(nullable = false)
    private double price;

    // Default constructor
    public Movie() {
    }

    // Parameterized constructor
    public Movie(Long id, String name, String genre, String language, int duration, double price) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.language = language;
        this.duration = duration;
        this.price = price;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
