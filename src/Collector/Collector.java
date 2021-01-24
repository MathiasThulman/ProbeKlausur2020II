package Collector;

import TCP.Connection;

public interface Collector {
    /**
     * listen om port and accept a client as host establishinga connection
     * @return Connection from which to get os and is
     */
    Connection acceptConnection(int portNumber);

}
