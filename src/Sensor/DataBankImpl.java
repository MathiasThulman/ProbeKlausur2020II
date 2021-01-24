package Sensor;

import org.w3c.dom.CDATASection;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;

public class DataBankImpl implements DataBank {
    private LinkedList<SensorData> dataList = new LinkedList<>();

    @Override
    public void addDatatoFile(SensorData data) throws IOException {
        dataList.add(data);

        FileOutputStream fos = new FileOutputStream("fileBackup.txt");
        DataOutputStream dos = new DataOutputStream(fos);
        dos.writeLong(data.getTimeStamp());
        dos.writeFloat(data.getValue());
        dos.writeUTF(data.getSensorName());
    }

    @Override
    public float getAverage() throws EmptyListException {
        if(this.dataList.size() == 0){
            throw new EmptyListException();
        }
        int av = 0;
        for (SensorData sensorData : this.dataList) {
            av += sensorData.getValue();
        }
        av = av/this.dataList.size();
        return av;
    }

    @Override
    public float getAverageOfSensor(String sensorName) throws NoSuchSensorException, EmptyListException {
        if(this.dataList.size() == 0){
            throw new EmptyListException();
        }
        int av = 0;
        int counter = 0;
        for (SensorData sensorData : this.dataList) {
            if(sensorData.getSensorName().equals(sensorName)) {
                av += sensorData.getValue();
                counter ++;
            }
        }
        if(counter == 0){
            throw new NoSuchSensorException();
        }
        av = av/counter;
        return av = 0;
    }
}
