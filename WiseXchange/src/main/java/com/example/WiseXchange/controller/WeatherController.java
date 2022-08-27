package com.example.WiseXchange.controller;

import java.text.ParseException;
import java.util.List;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.*;

import com.example.WiseXchange.models.Example;

import com.example.WiseXchange.services.WeatherService;


@RestController
public class WeatherController {

    private final WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }

    @RequestMapping("forecast/{city}")
    public List<Example> getWeatherForFive(
            @PathVariable String city) throws ParseException, JSONException {
        return this.weatherService.getWeatherForFive(city);
    }

    @RequestMapping("weather/{city}")
    public List<Example> getWeather(
            @PathVariable String city) throws JSONException {
        return this.weatherService.getWeather(city);
    }



}
