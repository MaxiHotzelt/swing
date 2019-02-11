package com.empirie.maxi.swing.calculator;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.empirie.aufgaben.basics.kai.TaschenRechner;
import com.empirie.aufgaben.basics.parser.v2.Taschenrechner;

@SuppressWarnings({ "serial", "unused" })
public class View extends JFrame implements KeyListener{

	private static final int WIDTH = 480;
	private static final int HEIGHT = 810;
	
	private GraphicsEnvironment ge;
	private GraphicsDevice[] gsd;
	private GraphicsConfiguration gc;
	private Rectangle rect;
	private Screen screen;
	private JPanel pane;
	private ButtonWrapper buttonWrapper;
	 
	private Button btn0;
	private Button btn1;
	private Button btn2;
	private Button btn3;
	private Button btn4;
	private Button btn5;
	private Button btn6;
	private Button btn7;
	private Button btn8;
	private Button btn9;
	private Button btnPoint;
	private Button btnEquals;
	private Button btnPlus;
	private Button btnMinus;
	private Button btnMultiply;
	private Button btnDivide;
	private Button btnBracket1;
	private Button btnBracket2;
	private Button btnC;
	
	private Taschenrechner calculator = new Taschenrechner();
	private int openBrackets = 0;
	
	public View() {

        initUI();
        buildUI();
        configUI();
        addListeners();
    }

    private void initUI() {	
		//initialize needed monitor classes
		ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		gsd = ge.getScreenDevices();
	    gc = gsd[2].getDefaultConfiguration();
	    rect = gc.getBounds();
	    
	    //initialize components	    
	    pane = new JPanel();
	    pane = (JPanel)getContentPane();
	    pane.setLayout(new BorderLayout());
	    buttonWrapper = new ButtonWrapper();	
	    screen = new Screen();
	    
	    
	    btn0 = new Button("0", "white", "number");
	    btn1 = new Button("1", "white", "number");
	    btn2 = new Button("2", "white", "number");
	    btn3 = new Button("3", "white", "number");
	    btn4 = new Button("4", "white", "number");
	    btn5 = new Button("5", "white", "number");
	    btn6 = new Button("6", "white", "number");
	    btn7 = new Button("7", "white", "number");
	    btn8 = new Button("8", "white", "number");
	    btn9 = new Button("9", "white", "number");
	    btnPoint = new Button(".", "white", "point");
	    btnPlus = new Button("+", "orange", "operator");
	    btnMinus = new Button("-", "orange", "operator");
	    btnMultiply = new Button("×", "orange", "operator");
	    btnDivide = new Button("÷", "orange", "operator");
	    btnEquals = new Button("=", "orange", "equals");
	    btnBracket1 = new Button("(", "grey", "bracketOpen");
	    btnBracket2 = new Button(")", "grey", "bracketClose");
	    btnC = new Button("C", "grey", "deleteLast");
	            
    }

	private void buildUI() {
		buttonWrapper.addBtn(btnC);
		buttonWrapper.addBtn(btnBracket1);
		buttonWrapper.addBtn(btnBracket2);
		buttonWrapper.addBtn(btnDivide);
		
		buttonWrapper.addBtn(btn7);
		buttonWrapper.addBtn(btn8);
		buttonWrapper.addBtn(btn9);
		buttonWrapper.addBtn(btnMultiply);
		
		buttonWrapper.addBtn(btn4);
		buttonWrapper.addBtn(btn5);
		buttonWrapper.addBtn(btn6);
		buttonWrapper.addBtn(btnMinus);
		
		buttonWrapper.addBtn(btn1);
		buttonWrapper.addBtn(btn2);
		buttonWrapper.addBtn(btn3);
		buttonWrapper.addBtn(btnPlus);
		
		buttonWrapper.addBtn(btn0);
		buttonWrapper.addBtn(btnPoint);
		buttonWrapper.addBtn(btnEquals);
		
		buttonWrapper.renderButtons();
		
		
	    pane.add(screen, BorderLayout.NORTH);
	    pane.add(buttonWrapper);
	}
	
	private void configUI() {
		//configure JFrame
		setSize(WIDTH, HEIGHT);
		setTitle("GUI");
		setUndecorated(true);
		//setShape(new RoundRectangle2D.Double(getY(), getY(), WIDTH, HEIGHT, 10, 10));
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    setFocusable(true);
	    addKeyListener(this);
	    
		//set Location of JFrame
		setLocation((int)rect.getCenterX()-WIDTH/2,(int)rect.getCenterY()-HEIGHT/2);
	}

