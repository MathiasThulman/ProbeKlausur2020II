package Collector;

import Sensor.DataBank;
import Sensor.DataBankImpl;
import TCP.Connection;

public class CollectorImpl implements Collector {
    private DataBank dataBank = new DataBankImpl();
    @Override
    public Connection acceptConnection(int portNumber) {
        return null;
    }

}
