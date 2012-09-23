package org.crockeo.bongomerouter.io.osc;

import java.net.SocketException;
import java.net.UnknownHostException;

import com.illposed.osc.OSCPortOut;

/*
 * Class: OscOut
 * 
 * Purpose:
 *  Handling sending messages back to the Osc source.
 */

// TODO: Finish implementing OscOut

public class OscOut {
	public OscOut() {
		OSCPortOut po = null;
		
		try {
			po = new OSCPortOut();
		} catch (UnknownHostException | SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
