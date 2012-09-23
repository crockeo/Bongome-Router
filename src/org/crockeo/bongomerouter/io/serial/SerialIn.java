package org.crockeo.bongomerouter.io.serial;

import org.crockeo.bongomerouter.io.IOManager;

import gnu.io.UnsupportedCommOperationException;
import gnu.io.SerialPortEventListener;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPort;

import java.io.IOException;
import java.io.InputStream;

/*
 * Class: SerialIn
 * 
 * Purpose:
 *  Handling the input from the serial port.
 */

public class SerialIn
		implements SerialPortEventListener {
	private InputStream in;
	private boolean changed;
	private String lastReceived;
	
	public SerialIn(SerialPort port) {
		try { in = port.getInputStream(); }
		catch (IOException e) { e.printStackTrace(); }
	}
	
	public void serialEvent(SerialPortEvent e) {
		if (e.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
			try {
				lastReceived = String.valueOf(in.read());
				changed = true;
			} catch (IOException ex) {
				System.err.println("Data avaiable but cannot be read.");
				changed = false;
			}
		}
		
		if (changed) {
			// TODO: Implement Osc out
		}
	}
	
	// Accessors
	public String getLastReceived() { return lastReceived; }
}
