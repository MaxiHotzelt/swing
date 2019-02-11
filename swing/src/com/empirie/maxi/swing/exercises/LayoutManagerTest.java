package com.empirie.maxi.swing.exercises;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;

import static java.awt.GridBagConstraints.*;

import javax.naming.ldap.Rdn;
import javax.swing.*;
import javax.swing.text.MaskFormatter;

public class LayoutManagerTest extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel pane;
	private JLabel mode;

	public LayoutManagerTest() {
		initUI();
	}
	
	private void initUI() {
	  	//frame
		setSize(1080, 720);
		setTitle("GUI");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		//set position of gui
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice[] gsd = ge.getScreenDevices();
		int middleScreen = gsd.length /2;
		GraphicsConfiguration gc = gsd[middleScreen].getDefaultConfiguration();
		Rectangle rect = gc.getBounds();
		setLocation((int)rect.getCenterX()-540,(int)rect.getCenterY()-360);
	
		//components
		//pane = new JPanel();
	    pane = (JPanel)getContentPane();
	    pane.setLayout(new GridBagLayout());
	    pane.setOpaque(true);
	    
	    
	    JButton b1 = new JButton("B1");
	    JButton b2 = new JButton("B2");
	    JButton b3 = new JButton("B3");
	    JButton b4 = new JButton("B4");
	    JButton b5 = new JButton("B5");
	    
	    char[] pw = new char[] {'h', 'e', 'l', 'l', 'o'};
	    
	    JPasswordField pwF = new JPasswordField(20);
	    pwF.setEchoChar('☠');
	    pwF.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		if(Arrays.equals(pwF.getPassword(), pw)) {
	    			JOptionPane.showMessageDialog(pane, "Correct PW", "Information", JOptionPane.INFORMATION_MESSAGE);
	    		} else {
	    			JOptionPane.showMessageDialog(pane, "Incorrect PW", "Information", JOptionPane.INFORMATION_MESSAGE);	    			
	    		}
	    		
	    		Arrays.fill(pw, '0');
	    	}
	    });
	    
	    pwF.setBackground(Color.BLUE);
	    pwF.setOpaque(true);
	    

	    mode = new JLabel("Selected: Medium");
	    mode.setBackground(Color.RED);
	    mode.setOpaque(true);
	    		
	    ButtonGroup btnGrp = new ButtonGroup();
	    
	    JRadioButton rBtn1 = new JRadioButton("EasyG");
	    JRadioButton rBtn2 = new JRadioButton("Medium", true);
	    JRadioButton rBtn3 = new JRadioButton("Hard");
	    
	    rBtn1.addActionListener(this);
	    rBtn2.addActionListener(this);
	    rBtn3.addActionListener(this);
	    
	    btnGrp.add(rBtn1);
	    btnGrp.add(rBtn2);
	    btnGrp.add(rBtn3);
	    
	    JPanel btnGrpP = new JPanel();
	    btnGrpP.setLayout(new BorderLayout());
	    btnGrpP.add(rBtn1, BorderLayout.WEST);
	    btnGrpP.add(rBtn2, BorderLayout.CENTER);
	    btnGrpP.add(rBtn3, BorderLayout.EAST);
	    btnGrpP.setBackground(Color.GREEN);
	    btnGrpP.setOpaque(true);
	    
	    int gridx = 0, gridy = 0, gridwidth = 1, gridheight = 1, fill = NONE, anchor = CENTER, ipadx = 0, ipady = 0;
	    double weightx = 0, weighty = 0;
	    
	    
	    JLabel l1 = new JLabel("L1", SwingConstants.CENTER);
	    JLabel l2 = new JLabel("L2", SwingConstants.CENTER);
	    JLabel l3 = new JLabel("L3", SwingConstants.CENTER);
	    
	    l1.setBackground(Color.RED);
	    l2.setBackground(Color.green);
	    l3.setBackground(Color.yellow);
	    l1.setOpaque(true);
	    l2.setOpaque(true);
	    l3.setOpaque(true);
	    
	    
	    l1.setPreferredSize(new Dimension(200,200));

	    l3.setPreferredSize(new Dimension(200,200));
	    
	    
	    
	    //filler Komponenten
	    addGBItem(l1, gridx = 0, gridy = 0, gridwidth = 1, gridheight = 1, fill = BOTH,
	    		weightx = 1, weighty = 1, anchor = CENTER, new Insets(10,10,10,10), ipadx = 0, ipady = 0);
	    addGBItem(l2, gridx = 1, gridy = 0, gridwidth = 1, gridheight = 1, fill = BOTH,
	    		weightx = 1, weighty = 1, anchor = CENTER, new Insets(10,10,10,10), ipadx = 0, ipady = 0);
	    addGBItem(l3, gridx = 2, gridy = 0, gridwidth = 1, gridheight = 1, fill = BOTH,
	    		weightx = 1, weighty = 1, anchor = CENTER, new Insets(10,10,10,10), ipadx = 0, ipady = 0);
	    
	    //Komponenten adden
	    addGBItem(b1, gridx = 1, gridy = 1, gridwidth = 1, gridheight = 1, fill = HORIZONTAL,
	    		weightx = 1, weighty = 0 , anchor = CENTER, new Insets(10,10,10,10), ipadx = 0, ipady = 0);
	    
	    addGBItem(pwF, gridx = 1, gridy = 2, gridwidth = 1, gridheight = 1, fill = HORIZONTAL,
	    		weightx = 1, weighty = 0, anchor = CENTER, new Insets(10,10,10,10), ipadx = 0, ipady = 0);
	    
	    addGBItem(btnGrpP, gridx = 1, gridy = 3, gridwidth = 1, gridheight = 1, fill = HORIZONTAL,
	    		weightx = 1, weighty = 0, anchor = CENTER, new Insets(10,10,10,10), ipadx = 0, ipady = 0);
	    
	    addGBItem(mode, gridx = 2, gridy = 4, gridwidth = 1, gridheight = 1, fill = BOTH,
	    		weightx = 1, weighty = 1, anchor = LAST_LINE_END, new Insets(10,10,10,10), ipadx = 0, ipady = 0);
	    
	   

	}

	public void actionPerformed(ActionEvent e) {
		mode.setText("Selected: " + ((AbstractButton) e.getSource()).getText());	
	}

    private void addGBItem(Component component, int gridx, int gridy, int gridwidth, int gridheight,
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
        pane.add(component, constraints);
    }
	
	public static void main(String[] args) {
		LayoutManagerTest lmt = new LayoutManagerTest();
		lmt.setVisible(true);
	}
    
}
