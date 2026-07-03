package org.warmhouse.service;

import org.warmhouse.model.TemperatureModel;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class TemperatureService {

    public TemperatureModel getTemperature(Integer sensorId, String location) {
        if (sensorId == null && (location == null || location.isBlank())) {
            throw new RuntimeException("Either sensorId or location must be provided");
        }
        if (location == null || location.isBlank()) {
            location = switch (sensorId) {
                case 1 -> "Living Room";
                case 2 -> "Bedroom";
                case 3 -> "Kitchen";
                case null, default -> "Unknown";
            };
        }

        if (sensorId == null) {
            sensorId = switch (location) {
                case "Living Room" -> 1;
                case "Bedroom" -> 2;
                case "Kitchen" -> 3;
                default -> 0;
            };
        }

        return TemperatureModel.builder()
                .value(ThreadLocalRandom.current()
                        .nextInt(-400, 401) / 10.0)
                .unit("Celsius")
                .timestamp(Instant.now())
                .location(location)
                .status("OK")
                .sensorId(String.valueOf(sensorId))
                .sensorType("Thermometer")
                .description("Temperature sensor in " + location)
                .build();
    }
}
