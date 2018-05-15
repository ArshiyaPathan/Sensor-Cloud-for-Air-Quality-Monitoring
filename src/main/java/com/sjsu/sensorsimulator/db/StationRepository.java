package com.sjsu.sensorsimulator.db;

import com.sjsu.sensorsimulator.models.Station;
import org.springframework.data.repository.CrudRepository;

public interface StationRepository extends CrudRepository<Station,String>{

}

