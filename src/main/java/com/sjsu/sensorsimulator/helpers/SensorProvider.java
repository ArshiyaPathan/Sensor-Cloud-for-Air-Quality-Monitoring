package com.sjsu.sensorsimulator.helpers;

import com.sjsu.sensorsimulator.models.Station;
import com.sjsu.sensorsimulator.models.sensors.Sensor;
import com.sjsu.sensorsimulator.models.sensors.SensorType;

public class SensorProvider {


    public static Sensor getSensor(SensorType sensorType, String name, Station station){
        switch (sensorType) {
            case OZONE_SENSOR: return new Sensor(name,SensorType.OZONE_SENSOR, station);
           // case HUMIDITY_SENSOR: return new Sensor(name,SensorType.HUMIDITY_SENSOR, station);
            case CARBON_MONOXIDE_SENSOR: return new Sensor(name, SensorType.CARBON_MONOXIDE_SENSOR, station);
            case NITROGEN_DIOXIDE_SENSOR: return new Sensor(name, SensorType.NITROGEN_DIOXIDE_SENSOR, station);
            case SULPHOR_DIOXIDE_SENSOR: return new Sensor(name, SensorType.SULPHOR_DIOXIDE_SENSOR, station);
            default : throw new RuntimeException(String.format("Sensor Type %s Not Supported yet.",sensorType));
        }
    }

}
