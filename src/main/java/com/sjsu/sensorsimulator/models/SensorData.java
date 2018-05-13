package com.sjsu.sensorsimulator.models;

import javax.persistence.*;
import java.util.Date;

import com.sjsu.sensorsimulator.models.sensors.Sensor;

@Entity
public class SensorData {

    @Id
    private String entryNo;
    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "sensor_id")
    private Sensor sensor;
    private Date date;
    private String unitOfMeasurement;
    private String AQI;

    public String getEntryNo() {
        return entryNo;
    }

    public void setEntryNo(String entryNo) {
        this.entryNo = entryNo;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUnitOfMeasurement() {
        return unitOfMeasurement;
    }

    public void setUnitOfMeasurement(String unitOfMeasurement) {
        this.unitOfMeasurement = unitOfMeasurement;
    }

    public String getAQI() {
        return AQI;
    }

    public void setAQI(String AQI) {
        this.AQI = AQI;
    }
}
