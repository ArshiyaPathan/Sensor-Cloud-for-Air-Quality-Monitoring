package com.sjsu.sensorsimulator.models;

import javax.persistence.*;
import java.util.Date;

import com.sjsu.sensorsimulator.models.sensors.Sensor;

@Entity
public class SensorData {

    @Id
    private String entryNo;
    //@ManyToOne(cascade= CascadeType.ALL)
    //@JoinColumn(name = "sensor_id")
    //private Sensor sensor;
    private String sensorId;

    // @Temporal(TemporalType.TIMESTAMP)
    //@Column(name = "date", columnDefinition = "DATETIME")
    private Date date;
    private String AQI;
    private String unitOfMeasurement;


    public String getEntryNo() {
        return entryNo;
    }

    public void setEntryNo(String entryNo) {
        this.entryNo = entryNo;
    }

    public String getSensorId() {
        return sensorId;
    }

    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
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
