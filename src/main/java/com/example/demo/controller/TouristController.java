package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Tourist;
import com.example.demo.repository.TouristRepository;

import io.swagger.v3.oas.annotations.Parameter;

@RestController
@RequestMapping("/api/tourists")
public class TouristController {

    @Autowired
    private TouristRepository repository;

    @GetMapping
    public List<Tourist> getAllTourists(
            @Parameter(description = "Custom authentication token (e.g., ABC123)", required = false)
            @RequestHeader(value = "Token", required = false) String token) {
        return repository.findAll();
    }

    @PostMapping
    public Tourist addTourist(
            @RequestHeader(value = "Token", required = false) String token,
            @RequestBody Tourist tourist) {
        return repository.save(tourist);
    }
}
