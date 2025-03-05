// Student ID: 991753573, Full Name: Rishabh Mishra
package com.example.moviesdbrishabh.config;

import com.example.moviesdbrishabh.entity.Movie;
import com.example.moviesdbrishabh.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public void run(String... args) throws Exception {
        if (movieRepository.count() == 0) {
            movieRepository.save(new Movie(null, "The Funny Guy", "Comedy", "English", 120, 9.99));
            movieRepository.save(new Movie(null, "Tears of Tomorrow", "Drama", "French", 150, 12.50));
            movieRepository.save(new Movie(null, "Action Packed", "Action", "Other", 90, 15.00));
        }
    }
}
