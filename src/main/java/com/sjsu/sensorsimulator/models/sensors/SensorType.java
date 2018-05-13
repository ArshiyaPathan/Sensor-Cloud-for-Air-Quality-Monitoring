package com.sjsu.sensorsimulator.models.sensors;

public enum SensorType {

    CARBON_MONOXIDE_SENSOR("CARBON_MONOXIDE_SENSOR"),
    OZONE_SENSOR("OZONE_SENSOR"),
    NITROGEN_DIOXIDE_SENSOR("NITROGEN_DIOXIDE_SENSOR"),
    SULPHOR_DIOXIDE_SENSOR("SULPHOR_DIOXIDE_SENSOR");

    String value;

    SensorType(String value) {
        this.value = value;
    }
}
