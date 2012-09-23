package org.crockeo.bongomerouter.gui;

/*
 * Class: GuiManager
 * 
 * Purpose:
 *  Managing all data stored within the GUI.
 */

public class GuiManager {
	// Serial
	public static String getCommPortName() { return Panel.instance().getCommPortName(); }
	public static int getBaudrate() { return Panel.instance().getBaudrate(); }
	public static int getDataBits() { return Panel.instance().getDataBits(); }
	public static int getStopBits() { return Panel.instance().getStopBits(); }
	public static int getParity() { return Panel.instance().getParity(); }
	
	// Osc
	// TODO: Implement Osc
}
