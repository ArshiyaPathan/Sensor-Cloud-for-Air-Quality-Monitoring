package com.sjsu.sensorsimulator.controllers;

import com.sjsu.sensorsimulator.db.StationDataProvider;
import com.sjsu.sensorsimulator.models.sensors.Sensor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
//import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.util.List;

@RestController
@RequestMapping("/sensors")
public class SensorController {

    @Autowired
    StationDataProvider stationDataProvider;

   //view sensors
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Sensor> getAllSensors(){
        return  stationDataProvider.getSensors();
    }

    //update sensor by id
    @RequestMapping(value ="/{id}", method = RequestMethod.PUT)
    public String updateSensor(@PathVariable String id){
        stationDataProvider.updateSensor(id);
        return "sensor updated";
    }

    //get sensor by id
    @RequestMapping(value ="/{id}", method = RequestMethod.GET)
    public ResponseEntity<Sensor> getSensorbyID(@PathVariable String id){

        Sensor sensor = stationDataProvider.getSensorById(id);
        if(sensor == null) {
            throw new ResourceNotFoundException();
        }else
            return ResponseEntity.ok(sensor);
    }

    @RequestMapping(value= "/{id}",method = RequestMethod.DELETE)
    public String deleteSensorByID(@PathVariable String id){
        stationDataProvider.deleteSensorByID(id);
        return "Sensor deleted";
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public class ResourceNotFoundException extends RuntimeException {

    }

}
