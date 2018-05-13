package com.sjsu.sensorsimulator.db;

import com.sjsu.sensorsimulator.models.Station;
import org.springframework.data.repository.CrudRepository;

public interface StationRepository extends CrudRepository<Station,String>{
   // @Query("select s.id, s.name from station s")
    //List<station> getstationDetails();
}

