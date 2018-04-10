package com.sjsu.sensorsimulator.models.sensors;

public class AddSensorRequest {

    private String name;
    private SensorType type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SensorType getType() {
        return type;
    }

    public void setType(SensorType type) {
        this.type = type;
    }
}
