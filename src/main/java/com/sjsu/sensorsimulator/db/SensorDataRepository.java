package com.sjsu.sensorsimulator.db;

import com.sjsu.sensorsimulator.models.SensorData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface SensorDataRepository extends JpaRepository<SensorData, String> {

    @Query(value= "SELECT s FROM SensorData s WHERE s.sensorId like CONCAT('%',:sensorId, '%') AND (s.date BETWEEN :startDate AND :endDate)")
    List<SensorData> getSensorDataByDate(@Param("sensorId") String sensorId, @Param("startDate") Date startDate, @Param("endDate") Date endDate);


}