package org.crockeo.bongomerouter.io.osc;

import org.crockeo.bongomerouter.io.IOManager;

import com.illposed.osc.OSCListener;
import com.illposed.osc.OSCMessage;

import java.util.Date;

public class OscIn
		implements OSCListener {
	private String lastReceived;
	private StringBuilder lastReceivedBuilder;
	
	public OscIn() {
		lastReceivedBuilder = new StringBuilder();
	}
	
	public void acceptMessage(Date date,
							  OSCMessage message) {
		// Getting the argument
		Object[] arguments = message.getArguments();
		
		// Changing them to strings
		String[] strArguments = new String[arguments.length];
		for (int i = 0; i < arguments.length; i++)
			strArguments[i] = String.valueOf(arguments[i]);
		
		// Creating lastReceived
		lastReceivedBuilder.delete(0, lastReceivedBuilder.length());
		for (String s: strArguments)
			lastReceivedBuilder.append(s).append(" ");
		lastReceived = lastReceivedBuilder.toString();

		// Parsing
		if(strArguments[1] == "/led_all") {
			IOManager.instance().getSerialOut().ledAll(Integer.parseInt(strArguments[2]));
		} else if(strArguments[1] == "/led") {
			IOManager.instance().getSerialOut().led(Integer.parseInt(strArguments[0]), Integer.parseInt(strArguments[1]), Integer.parseInt(strArguments[2]));
		} else if (strArguments[1] == "/led_col") {
			IOManager.instance().getSerialOut().ledCol(Integer.parseInt(strArguments[0]), Integer.parseInt(strArguments[1]));
		} else if (strArguments[1] == "/led_row") {
			IOManager.instance().getSerialOut().ledRow(Integer.parseInt(strArguments[0]), Integer.parseInt(strArguments[1]));
		} else if (strArguments[1] == "/rgb_single") {
			IOManager.instance().getSerialOut().rgbSingle(Integer.parseInt(strArguments[0]), Integer.parseInt(strArguments[1]), Integer.parseInt(strArguments[2]), Integer.parseInt(strArguments[3]), Integer.parseInt(strArguments[4]));
		} else if (strArguments[1] == "/rgb_col") {
			IOManager.instance().getSerialOut().rgbCol(Integer.parseInt(strArguments[0]), Integer.parseInt(strArguments[1]), Integer.parseInt(strArguments[2]), Integer.parseInt(strArguments[3]));
		} else if (strArguments[1] == "/rgb_row") {
			IOManager.instance().getSerialOut().rgbRow(Integer.parseInt(strArguments[0]), Integer.parseInt(strArguments[1]), Integer.parseInt(strArguments[2]), Integer.parseInt(strArguments[3]));
		} else if (strArguments[1] == "/rgb_all") {
			IOManager.instance().getSerialOut().rgbAll(Integer.parseInt(strArguments[0]), Integer.parseInt(strArguments[1]), Integer.parseInt(strArguments[2]));
		}
	}
	
	// Accessors
	public String getLastReceived() { return lastReceived; }
}
