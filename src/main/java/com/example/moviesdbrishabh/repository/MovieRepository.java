// Student ID: 991753573, Full Name: Rishabh Mishra
package com.example.moviesdbrishabh.repository;

import com.example.moviesdbrishabh.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findByNameContainingIgnoreCase(String name);
}
