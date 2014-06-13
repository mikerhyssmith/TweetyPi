package com.TweetyPi.Link;

import jssc.SerialPort;
import jssc.SerialPortException;

public class Connector {
	public void writeToScreen(String input) throws Exception{
	    SerialPort serialPort = new SerialPort("/dev/ttyACM0");
	    try {   	
	        serialPort.openPort();//Open serial port
	        serialPort.setParams(SerialPort.BAUDRATE_9600, 
	                            SerialPort.DATABITS_8,
	                            SerialPort.STOPBITS_1,
	                            SerialPort.PARITY_NONE);//Set params. Also you can set params by this string: serialPort.setParams(9600, 8, 1, 0);
			String data = input;
			try 
            { 
            	Thread.sleep(2000); 
            } catch (InterruptedException ie) {}
	        serialPort.writeBytes(data.getBytes());//Write data to port
	        try{
	        	Thread.sleep(1000);
	        }catch(InterruptedException ie){}
			serialPort.closePort();//Close serial port
	    }
		catch (SerialPortException ex) {
			System.out.println(ex);
        }
    }
}