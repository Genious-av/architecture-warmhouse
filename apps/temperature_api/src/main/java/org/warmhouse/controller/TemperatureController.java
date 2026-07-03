package org.warmhouse.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PathVariable;
import org.warmhouse.model.TemperatureModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.warmhouse.service.TemperatureService;


@RestController
@RequiredArgsConstructor
public class TemperatureController {

    private final TemperatureService service;

    @GetMapping("/temperature/{sensorId}")
    public ResponseEntity<TemperatureModel> getTemperature(
            @PathVariable(required = false) Integer sensorId,
            @RequestParam(required = false) String location) {
        System.out.printf("requested sensorId: {}, location: {}", sensorId, location);
        TemperatureModel response = service.getTemperature(sensorId, location);
        return ResponseEntity.ok(response);
    }
}
