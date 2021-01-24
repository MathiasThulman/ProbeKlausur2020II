package Sensor;

import java.io.*;

public class SensorDataImpl implements SensorData {

    private long timeStamp;
    private String sensorName;
    private float value;

    public SensorDataImpl(long timeStamp, float value, String sensorName) {
        this.timeStamp = timeStamp;
        this.value = value;
        this.sensorName = sensorName;
    }

    @Override
    public long getTimeStamp() {
        return this.timeStamp;
    }

    @Override
    public float getValue() {
        return this.value;
    }

    @Override
    public String getSensorName() {
        return this.sensorName;
    }

//    @Override
//    public void saveTofile(String fileName) throws IOException {
//        FileOutputStream fos = new FileOutputStream(fileName);
//        DataOutputStream dos = new DataOutputStream(fos);
//
//        dos.writeLong(this.timeStamp);
//        dos.writeFloat(this.value);
//        dos.writeUTF(this.sensorName);
//
//        dos.close();
//    }
}
