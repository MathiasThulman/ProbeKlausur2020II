package Sensor;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface DataBank {
    /**
     * saves data in DataBank and writes it in a file
     * @param data
     */
    void addDatatoFile(SensorData data) throws EmptyObjectException, MissingParameterException, IOException;

    /**
     * @return the average value of all sensors
     */
    float getAverage() throws EmptyListException;

    /**
     *
     * @param SensorName name of the sensor
     * @return the average of specific sensor
     */
    float getAverageOfSensor(String SensorName) throws NoSuchSensorException, EmptyListException;

}
