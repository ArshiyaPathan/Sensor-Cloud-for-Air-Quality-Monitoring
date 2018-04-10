package com.sjsu.sensorsimulator.db;

import com.sjsu.sensorsimulator.helpers.SensorProvider;
import com.sjsu.sensorsimulator.models.Station;
import com.sjsu.sensorsimulator.models.sensors.AddSensorRequest;
import com.sjsu.sensorsimulator.models.sensors.Sensor;
import com.sjsu.sensorsimulator.models.sensors.SensorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class StationDataProvider {

    private final StationRepository stationRepository;
    private final SensorRepository sensorRepository;

    @Autowired
    public StationDataProvider(StationRepository stationRepository, SensorRepository sensorRepository) {
        this.stationRepository = stationRepository;
        this.sensorRepository = sensorRepository;
    }

    public List<Station> getStations(){
        List<Station> stations = (List<Station>) stationRepository.findAll();
        if(stations.size() == 0){
            Station station1 = new Station();
            station1.setStationName("first_station");
            Station station2 = new Station();
            station2.setStationName("second_station");

            station1.getSensors().add(SensorProvider.getSensor(SensorType.OZONE_SENSOR,"ozoneSensor1", station1));
            station1.getSensors().add(SensorProvider.getSensor(SensorType.CARBON_MONOXIDE_SENSOR,"carbonSensor1", station1));
            station1.getSensors().add(SensorProvider.getSensor(SensorType.HUMIDITY_SENSOR,"humiditySensor1", station1));
            station2.getSensors().add(SensorProvider.getSensor(SensorType.OZONE_SENSOR,"ozoneSensor1", station2));
            station2.getSensors().add(SensorProvider.getSensor(SensorType.CARBON_MONOXIDE_SENSOR,"carbonSensor1", station2));
            station2.getSensors().add(SensorProvider.getSensor(SensorType.HUMIDITY_SENSOR,"humiditySensor1", station2));


            stations.add(station1);
            stations.add(station2);

            stationRepository.saveAll(stations);
        }
        return stations;
    }

    public Station getStation(String id) {
        Optional<Station> station = stationRepository.findById(id);
        return station.orElse(null);
    }

    public void addSensorToStation(String id, AddSensorRequest sensor) {
        Station station = getStation(id);
        station.getSensors().add(SensorProvider.getSensor(sensor.getType(), sensor.getName(),station));
        stationRepository.save(station);
    }

    public List<Sensor> getSensors(){
        return (List<Sensor>) sensorRepository.findAll();
    }
}
