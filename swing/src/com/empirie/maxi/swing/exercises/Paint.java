package com.empirie.maxi.swing.exercises;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;

import javax.swing.*;

public class Paint extends JFrame {

	private static final long serialVersionUID = 1L;

	public Paint() {
		initUI();
	}

	public void initUI() {
		// frame
		setSize(1080, 720);
		setTitle("GUI");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// set position of gui
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice[] gsd = ge.getScreenDevices();
		GraphicsConfiguration gc = gsd[2].getDefaultConfiguration();
		Rectangle rect = gc.getBounds();
		setLocation((int) rect.getCenterX() - 540, (int) rect.getCenterY() - 360);

		JPanel pane = (JPanel) getContentPane();

		DrawingCanvas drawingPanel = new DrawingCanvas();
		
		pane.add(drawingPanel);

	}

	@SuppressWarnings("serial")
	private class DrawingCanvas extends JPanel {
		DrawingCanvas() {
			super();
		}

		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			setBackground(Color.BLACK);

			g.setColor(Color.YELLOW); // set the drawing color
			g.drawLine(30, 40, 100, 200);
			g.drawOval(150, 180, 10, 10);
			g.drawRect(200, 210, 20, 30);
			g.setColor(Color.RED); // change the drawing color
			g.fillOval(300, 310, 30, 50);
			g.fillRect(400, 350, 60, 50);
			// Printing texts
			g.setColor(Color.WHITE);
			g.setFont(new Font("Monospaced", Font.PLAIN, 12));
			g.drawString("Testing custom drawing ...", 10, 20);
		}
	}

	public static void main(String[] args) {
		Paint start = new Paint();
		start.setVisible(true);
	}


}
