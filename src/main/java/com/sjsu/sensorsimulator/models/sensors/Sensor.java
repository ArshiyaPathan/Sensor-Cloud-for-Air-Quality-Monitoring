package com.sjsu.sensorsimulator.models.sensors;

import com.sjsu.sensorsimulator.models.Station;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Sensor {

    @Id @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String sensorId;
    private boolean status;
    private String name;
    private SensorType sensorType;

    //(cascade=CascadeType.ALL)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "station_id")
    private Station station;

    public Sensor(){

    }

    public Sensor(String name, SensorType sensorType, Station station) {
        //this.sensorId = ";
        this.name = name;
        this.sensorType = sensorType;
        this.station = station;
        this.status = true;
    }

    public String getSensorId() {
        return sensorId;
    }

    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SensorType getSensorType() {
        return sensorType;
    }

    public void setSensorType(SensorType sensorType) {
        this.sensorType = sensorType;
    }
}
