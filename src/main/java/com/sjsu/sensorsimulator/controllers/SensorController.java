package com.sjsu.sensorsimulator.controllers;

import com.sjsu.sensorsimulator.db.StationDataProvider;
import com.sjsu.sensorsimulator.models.sensors.Sensor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sensors")
public class SensorController {
    final
    StationDataProvider stationDataProvider;

    @Autowired
    public SensorController(StationDataProvider stationDataProvider) {
        this.stationDataProvider = stationDataProvider;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Sensor> getAllSensors(){
        return  stationDataProvider.getSensors();
    }

}
