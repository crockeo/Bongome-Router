package org.crockeo.bongomerouter.io.serial;

import gnu.io.SerialPort;
import java.io.*;

/*
 * Class: SerialOut
 * 
 * Purpose:
 *  Dealing with pushing serial out.
 */

public class SerialOut {
	private OutputStream output;
	
	public SerialOut(SerialPort port) {
		try { output = port.getOutputStream(); }
		catch (IOException e) { e.printStackTrace(); }
	}
	
	// All of the LED operations
	public void led(int x, int y, int value) {
		try {
			output.write((value == 1 ? 3 : 4) | 0x80);
			output.write(((x << 4) | y) & 0xff);
		} catch (IOException e) { e.printStackTrace(); }
	}

	public void ledCol(int col, int data) {
		try {
			output.write(5 | 0x80);
			output.write((col << 4) & 0xf0);
			output.write(data & 0xff);
		} catch (IOException e) { e.printStackTrace(); }
	}

	public void ledRow(int row, int data) {
		try {
		    output.write(6 | 0x80);
		    output.write(row & 0x0f);
		    output.write(data & 0xff);
		} catch (IOException e) { e.printStackTrace(); }
	}
	
	public void ledAll(int state) {
		try {
			output.write(7 | 0x80 | (state << 4));
		} catch (IOException e) { e.printStackTrace(); }
	}

	public void rgbSingle(int x, int y, int red, int green, int blue) {
		try {
			output.write(8 | 0x80);
			output.write(((x << 4) | y) & 0xff);
			output.write(red & 0xff);
			output.write(green & 0xff);
			output.write(blue & 0xff);
		} catch (IOException e) { e.printStackTrace(); }
	}

	public void rgbCol(int col, int red, int green, int blue) {
		try {
		    output.write(9 | 0x80);
		    output.write((col << 4) & 0xf0);
		    output.write(red & 0xff);
		    output.write(green & 0xff);
		    output.write(blue & 0xff);
		} catch (IOException e) { e.printStackTrace(); }
	}

	public void rgbRow(int row, int red, int green, int blue) {
		try {
		    output.write(10 | 0x80);
		    output.write(row & 0x0f);
		    output.write(red & 0xff);
		    output.write(green & 0xff);
		    output.write(blue & 0xff);
		} catch (IOException e) { e.printStackTrace(); }
	}

	public void rgbAll(int red, int green, int blue) {
		try {
		    output.write(11 | 0x80);
		    output.write(red & 0xff);
		    output.write(green & 0xff);
		    output.write(blue & 0xff);
		} catch (Exception e) { e.printStackTrace(); }
	}
	
	// Accessors
	public OutputStream getOutputStream() { return output; }
}
