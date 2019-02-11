package com.empirie.maxi.swing.exercises;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MovingGIF extends JFrame{
	
	public MovingGIF() {
		init();
		build();
		config();
	}
	
	private static final int WIDTH = 1080;
	private static final int HEIGHT = 960;
	
	
	private GraphicsEnvironment ge;
	private GraphicsDevice[] gsd;
	private GraphicsConfiguration gc;
	private Rectangle rect;
	
	private JPanel pane;
	private ImageIcon datBoi;
	private ImageIcon zombie;
	private JLabel gifDatBoi;
	private JLabel gifZombie;
	

	private int gifdbX;
	private int gifdbY;
	
	private void init() {
		pane = (JPanel)getContentPane();
		ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		gsd = ge.getScreenDevices();
	    gc = gsd[2].getDefaultConfiguration();
	    rect = gc.getBounds();
		
		datBoi = new ImageIcon("E:\\develop\\gui_calculator\\gui_calculator\\src\\com\\empirie\\maxi\\gui\\exercises\\datboi.gif");
		zombie = new ImageIcon("E:\\develop\\gui_calculator\\gui_calculator\\src\\com\\empirie\\maxi\\gui\\exercises\\zombie.gif");
		gifdbX = datBoi.getIconWidth();
		gifdbY = zombie.getIconHeight();
		
		
		gifDatBoi = new JLabel(datBoi);
		gifZombie = new JLabel(zombie);
	}
	
	private void build() {
		pane.add(gifDatBoi);
	}
	
	private void config() {
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation((int)rect.getCenterX()-WIDTH/2,(int)rect.getCenterY()-HEIGHT/2);
		

		
		gifDatBoi.setBounds(0, 0, gifdbX, gifdbY);
		
		pane.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		pane.setLayout(null);
	}
	
	public void update(int x, int y) {
		repaint();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		gifDatBoi.setBounds(x, y, gifdbX, gifdbY);
		
		int _x = x - 2;
		int _y = y + 0;
		update(_x, _y);
		
	}
	
	public static void main(String[] args) {
		MovingGIF mg = new MovingGIF();
		mg.setVisible(true);
		mg.update(0, 0);
	}
	
}
