package com.empirie.maxi.swing.calculator;

import static java.awt.GridBagConstraints.*;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ButtonWrapper extends JPanel{
	
	private ArrayList<Button> buttonList = new ArrayList<Button>();
	
	ButtonWrapper() {
		super();
	}
	
	public void renderButtons() {
		setLayout(new GridBagLayout());
		setBackground(new Color(34, 34, 34));
		setOpaque(true);
		
		
		@SuppressWarnings("unused")
		int gridx = 0, gridy = 0, gridwidth = 1, gridheight = 1, fill = NONE, anchor = CENTER, ipadx = 0, ipady = 0;
	    @SuppressWarnings("unused")
		double weightx = 0, weighty = 0;
	    
		
		addBtn(buttonList.get(0), gridx = 0, gridy = 0, gridwidth = 1, gridheight = 1, fill = BOTH,
	    		weightx = 1, weighty = 1 , anchor = CENTER, new Insets(1,0,0,0), ipadx = 0, ipady = 0);
		addBtn(buttonList.get(1), gridx = 1, gridy = 0, gridwidth = 1, gridheight = 1, fill = BOTH,
	    		weightx = 1, weighty = 1 , anchor = CENTER, new Insets(1,1,0,0), ipadx = 0, ipady = 0);
		addBtn(buttonList.get(2), gridx = 2, gridy = 0, gridwidth = 1, gridheight = 1, fill = BOTH,
	    		weightx = 1, weighty = 1 , anchor = CENTER, new Insets(1,1,0,0), ipadx = 0, ipady = 0);
		addBtn(buttonList.get(3), gridx = 3, gridy = 0, gridwidth = 1, gridheight = 1, fill = BOTH,
	    		weightx = 1, weighty = 1 , anchor = CENTER, new Insets(1,1,0,0), ipadx = 0, ipady = 0);
		
		
		addBtn(buttonList.get(4), gridx = 0, gridy = 1, gridwidth = 1, gridheight = 1, fill = BOTH,
	    		weightx = 1, weighty = 1 , anchor = CENTER, new Insets(1,0,0,0), ipadx = 0, ipady = 0);
		addBtn(buttonList.get(5), gridx = 1, gridy = 1, gridwidth = 1, gridheight = 1, fill = BOTH,
	    		weightx = 1, weighty = 1 , anchor = CENTER, new Insets(1,1,0,0), ipadx = 0, ipady = 0);
		addBtn(buttonList.get(6), gridx = 2, gridy = 1, gridwidth = 1, gridheight = 1, fill = BOTH,
	    		weightx = 1, weighty = 1 , anchor = CENTER, new Insets(1,1,0,0), ipadx = 0, ipady = 0);
		addBtn(buttonList.get(7), gridx = 3, gridy = 1, gridwidth = 1, gridheight = 1, fill = BOTH,
	    		weightx = 1, weighty = 1 , anchor = CENTER, new Insets(1,1,0,0), ipadx = 0, ipady = 0);
		
		addBtn(buttonList.get(8), gridx = 0, gridy = 2, gridwidth = 1, gridheight = 1, fill = BOTH,
	    		weightx = 1, weighty = 1 , anchor = CENTER, new Insets(1,0,0,0), ipadx = 0, ipady = 0);
		addBtn(buttonList.get(9), gridx = 1, gridy = 2, gridwidth = 1, gridheight = 1, fill = BOTH,
	    		weightx = 1, weighty = 1 , anchor = CENTER, new Insets(1,1,0,0), ipadx = 0, ipady = 0);
		addBtn(buttonList.get(10), gridx = 2, gridy = 2, gridwidth = 1, gridheight = 1, fill = BOTH,
	    		weightx = 1, weighty = 1 , anchor = CENTER, new Insets(1,1,0,0), ipadx = 0, ipady = 0);
		addBtn(buttonList.get(11), gridx = 3, gridy = 2, gridwidth = 1, gridheight = 1, fill = BOTH,
	    		weightx = 1, weighty = 1 , anchor = CENTER, new Insets(1,1,0,0), ipadx = 0, ipady = 0);
		
		addBtn(buttonList.get(12), gridx = 0, gridy = 3, gridwidth = 1, gridheight = 1, fill = BOTH,
	    		weightx = 1, weighty = 1 , anchor = CENTER, new Insets(1,0,0,0), ipadx = 0, ipady = 0);
		addBtn(buttonList.get(13), gridx = 1, gridy = 3, gridwidth = 1, gridheight = 1, fill = BOTH,
	    		weightx = 1, weighty = 1 , anchor = CENTER, new Insets(1,1,0,0), ipadx = 0, ipady = 0);
		addBtn(buttonList.get(14), gridx = 2, gridy = 3, gridwidth = 1, gridheight = 1, fill = BOTH,
	    		weightx = 1, weighty = 1 , anchor = CENTER, new Insets(1,1,0,0), ipadx = 0, ipady = 0);
		addBtn(buttonList.get(15), gridx = 3, gridy = 3, gridwidth = 1, gridheight = 1, fill = BOTH,
	    		weightx = 1, weighty = 1 , anchor = CENTER, new Insets(1,1,0,0), ipadx = 0, ipady = 0);
		
		addBtn(buttonList.get(16), gridx = 0, gridy = 4, gridwidth = 2, gridheight = 1, fill = BOTH,
	    		weightx = 1, weighty = 1 , anchor = CENTER, new Insets(1,0,0,0), ipadx = 0, ipady = 0);
		addBtn(buttonList.get(17), gridx = 2, gridy = 4, gridwidth = 1, gridheight = 1, fill = BOTH,
	    		weightx = 1, weighty = 1 , anchor = CENTER, new Insets(1,1,0,0), ipadx = 0, ipady = 0);
		addBtn(buttonList.get(18), gridx = 3, gridy = 4, gridwidth = 1, gridheight = 1, fill = BOTH,
	    		weightx = 1, weighty = 1 , anchor = CENTER, new Insets(1,1,0,0), ipadx = 0, ipady = 0);
	}
	
	
	private void addBtn(Component component, int gridx, int gridy, int gridwidth, int gridheight,
            int fill, double weightx, double weighty, int anchor, Insets insets,
            int ipadx, int ipady) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = gridx;
        constraints.gridy = gridy;
        constraints.gridwidth = gridwidth;
        constraints.gridheight = gridheight;
        constraints.fill = fill;
        constraints.weightx = weightx;
        constraints.weighty = weighty;
        constraints.anchor = anchor;
        constraints.insets = insets;
        constraints.ipadx = ipadx;
        constraints.ipady = ipady;
        add(component, constraints);
    }
	
	public void addBtn(Button btn) {
		buttonList.add(btn);
	}
	
}
