package ArschTests;

import Sensor.*;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class DataBankTests {
    //just some data to test with
    private final long timeStamp1 = 23;
    private final float value1 = 34;
    private final String sensorName1 = "Sensor";

    @Test
    public void validTest() throws EmptyObjectException, MissingParameterException, IOException {
        SensorData data = new SensorDataImpl(timeStamp1, value1, sensorName1);

        DataBank dataBank = new DataBankImpl();
        dataBank.addDatatoFile(data);
    }

    @Test(expected = EmptyListException.class)
    public void emptyListTest() throws EmptyListException {
        DataBank dataBank = new DataBankImpl();

        dataBank.getAverage();
    }

    @Test(expected = NoSuchSensorException.class)
    public void sensorNotFoundTest() throws EmptyObjectException, MissingParameterException, NoSuchSensorException, EmptyListException, IOException {
        DataBank dataBank = new DataBankImpl();

        dataBank.addDatatoFile(new SensorDataImpl(timeStamp1, value1, sensorName1));

        dataBank.getAverageOfSensor("Sensor2");
    }

    @Test
    public void getAverageMarginTest() throws EmptyObjectException, MissingParameterException, EmptyListException, IOException {
        DataBank dataBank = new DataBankImpl();

        dataBank.addDatatoFile(new SensorDataImpl(timeStamp1, 0, sensorName1));

        dataBank.getAverage();
    }

    @Test(expected = MissingParameterException.class)
    public void emptySensorNameTest() throws EmptyObjectException, MissingParameterException, IOException {
        DataBank dataBank = new DataBankImpl();

        dataBank.addDatatoFile(new SensorDataImpl(timeStamp1, value1, ""));
    }

    @Test
    public void sensorNameMarginTest() throws EmptyObjectException, MissingParameterException, IOException {
        DataBank dataBank = new DataBankImpl();

        dataBank.addDatatoFile(new SensorDataImpl(timeStamp1, value1, "l"));
    }
}
