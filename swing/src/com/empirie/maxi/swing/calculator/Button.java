package com.empirie.maxi.swing.calculator;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.Border;

@SuppressWarnings("serial")
public class Button extends JButton{


    private final Color ORANGE = new Color(232, 141, 52);
    private final Color DARKORANGE = new Color(185, 114, 45);
    private final Color GREY = new Color(217, 217, 217);
    private final Color DARKGREY = new Color(200, 200, 200);
    private final Color DARKWHITE = new Color (245, 245, 245);
    private String color;
    private String type;
    private Border emptyBorder;
	
	public Button(String text, String color, String type) {
		super(text);
		this.color = color;
		this.type = type;
		
		init();
		config();
	}
	
	public String getType() {
		return type;
	}
	
	private void init() {
		emptyBorder = BorderFactory.createEmptyBorder();
	}
	
	private void config() {
		setFont(new Font("Arial", Font.BOLD, 25));
		setBorder(emptyBorder);
		setBackground(Color.WHITE);
		setOpaque(true);
				
		if(color.equals("orange")) {
			setBackground(ORANGE);
			setForeground(Color.white);
		} else if(color.equals("grey")) {
			setBackground(GREY);			
		} else {
			setBackground(Color.white);			
		}
	}
	
	public void pressedState() {
		if(color.equals("orange")) {
			setBackground(DARKORANGE);			
		} else if(color.equals("white")){
			setBackground(DARKWHITE);
		} else {
			setBackground(DARKGREY);
		}
	}
	public void unpressedState() {
		if(color.equals("orange")) {
			setBackground(ORANGE);
		} else if(color.equals("white")){
			setBackground(Color.WHITE);
		} else {
			setBackground(GREY);
		}
	}

}
