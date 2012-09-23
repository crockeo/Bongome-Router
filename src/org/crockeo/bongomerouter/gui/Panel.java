package org.crockeo.bongomerouter.gui;

import javax.swing.JToggleButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Component;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Dimension;

/*
 * Class: Panel
 * 
 * Purpose:
 *  The actual GUI design
 */

public class Panel extends JPanel {
	// Serial Config
	private JTextArea commNameTextArea;
	private JTextArea baudrateTextArea;
	private JTextArea dataBitsTextArea;
	private JTextArea stopBitsTextArea;
	private JTextArea parityTextArea;
	
	// Osc Config
	private JTextArea targetIpTextArea;
	private JTextArea inputPortTextArea;
	private JTextArea outputPortTextArea;
	
	// Debug
	private JTextArea serialLastReceivedTextArea;
	private JTextArea oscLastReceivedTextArea;
	private JToggleButton debugToggleButton;
	
	// Generic stuffs
	private JLabel genericLabel;
	private JScrollPane genericScrollPane;
	
	public Panel() {
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.fill = GridBagConstraints.HORIZONTAL;
		
		// Serial Config
		genericLabel = new JLabel("Serial Config");
		c.anchor = GridBagConstraints.PAGE_START;
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 0.5;
		c.gridwidth = 2;
		add(genericLabel, c);
		
		// Comm Name:
		genericLabel = new JLabel("Comm Name: ");
		c.anchor = GridBagConstraints.LINE_END;
		c.gridx = 0;
		c.gridy = 1;
		c.weightx = 0.25;
		c.gridwidth = 1;
		add(genericLabel, c);
		
		// CommNameTextArea
		commNameTextArea = new JTextArea();
		recreateScrollPane(commNameTextArea);
		c.gridx = 1;
		c.gridy = 1;
		c.weightx = 0.25;
		c.gridwidth = 1;
		add(genericScrollPane, c);
		
		// Baudrate:
		genericLabel = new JLabel("Baudrate: ");
		c.gridx = 0;
		c.gridy = 2;
		c.weightx = 0.25;
		add(genericLabel, c);
		
		// BaudrateTextArea
		baudrateTextArea = new JTextArea();
		recreateScrollPane(baudrateTextArea);
		c.gridx = 1;
		c.gridy = 2;
		c.weightx = 0.25;
		add(genericScrollPane, c);
		
		// Data Bits
		genericLabel = new JLabel("Data Bits: ");
		c.gridx = 0;
		c.gridy = 3;
		c.weightx = 0.25;
		add(genericLabel, c);
		
		// DataBitsTextArea
		dataBitsTextArea = new JTextArea();
		recreateScrollPane(dataBitsTextArea);
		c.gridx = 1;
		c.gridy = 3;
		c.weightx = 0.25;
		add(genericScrollPane, c);
		
		// Stop Bits
		genericLabel = new JLabel("Stop Bits: ");
		c.gridx = 0;
		c.gridy = 4;
		c.weightx = 0.25;
		add(genericLabel, c);

		// StopBitsTextArea
		stopBitsTextArea = new JTextArea();
		recreateScrollPane(stopBitsTextArea);
		c.gridx = 1;
		c.gridy = 4;
		c.weightx = 0.25;
		add(genericScrollPane, c);
		
		// Parity:
		genericLabel = new JLabel("Parity: ");
		c.gridx = 0;
		c.gridy = 5;
		c.weightx = 0.25;
		add(genericLabel, c);

		// BaudrateTextArea
		parityTextArea = new JTextArea();
		recreateScrollPane(parityTextArea);
		c.gridx = 1;
		c.gridy = 5;
		c.weightx = 0.25;
		add(genericScrollPane, c);
		
		
		// OSC Config
		genericLabel = new JLabel("OSC Config");
		c.anchor = GridBagConstraints.PAGE_START;
		c.gridx = 2;
		c.gridy = 0;
		c.weightx = 0.5;
		c.gridwidth = 2;
		add(genericLabel, c);
	}
	
	private void recreateScrollPane(Component c) {
		genericScrollPane = new JScrollPane(c);
		genericScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		genericScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	}
	
	// Serial Accessors
	public String getCommPortName() { return commNameTextArea.getText(); }
	public int getBaudrate() { return Integer.parseInt(baudrateTextArea.getText()); }
	public int getDataBits() { return Integer.parseInt(dataBitsTextArea.getText()); }
	public int getStopBits() { return Integer.parseInt(stopBitsTextArea.getText()); }
	public int getParity() { return Integer.parseInt(parityTextArea.getText()); }
	
	// OSC Accessors
	public String getTargetIp() { return targetIpTextArea.getText(); }
	public int getInputPort() { return Integer.parseInt(inputPortTextArea.getText()); }
	public int getOutputPort() { return Integer.parseInt(outputPortTextArea.getText()); }
	
	// General
	public boolean isInDebug() { return debugToggleButton.isSelected(); }
	
	
	// Singleton
	public final Object clone() { return null; }
	
	private static Panel instance;
	public static Panel instance() {
		if (instance == null)
			instance = new Panel();
		return instance;
	}
}
