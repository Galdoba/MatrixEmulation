import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;

import javax.swing.JTextField;
import javax.swing.KeyStroke;

import java.awt.Cursor;
import java.awt.Color;
import java.awt.Component;

import javax.swing.Action;
import javax.swing.DropMode;



public class Frame extends JFrame {

	

	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame frame = new Frame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private static JPanel contentPane;
	private static JTextArea outLog;
	private static JFrame gameFrame;
	private static JScrollPane scrollPane;
	public static String userInput;
	private static JTextField inputField;
	
	
	

	/**
	 * Create the frame.
	 */
	public Frame() {
		initialize();
	}
	
	
	public static void initialize() { 
		gameFrame = new JFrame ();
		gameFrame.setAlwaysOnTop(true);
		gameFrame.setVisible(true);
		gameFrame.setResizable(false);
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.setBounds(100, 100, 1280, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		gameFrame.setContentPane(contentPane);
		contentPane.setLayout(null);
						
		outLog = new JTextArea();
		outLog.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		outLog.setBackground(Color.DARK_GRAY);
		outLog.setForeground(Color.GREEN);
		outLog.setFont(new Font("Rockwell", Font.BOLD, 11));
		outLog.setEditable(false);
		outLog.setLineWrap(true);
		outLog.setWrapStyleWord(true);
		outLog.setText("START" + "\n");
		//outLog.setBounds(600, 11, 675, 500);
		contentPane.add(outLog);
		
		
		
		scrollPane = new JScrollPane(outLog);
		scrollPane.setAutoscrolls(true);
		scrollPane.setToolTipText("");
		scrollPane.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(600, 11, 662, 691);
		contentPane.add(scrollPane);
		
		inputField = new JTextField();
		inputField.setForeground(Color.GREEN);
		inputField.setBackground(Color.DARK_GRAY);
		inputField.setBounds(600, 713, 662, 51);
		contentPane.add(inputField);
		inputField.setColumns(40);
		
	}
	
	public static void addLog(String toAdd) {
		outLog.append(toAdd + "\n");
	}
	
	public static String userInput () {
		inputField.requestFocus();
		clearInput();
		try {
		    Thread.sleep(1000);                 //1000 milliseconds is one second.gfb
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		inputField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					outLog.append(inputField.getText() + "\n");
					//clearInput();
				}
					
			}
			
		});
		userInput = inputField.getText();
		return userInput;
	}
		
		
		
	
	
	public static JTextField getInputConsole() {
		return inputField;
	}

	public static void setInConsole(JTextArea inputConsole) {
		Frame.inputField = inputField;
	}
	
	public static void clearInput() {
		inputField.setText("Data Spike>Host");
	}
}
