package ArschTests;
import Sensor.SensorImpl;
import Sensor.Sensor;
import Sensor.SensorData;
import Sensor.SensorDataImpl;
import org.junit.Assert;
import org.junit.Test;
import Sensor.MissingParameterException;
import Sensor.EmptyObjectException;
import Sensor.EmptyListException;
import Sensor.StatusException;

import java.io.*;
import java.net.Socket;

public class SensorTests {
    private final int PORTNUM = 6969;

    @Test
    public void validFileSafeTest() throws IOException, EmptyObjectException, MissingParameterException {
        long timeStamp = 23;
        float value = 34;
        String sensorName = "Sensor";
        String fileName = "sensorData.txt";
        SensorData data = new SensorDataImpl(timeStamp, value, sensorName);

        //saving in a file

        Sensor sensor = new SensorImpl();
        sensor.addDatatoFile(data);
    }

    @Test
    public void sendToCollectorTest() throws IOException, EmptyObjectException, MissingParameterException {
        long timeStamp1 = 23;
        float value1 = 34;
        String sensorName1 = "Sensor1";
        String fileName1 = "sensorData.txt";
        
        long timeStamp2 = 45455;
        float value2 = 65;
        String sensorName2 = "Sensor2";
        
        SensorData data1 = new SensorDataImpl(timeStamp1, value1, sensorName1);
        SensorData data2 = new SensorDataImpl(timeStamp2,value2, sensorName2);
        
        Sensor sensor = new SensorImpl();
        
        //add the data to the file
        sensor.addDatatoFile(data1);
        sensor.addDatatoFile(data2);

        //read file to for test

        FileInputStream fis = new FileInputStream("wherever the Sensor saves this");
        DataInputStream dis = new DataInputStream(fis);

        Assert.assertEquals(data1.getTimeStamp(), dis.readLong());
        Assert.assertEquals(data1.getValue(), dis.readFloat(), 0.5);
        Assert.assertEquals(data1.getSensorName(), dis.readUTF());

        Assert.assertEquals(data2.getTimeStamp(), dis.readUTF());
        Assert.assertEquals(data2.getValue(), dis.readFloat(), 0.5);
        Assert.assertEquals(data2.getSensorName(), dis.readUTF());
    }

    @Test(expected = MissingParameterException.class)
    void noFileNameTest() throws EmptyObjectException, MissingParameterException {
        long timeStampt = 23;
        float value = 22;
        String SensorName = "";

        SensorData data = new SensorDataImpl(timeStampt, value, SensorName);

        Sensor sensor = new SensorImpl();
        sensor.addDatatoFile(data);
    }

    @Test(expected = EmptyObjectException.class)
    void emptyObjectTest() throws EmptyObjectException, MissingParameterException {
        SensorData data = null;

        Sensor sensor = new SensorImpl();

        sensor.addDatatoFile(data);
    }

    @Test(expected = StatusException.class)
    public void sendBeforeConnectTest() throws IOException, StatusException {
        Sensor sensor = new SensorImpl();

        sensor.sendToCollector();
    }

    @Test(expected = EmptyListException.class)
    public void noListSendToCollectorTest() throws IOException, StatusException {
        Sensor sensor = new SensorImpl();

        sensor.connectAsClient(PORTNUM);

        sensor.sendToCollector();
    }

    @Test
    public void playingAroundFos() throws IOException {
        FileOutputStream fos = new FileOutputStream("Senf.txt");
        Socket socket = new Socket("localhost", 6969);

        OutputStream os = socket.getOutputStream();
        DataOutputStream dos = new DataOutputStream(fos);

    }
}
