package com.sjsu.sensorsimulator.db;

import com.sjsu.sensorsimulator.models.sensors.Sensor;
import org.springframework.data.repository.CrudRepository;

public interface SensorRepository extends CrudRepository<Sensor,String> {
}
