package com.empirie.maxi.swing.calculator;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class Screen extends JLabel {
	public Screen() {
		super();
		config();
	}
	
	private void config() {
		setBackground(Color.black);
		setFont(new Font("Arial", Font.BOLD, 35));
		setOpaque(true);
		setPreferredSize(new Dimension(Integer.MAX_VALUE, 200));
		
		setText("0");
		setForeground(Color.WHITE);
		setBorder(new EmptyBorder(10,10,10,10));
		setHorizontalAlignment(SwingConstants.RIGHT);
	}
}
