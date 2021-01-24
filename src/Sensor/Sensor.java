package Sensor;

import TCP.Connection;

import java.io.IOException;

public interface Sensor {
    //not really necessary since to databank does its job
    /**
     * add another SensorDataObjekt to the Sensor
     */
    void addDatatoFile(SensorData data) throws MissingParameterException, EmptyObjectException;

    /**
     * establish connection with collector
     * @return Connection objekt with os and is available
     */
    void connectAsClient(int portNumber) throws IOException;

    /**
     * sends all available data to collector
     * @throws IOException when connection issues occur
     * @throws StatusException when called before connected to collector
     */
    void sendToCollector() throws IOException, StatusException;
}
