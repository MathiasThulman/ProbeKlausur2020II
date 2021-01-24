package Sensor;

import TCP.Client;
import TCP.Connection;
import TCP.TCPConnector;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class SensorImpl implements Sensor {
    DataBank dataBank;
    int portNumber;
    OutputStream os;

    public SensorImpl(DataBank dataBank) {
        this.dataBank = dataBank;
    }

    //for test purposes
    public SensorImpl() {
    }

    @Override
    public void addDatatoFile(SensorData data) throws MissingParameterException, EmptyObjectException {
    }

    @Override
    public void connectAsClient(int portNumber) throws IOException {
        this.portNumber = portNumber;
        Client client = new TCPConnector();
        Connection connection = client.connect("hostname", portNumber);

        this.os = connection.getOutPutStream();
    }

    @Override
    public void sendToCollector() {
        DataOutputStream dos = new DataOutputStream(this.os);

    }
}
