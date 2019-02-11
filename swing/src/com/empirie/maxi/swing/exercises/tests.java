package com.empirie.maxi.swing.exercises;

import javax.swing.AbstractButton;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;



public class tests extends JFrame implements KeyListener{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel testScreen;
	private JPanel screenContainer;
	private JLabel screen;

	public tests() {

        initUI();
    }

    private void initUI() {
    	//frame
		setSize(1080, 720);
		setTitle("GUI");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    	//set position of gui
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice[] gsd = ge.getScreenDevices();
	    GraphicsConfiguration gc = gsd[2].getDefaultConfiguration();
	    Rectangle rect = gc.getBounds();
	    setLocation((int)rect.getCenterX()-540,(int)rect.getCenterY()-360);
	    
	    //components
	    JPanel pane = new JPanel();
	    pane = (JPanel)getContentPane();
	    pane.setLayout(new GridLayout(3,1));
	    
	    
	    screen = new JLabel();
	    screen.setText("0");
	    screen.setForeground(Color.WHITE);
	    
	    screenContainer = new JPanel();
	    screenContainer.setLayout(new BoxLayout(screenContainer, BoxLayout.X_AXIS));
	    screenContainer.setPreferredSize(new Dimension(300,20));
	    screenContainer.setBackground(Color.black);
	    screenContainer.add(Box.createHorizontalGlue());
	    screenContainer.add(screen);
	    screenContainer.add(Box.createRigidArea(new Dimension(5,0)));
	    
	    
	    testScreen = new JLabel();
	    testScreen.setPreferredSize(new Dimension(100,20));
	    testScreen.setBackground(Color.BLACK);
	    testScreen.setText("0");
	    testScreen.setForeground(Color.WHITE);
	    testScreen.setOpaque(true);
	    
	    
	    
	    //buttons
	    ArrayList<JButton> jButtonList = new ArrayList<JButton>();
	    
	    JPanel buttons = new JPanel();
	    buttons.setLayout(new GridLayout(3,3));
	    for(int i = 0; i < 9; i++) {
	    	JButton btn = new JButton();
	    	btn.setText(String.valueOf(i + 1));
	    	btn.addKeyListener(this);
	    	jButtonList.add(btn);
	    	buttons.add(btn);
	    }
	    

	    pane.add(screenContainer);
	    pane.add(testScreen);
	    pane.add(buttons);
    		    
    }

    public void keyPressed(KeyEvent e) {
    		if(e.getKeyCode() == 49) {
    			
    		}
    		testScreen.setText(String.valueOf(e.getKeyCode()));	    		
    	}
		public void keyReleased(KeyEvent e) {
	    		screen.setText(screen.getText() + e.getKeyLocation());
		}
		public void keyTyped(KeyEvent e) {
			
		}

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            tests ex = new tests();
            ex.setVisible(true);
        });
    }
}

