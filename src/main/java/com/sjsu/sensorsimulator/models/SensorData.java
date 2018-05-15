package com.sjsu.sensorsimulator.models;

import javax.persistence.*;
import java.util.Date;

import com.sjsu.sensorsimulator.models.sensors.Sensor;

@Entity
public class SensorData {

    @Id
    private String entryNo;
    private String sensorId;
    private Date date;
    private String AQI;
    private String unitOfMeasurement;

    public String getEntryNo() {
        return entryNo;
    }

    public void setEntryNo(String entryNo) {
        this.entryNo = entryNo;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAQI() {
        return AQI;
    }

    public void setAQI(String AQI) {
        this.AQI = AQI;
    }

    public String getUnitOfMeasurement() {
        return unitOfMeasurement;
    }

    public void setUnitOfMeasurement(String unitOfMeasurement) {
        this.unitOfMeasurement = unitOfMeasurement;
    }

    public String getSensorId() {
        return sensorId;
    }

    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }
}