package com.sjsu.sensorsimulator.db;

import com.sjsu.sensorsimulator.helpers.SensorProvider;
import com.sjsu.sensorsimulator.models.SensorData;
import com.sjsu.sensorsimulator.models.Station;
import com.sjsu.sensorsimulator.models.sensors.AddSensorRequest;
import com.sjsu.sensorsimulator.models.sensors.Sensor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class StationDataProvider {
    // private Session session;
    private final StationRepository stationRepository;
    private final SensorRepository sensorRepository;
    private final SensorDataRepository sensorDataRepository;

    @Autowired
    public StationDataProvider(StationRepository stationRepository, SensorRepository sensorRepository, SensorDataRepository sensorDataRepository) {
        this.stationRepository = stationRepository;
        this.sensorRepository = sensorRepository;
        this.sensorDataRepository = sensorDataRepository;
    }
    //get all stations
    public List<Station> getStations(){
        List<Station> stations = (List<Station>) stationRepository.findAll();
        return stations;
    }
    //get one station
    public Station getStation(String id) {
        Optional<Station> station = stationRepository.findById(id);
        return station.orElse(null);
    }

    //get list of sensors--old
    public List<Sensor> getSensors(){
        return (List<Sensor>) sensorRepository.findAll();
    }

    //get one sensor--new
    public Sensor getSensorById(String id) {
        Optional<Sensor> sensor = sensorRepository.findById(id);
        //if (sensor == null) {
        //throw new ResourceNotFoundException(id, "user not found");
        //}
        return sensor.orElse(null);
    }

    //add station
    public void addStation(Station stationRequest){

        stationRepository.save(stationRequest);
    }

    //add sensor to station or update station--old
    public void addSensorToStation(String id, AddSensorRequest sensor) {
        Station station = getStation(id);
        station.getSensors().add(SensorProvider.getSensor(sensor.getType(), sensor.getName(),station));
        stationRepository.save(station);
    }

    //delete sensor from station
    public void deleteSensorFromStation(String id,String sensorid) {
        Station station = getStation(id);

        List<Sensor> sensors = station.getSensors();

        for(int i=0;i<sensors.size();i++){
            if(sensors.get(i).getSensorId()== sensorid)
                sensors.remove(sensors.get(i));
        }
        //.remove(SensorProvider.deleteSensor(sensorid)));
        stationRepository.save(station);
    }

    //delete sensor by id
    public void deleteSensorByID(String sensorid) {
        sensorRepository.delete(getSensorById(sensorid));
    }

    //delete station
    public void deleteStation(String id){
        stationRepository.delete(getStation(id));
        // stationRepository.deleteById();
    }

    //update station by changing sensor status
    public void updateStation(String id, String sensorid){

        Station station = getStation(id);
        List<Sensor> sensors = station.getSensors();

        for(Sensor s : sensors){
            if(s.getSensorId().equals(sensorid)){
                if(s.isStatus()== true){
                    s.setStatus(false);
                }
                else{
                    s.setStatus(false);
                }
                break;
            }

        }
        stationRepository.save(station);
    }

    //update sensor
    public void updateSensor(String id){
        Sensor sensor = getSensorById(id);
        if(sensor.isStatus()== true){
            sensor.setStatus(false);
        }
        else{
            sensor.setStatus(false);
        }

        sensorRepository.save(sensor);
    }

    public void addSensorDataValues(SensorData dataReq){
        //Station station= new Station();
        sensorDataRepository.save(dataReq);
    }

    public List<SensorData> getSensorDataValues(String id, Date startDate, Date endDate) {
        List<SensorData> data = (List<SensorData>)sensorDataRepository.getSensorDataByDate(id,startDate,endDate);
        return data;
    }
}

