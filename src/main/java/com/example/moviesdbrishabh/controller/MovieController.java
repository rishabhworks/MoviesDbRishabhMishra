// Student ID: 991753573, Full Name: Rishabh Mishra
package com.example.moviesdbrishabh.controller;

import com.example.moviesdbrishabh.entity.Movie;
import com.example.moviesdbrishabh.service.MovieService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/")
    public String listMovies(Model model) {
        model.addAttribute("movies", movieService.getAllMovies());
        return "index";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("movie", new Movie());
        return "AddMovie"; // Updated to match AddMovie.html
    }

    @PostMapping("/save")
    public String saveMovie(@Valid @ModelAttribute Movie movie, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "AddMovie"; // Updated to match AddMovie.html
        }
        movieService.saveMovie(movie);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        movieService.getMovieById(id).ifPresent(movie -> model.addAttribute("movie", movie));
        return "AddMovie"; // Updated to match AddMovie.html
    }

    @GetMapping("/delete/{id}")
    public String deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
        return "redirect:/";
    }

    @GetMapping("/search")
    public String searchMovies(@RequestParam String name, Model model) {
        model.addAttribute("movies", movieService.searchMoviesByName(name));
        return "search";
    }
}
