package Sensor;

public class MissingParameterException extends Exception {
    public MissingParameterException () {super(); }
    public MissingParameterException (String message) { super(message); }
}
