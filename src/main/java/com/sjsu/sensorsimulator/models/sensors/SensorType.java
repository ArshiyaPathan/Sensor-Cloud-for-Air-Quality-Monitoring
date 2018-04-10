package com.sjsu.sensorsimulator.models.sensors;

public enum SensorType {

    CARBON_MONOXIDE_SENSOR("CARBON_MONOXIDE_SENSOR"),
    OZONE_SENSOR("OZONE_SENSOR"),
    HUMIDITY_SENSOR("HUMIDITY_SENSOR");

    String value;

    SensorType(String value) {
        this.value = value;
    }
}