	private void addListeners() {
		ArrayList<Button> buttons = new ArrayList<Button>();
		buttons.add(btn0);
		buttons.add(btn1);
		buttons.add(btn2);
		buttons.add(btn3);
		buttons.add(btn4);
		buttons.add(btn5);
		buttons.add(btn6);
		buttons.add(btn7);
		buttons.add(btn8);
		buttons.add(btn9);
		buttons.add(btnPlus);
		buttons.add(btnMinus);
		buttons.add(btnMultiply);
		buttons.add(btnDivide);
		buttons.add(btnC);
		buttons.add(btnPoint);
		buttons.add(btnEquals);
		buttons.add(btnBracket1);
		buttons.add(btnBracket2);
		
		for(Button btn : buttons) {
			btn.addKeyListener(this);
		}
		
	}
	
	private void screenValidation(Button btnPressed) {
		StringBuilder sb = new StringBuilder();
		sb.append(screen.getText());
		
		String text = "4";
		
		
		
		//backspace is pressed
		if(btnPressed.getText().equals("C")) {
			sb.deleteCharAt(sb.length()-1);
			if(sb.length() == 0) {
				screen.setText("0");
			} else {
				screen.setText(sb.toString());
			}
			
		}
		
		else if(btnPressed.getType().equals("equals")) {
			if(openBrackets != 0) {
				return;
			}
			String calculation = screen.getText();
			calculation = calculation.replaceAll("×", "*");
			calculation = calculation.replaceAll("÷", "/");
			
			screen.setText(calculator.getErgebnis(calculation));
		}
		
		else if(btnPressed.getType().equals("bracketOpen")) {
			openBrackets++;
			screen.setText(screen.getText() + btnPressed.getText());
		} else if(btnPressed.getType().equals("bracketClose")) {
			if(openBrackets <= 0) {
				return;
			} else {
				openBrackets--;
				screen.setText(screen.getText() + btnPressed.getText());
			}
		}
		//screen has 0
		else if(screen.getText().equals("0") && btnPressed.getType().equals("number")) {
			screen.setText(btnPressed.getText());
		}
		else if(btnPressed.getType() == "operator" && 
				(
						screen.getText().charAt(screen.getText().length()-1) == ('+') ||
						screen.getText().charAt(screen.getText().length()-1) == ('-') ||
						screen.getText().charAt(screen.getText().length()-1) == ('×') ||
						screen.getText().charAt(screen.getText().length()-1) == ('÷')
				)) {
			return;
		}
		
		else {
			screen.setText(screen.getText() + btnPressed.getText());
		}
	}

	
	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
			case KeyEvent.VK_0 :
			case KeyEvent.VK_NUMPAD0:
				btn0.pressedState();
				return;
			case KeyEvent.VK_1 :
			case KeyEvent.VK_NUMPAD1:
				btn1.pressedState();
				return;
			case KeyEvent.VK_2 :
			case KeyEvent.VK_NUMPAD2:
				btn2.pressedState();
				return;
			case KeyEvent.VK_3 :
			case KeyEvent.VK_NUMPAD3:
				btn3.pressedState();
				return;
			case KeyEvent.VK_4 :
			case KeyEvent.VK_NUMPAD4:
				btn4.pressedState();
				return;
			case KeyEvent.VK_5 :
			case KeyEvent.VK_NUMPAD5:
				btn5.pressedState();
				return;
			case KeyEvent.VK_6 :
			case KeyEvent.VK_NUMPAD6:
				btn6.pressedState();
				return;
			case KeyEvent.VK_MINUS :
			case 109 :
				btnMinus.pressedState();
				return;
			case KeyEvent.VK_MULTIPLY :
				btnMultiply.pressedState();
				return;
			case KeyEvent.VK_DIVIDE :
				btnDivide.pressedState();
				return;
			case 8:
				btnC.pressedState();
				break;
			case 46:
				btnPoint.pressedState();
				break;
			case KeyEvent.VK_ENTER: 
				btnEquals.pressedState();
				break;
			default: 
				break;
		}	
		
		if(!e.isShiftDown() && (e.getKeyCode() == KeyEvent.VK_8 || e.getKeyCode() == KeyEvent.VK_NUMPAD8)) {
			btn8.pressedState();
		} else if(e.isShiftDown() && e.getKeyCode() == KeyEvent.VK_8) {
			btnBracket1.pressedState();
		}
		
		else if(!e.isShiftDown() && (e.getKeyCode() == KeyEvent.VK_9 || e.getKeyCode() == KeyEvent.VK_NUMPAD9)) {
			btn9.pressedState();
		} else if(e.isShiftDown() && e.getKeyCode() == KeyEvent.VK_9) {
			btnBracket2.pressedState();
		}
		
		else if(!e.isShiftDown() && (e.getKeyCode() == KeyEvent.VK_7 || e.getKeyCode() == KeyEvent.VK_NUMPAD7)) {
			btn7.pressedState();
		}	else if(e.isShiftDown() && e.getKeyCode() == KeyEvent.VK_7) {
			btnDivide.pressedState();
		}
		
		else if(!e.isShiftDown() && (e.getKeyCode() == KeyEvent.VK_PLUS || e.getKeyCode() == 107)) {
			btnPlus.pressedState();
		}	else if(e.isShiftDown() && e.getKeyCode() == 521) {
			btnMultiply.pressedState();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_0 :
		case KeyEvent.VK_NUMPAD0:
			btn0.unpressedState();
			screenValidation(btn0);
			return;
		case KeyEvent.VK_1 :
		case KeyEvent.VK_NUMPAD1:
			btn1.unpressedState();
			screenValidation(btn1);
			return;
		case KeyEvent.VK_2 :
		case KeyEvent.VK_NUMPAD2:
			btn2.unpressedState();
			screenValidation(btn2);
			return;
		case KeyEvent.VK_3 :
		case KeyEvent.VK_NUMPAD3:
			btn3.unpressedState();
			screenValidation(btn3);
			return;
		case KeyEvent.VK_4 :
		case KeyEvent.VK_NUMPAD4:
			btn4.unpressedState();
			screenValidation(btn4);
			return;
		case KeyEvent.VK_5 :
		case KeyEvent.VK_NUMPAD5:
			btn5.unpressedState();
			screenValidation(btn5);
			return;
		case KeyEvent.VK_6 :
		case KeyEvent.VK_NUMPAD6:
			btn6.unpressedState();
			screenValidation(btn6);
			return;
		case KeyEvent.VK_MINUS :
		case 109 :
			btnMinus.unpressedState();
			screenValidation(btnMinus);
			return;
		case KeyEvent.VK_MULTIPLY :
			btnMultiply.unpressedState();
			screenValidation(btnMultiply);
			return;
		case KeyEvent.VK_DIVIDE :
			btnDivide.unpressedState();
			screenValidation(btnDivide);
			return;
		case 8:
			btnC.unpressedState();
			screenValidation(btnC);
			break;
		case 46:
			btnPoint.unpressedState();
			screenValidation(btnPoint);
			break;
		case KeyEvent.VK_ENTER: 
			btnEquals.unpressedState();
			screenValidation(btnEquals);
			break;
		case KeyEvent.VK_ESCAPE :
			System.exit(0);
			return;
		default: 
			break;
		}
		
		if(!e.isShiftDown() && (e.getKeyCode() == KeyEvent.VK_8 || e.getKeyCode() == KeyEvent.VK_NUMPAD8)) {
			btn8.unpressedState();
			screenValidation(btn8);
		}	else if(e.isShiftDown() && e.getKeyCode() == KeyEvent.VK_8) {
			btnBracket1.unpressedState();
			screenValidation(btnBracket1);
		}
		
		else if(!e.isShiftDown() && (e.getKeyCode() == KeyEvent.VK_9 || e.getKeyCode() == KeyEvent.VK_NUMPAD9)) {
			btn9.unpressedState();
			screenValidation(btn9);
		}	else if(e.isShiftDown() && e.getKeyCode() == KeyEvent.VK_9) {
			btnBracket2.unpressedState();
			screenValidation(btnBracket2);
		}
		
		else if(!e.isShiftDown() && (e.getKeyCode() == KeyEvent.VK_7 || e.getKeyCode() == KeyEvent.VK_NUMPAD7)) {
			btn7.unpressedState();
			screenValidation(btn7);
		}	else if(e.isShiftDown() && e.getKeyCode() == KeyEvent.VK_7) {
			btnDivide.unpressedState();
			screenValidation(btnDivide);
		}

		else if(!e.isShiftDown() && (e.getKeyCode() == KeyEvent.VK_PLUS || e.getKeyCode() == 107)) {
			btnPlus.unpressedState();
			screenValidation(btnPlus);
		}	else if(e.isShiftDown() && e.getKeyCode() == 521) {
			btnMultiply.unpressedState();
			screenValidation(btnMultiply);
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}
		
    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            View ex = new View();
            ex.setVisible(true);
        });
    }
}


