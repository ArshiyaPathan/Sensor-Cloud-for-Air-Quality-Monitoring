package com.sjsu.sensorsimulator.controllers;

import com.sjsu.sensorsimulator.db.StationDataProvider;
import com.sjsu.sensorsimulator.models.Station;
import com.sjsu.sensorsimulator.models.sensors.AddSensorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stations")
public class StationController {

    @Autowired
    StationDataProvider stationDataProvider;


    @RequestMapping(value = "/all")
    public ResponseEntity<List> getAllStations() {
        return ResponseEntity.ok(stationDataProvider.getStations());
    }

    @RequestMapping(value = "/count")
    public ResponseEntity<Integer> getStationCount(){
        return ResponseEntity.ok(stationDataProvider.getStations().size());
    }

    @RequestMapping(value = "/{id}/")
    public ResponseEntity<Station> getStationInfo(@PathVariable String id){

        Station station = stationDataProvider.getStation(id);
        if(station == null) {
            throw new ResourceNotFoundException();
        }else {
            return ResponseEntity.ok(station);
        }
    }

    @RequestMapping(value = "/{id}/sensors", method = RequestMethod.POST)
    public String addSensor(@PathVariable String id, @RequestBody AddSensorRequest sensorRequest){
        stationDataProvider.addSensorToStation(id, sensorRequest);
        return "accepted";
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public class ResourceNotFoundException extends RuntimeException {

    }

}
