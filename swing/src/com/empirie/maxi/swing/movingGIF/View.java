package com.empirie.maxi.swing.movingGIF;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class View extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			View view = new View();
			view.setVisible(true);
		});
	}
	
	public View() {
		initUI();
	}
	
	public void initUI() {
		//frame
		setSize(1080, 720);
		setTitle("GUI");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		//set position of gui
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice[] gsd = ge.getScreenDevices();
	    GraphicsConfiguration gc = gsd[2].getDefaultConfiguration();
	    Rectangle rect = gc.getBounds();
	    setLocation((int)rect.getCenterX()-540,(int)rect.getCenterY()-360);
	    
	    
	    
		//components
		JLabel label = new JLabel();
		label.setBackground(Color.red);
		label.setBorder(new LineBorder(Color.BLACK));
		label.setPreferredSize(new Dimension(200,200));
		label.setOpaque(true);
		label.setText("Hey");
		
		JButton button = new JButton("Ah");
		button.addActionListener(new ActionListener() {			
			boolean toggleOn = true;
			@Override
			public void actionPerformed(ActionEvent e) {
				if(toggleOn) {
					button.setText("Oh");
					toggleOn = false;
				}
				else {
					button.setText("Ah");
					toggleOn = true;
				}
			}
		});
		
		JButton closeBtn = new JButton("Exit");
		closeBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		JPanel panel = (JPanel) getContentPane();
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel.add(label);
		panel.add(button);
		panel.add(closeBtn);
		
		
		
		//jmenu
		JMenuBar menu = new JMenuBar();
		JMenu start = new JMenu("Start");
		JMenuItem abo = new JMenuItem("Abo");
		abo.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				URL url = null;
				Desktop desktop = Desktop.getDesktop();
				
				try {
					url = new URL("https://www.youtube.com/channel/UCkvDJ2zNaz7B-k7BU5SgCyg?view_as=subscriber");
				} catch (MalformedURLException e1) {
					e1.printStackTrace();
				}
				
				try {
					desktop.browse(url.toURI());
				} catch(IOException e1) {
					e1.printStackTrace();
				} catch(URISyntaxException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		JMenu submenu = new JMenu("Untermenü");
		JMenuItem item = new JMenuItem("Klick mich");
		submenu.add(item);
		
		JCheckBoxMenuItem darkmode = new JCheckBoxMenuItem("Darkmode");
		darkmode.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(darkmode.isSelected()) {
					panel.setBackground(new Color(99,98,96));
				} else {
					panel.setBackground(Color.WHITE);
				}
			}
		});
		
		
		setJMenuBar(menu);
		menu.add(start);
		start.add(submenu);
		start.add(abo);
		start.add(darkmode);
		
	}
	
	public void test() {
		JWindow window = new JWindow();
		
		window.setSize(1200,1000);
		window.setVisible(true);
	}
	
	

	
}
