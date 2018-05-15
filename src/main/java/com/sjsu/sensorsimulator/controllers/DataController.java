package com.sjsu.sensorsimulator.controllers;

import com.sjsu.sensorsimulator.db.StationDataProvider;
import com.sjsu.sensorsimulator.models.SensorData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/sensordata")
public class DataController {

    @Autowired
    StationDataProvider stationDataProvider;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<List> getSensorDataValues(@PathVariable String id, @RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate){
        System.out.println("Date"+ startDate);
        System.out.println("Date"+ endDate);

        DateFormat formatter = new SimpleDateFormat("yyyy-MM-DD");
        Date start_date = null;
        Date end_date = null;
        try {
            start_date = formatter.parse(startDate);
            end_date =  formatter.parse(endDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok(stationDataProvider.getSensorDataValues(id, start_date,end_date));
    }


    @RequestMapping(value = "", method = RequestMethod.POST)
    public String addValues(@RequestBody SensorData data){
        stationDataProvider.addSensorDataValues(data);
        return "accepted";
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public class ResourceNotFoundException extends RuntimeException {

    }

}
