package org.crockeo.bongomerouter.gui;

import javax.swing.JFrame;

/*
 * Class: Window
 * 
 * Purpose:
 *  Main frame for the router.
 */

public class Window extends JFrame {
	public Window() {
		super("Bongome Router");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add(new Panel());
		setSize(640, 480);
		
		setLocationRelativeTo(null);
		
		setVisible(true);
	}
}
