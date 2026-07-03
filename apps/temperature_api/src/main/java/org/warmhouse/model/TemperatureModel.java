package org.warmhouse.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@AllArgsConstructor
@Builder
public class TemperatureModel {
    private double value;
    private String unit;
    private Instant timestamp;
    private String location;
    private String status;
    @JsonProperty("sensor_id")
    String sensorId;
    @JsonProperty("sensor_type")
    String sensorType;
    private String description;
}
