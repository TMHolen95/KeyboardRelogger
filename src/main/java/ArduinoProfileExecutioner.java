/**
 * Created by Tor Martin Holen on 06-Sep-17.
 */

import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import profiles.ArduinoProfile;
import profiles.BaseProfile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Enumeration;


public class ArduinoProfileExecutioner implements SerialPortEventListener {
    private boolean executingCommand = false;
    private BaseProfile p;

    SerialPort serialPort;
    /** The port we're normally going to use. */
    private static final String PORT_NAMES[] = {
            //"/dev/tty.usbserial-A9007UX1", // Mac OS X
            //"/dev/ttyACM0", // Raspberry Pi
            //"/dev/ttyUSB0", // Linux
            "COM5", // Windows
    };
    /**
     * A BufferedReader which will be fed by a InputStreamReader
     * converting the bytes into characters
     * making the displayed results codepage independent
     */
    private BufferedReader input;
    /** The output stream to the port */
    private OutputStream output;
    /** Milliseconds to block while waiting for port open */
    private static final int TIME_OUT = 2000;
    /** Default bits per second for COM port. */
    private static final int DATA_RATE = 9600;

    public void initialize(BaseProfile profile) {

        p = profile;

        CommPortIdentifier portId = null;
        Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();

        //First, Find an instance of serial port as set in PORT_NAMES.
        while (portEnum.hasMoreElements()) {
            CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();
            for (String portName : PORT_NAMES) {
                if (currPortId.getName().equals(portName)) {
                    portId = currPortId;
                    break;
                }
            }
        }
        if (portId == null) {
            System.out.println("Could not find COM port.");
            return;
        }

        try {
            // open serial port, and use class name for the appName.
            serialPort = (SerialPort) portId.open(this.getClass().getName(),
                    TIME_OUT);

            // set port parameters
            serialPort.setSerialPortParams(DATA_RATE,
                    SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);

            // open the streams
            input = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));
            output = serialPort.getOutputStream();

            // add event listeners
            serialPort.addEventListener(this);
            serialPort.notifyOnDataAvailable(true);
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

    private void startKeyTimer(int key) {
        p.getKeyActionMap().get(key).getKeyTimer().start();
    }

    /**
     * This method reads the
     * @param key decides which timer to reset
     * @return the final value, before reseting
     */
    private int resetKeyTimer(int key) {
        return p.getKeyActionMap().get(key).getKeyTimer().getTimePressed();
    }

    /**
     * This should be called when you stop using the port.
     * This will prevent port locking on platforms like Linux.
     */
    public synchronized void close() {
        if (serialPort != null) {
            serialPort.removeEventListener();
            serialPort.close();
        }
    }

    /**
     * Handle an event on the serial port. Read the data and print it.
     */
    public synchronized void serialEvent(SerialPortEvent oEvent) {
        if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
            try {
                String inputLine=input.readLine();
                System.out.println(inputLine);

                String action = inputLine.substring(0,1);
                int key = Integer.parseInt(inputLine.substring(1));
                if(action.equals("P")){
                    startKeyTimer(key);
                } else if(action.equals("R")) {
                    p.execute(key, resetKeyTimer(key));
                    // TODO finish number format error stuff
                }

            } catch (Exception e) {
                System.err.println(e.toString());
            }
        }
        // Ignore all the other eventTypes, but you should consider the other ones.
    }

    public static void main(String[] args) throws Exception {
        ArduinoProfileExecutioner main = new ArduinoProfileExecutioner();
        main.initialize(new ArduinoProfile());
        Thread t = new Thread(() -> {
            //the following line will keep this app alive for 1000 seconds,
            //waiting for events to occur and responding to them (printing incoming messages to console).
            try {Thread.sleep(1000000);} catch (InterruptedException ie) {}
        });
        t.start();
        System.out.println("Started");
    }
}