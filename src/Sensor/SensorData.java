package Sensor;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

public interface SensorData {
    /**
     *
     * @return the time of when the data was collected
     */
    long getTimeStamp();

    /**
     *
     * @return value of the collection in this case temperature
     */
    float getValue();

    /**
     *
     * @return the name of the sensor
     */
    String getSensorName();
}
