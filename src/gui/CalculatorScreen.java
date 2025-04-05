package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JSplitPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Window.Type;
import javax.swing.JLabel;
import java.awt.Toolkit;

public class CalculatorScreen extends JFrame {
	private JPanel contentPane;
	private JLabel textField;
	private Operation operation = Operation.Sum;
	private boolean newNumber = false;
	private double oldNumber = 0;
	private JLabel lblNewLabel;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculatorScreen frame = new CalculatorScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void displayDigit(String digit) {
		if (textField.getText().equals("0") || newNumber) {
			textField.setText(digit);
			newNumber = false;
		} else {
			textField.setText(textField.getText() + digit);
		}
	}
	
	private double getCurrentNumber() {
		double number = 0;
		
		try {
			number = Double.parseDouble(textField.getText().trim());	
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "La entrada debe ser un número", "Error", JOptionPane.ERROR_MESSAGE);
		} finally {

		}
		
		return number;
	}
	
	private void doCalculation() {
		double current = newNumber ? 0 : getCurrentNumber();
		
		switch (this.operation) {
		case Sum:
			textField.setText(Double.toString(current + oldNumber));
			break;
		case Sub:
			textField.setText(Double.toString(oldNumber - current));
			break;
		case Div:
			if (current != 0) {
				textField.setText(Double.toString(oldNumber / current));
			} else {
				JOptionPane.showMessageDialog(null, "La división entre 0 no está definida", "Error", JOptionPane.ERROR_MESSAGE);
			}
			break;
		case Prod:
			textField.setText(Double.toString(current * oldNumber));
			break;
		}
		
		oldNumber = getCurrentNumber();
	}
	
	private void changeOperation(Operation operation) {
		doCalculation();
		String opOut = "";
		
		switch (operation) {
		case Sum:
			opOut = "+";
			break;
		case Sub:
			opOut = "-";
			break;
		case Div:
			opOut = "/";
			break;
		case Prod:
			opOut = "*";
			break;
		}
		
		lblNewLabel.setText(oldNumber + opOut);
		
		newNumber = true;
		this.operation = operation;
	}
	
	/**
	 * Create the frame.
	 */
	public CalculatorScreen() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\user\\Downloads\\icons8_calculator_50_H8X_icon.ico"));
		setResizable(false);
		setBackground(Color.GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 267, 430);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("7");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				displayDigit("7");
			}
		});
		btnNewButton.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 18));
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setBounds(12, 147, 50, 50);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("8");
		button.setForeground(Color.WHITE);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				displayDigit("8");
			}
		});
		button.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 18));
		button.setBackground(Color.DARK_GRAY);
		button.setBounds(74, 147, 50, 50);
		contentPane.add(button);
		
		JButton button_1 = new JButton("9");
		button_1.setForeground(Color.WHITE);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				displayDigit("9");
			}
		});
		button_1.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 18));
		button_1.setBackground(Color.DARK_GRAY);
		button_1.setBounds(136, 147, 50, 50);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("4");
		button_2.setForeground(Color.WHITE);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				displayDigit("4");
			}
		});
		button_2.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 18));
		button_2.setBackground(Color.DARK_GRAY);
		button_2.setBounds(12, 210, 50, 50);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("5");
		button_3.setForeground(Color.WHITE);
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				displayDigit("5");
			}
		});
		button_3.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 18));
		button_3.setBackground(Color.DARK_GRAY);
		button_3.setBounds(74, 210, 50, 50);
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("6");
		button_4.setForeground(Color.WHITE);
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				displayDigit("6");
			}
		});
		button_4.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 18));
		button_4.setBackground(Color.DARK_GRAY);
		button_4.setBounds(136, 210, 50, 50);
		contentPane.add(button_4);
		
		JButton button_5 = new JButton("1");
		button_5.setForeground(Color.WHITE);
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				displayDigit("1");
			}
		});
		button_5.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 18));
		button_5.setBackground(Color.DARK_GRAY);
		button_5.setBounds(12, 273, 50, 50);
		contentPane.add(button_5);
		
		JButton button_6 = new JButton("2");
		button_6.setForeground(Color.WHITE);
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				displayDigit("2");
			}
		});
		button_6.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 18));
		button_6.setBackground(Color.DARK_GRAY);
		button_6.setBounds(74, 273, 50, 50);
		contentPane.add(button_6);
		
		JButton button_7 = new JButton("3");
		button_7.setForeground(Color.WHITE);
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				displayDigit("3");
			}
		});
		button_7.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 18));
		button_7.setBackground(Color.DARK_GRAY);
		button_7.setBounds(136, 273, 50, 50);
		contentPane.add(button_7);
		
		JButton button_8 = new JButton("+");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				changeOperation(Operation.Sum);
			}
		});
		button_8.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 18));
		button_8.setBackground(new Color(176, 196, 222));
		button_8.setBounds(198, 210, 50, 50);
		contentPane.add(button_8);
		
		JButton button_9 = new JButton("-");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (operation == Operation.Sum) {					
					changeOperation(Operation.Sub);
				} else {
					if (newNumber) {
						displayDigit("-");
						newNumber = false;
					}
				}
			}
		});
		button_9.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 18));
		button_9.setBackground(new Color(176, 196, 222));
		button_9.setBounds(198, 273, 50, 50);
		contentPane.add(button_9);
		
		JButton btnX = new JButton("\u00D7");
		btnX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				changeOperation(Operation.Prod);
			}
		});
		btnX.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 18));
		btnX.setBackground(new Color(176, 196, 222));
		btnX.setBounds(198, 147, 50, 50);
		contentPane.add(btnX);
		
		JButton button_11 = new JButton("0");
		button_11.setForeground(Color.WHITE);
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				displayDigit("0");
			}
		});
		button_11.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 18));
		button_11.setBackground(Color.DARK_GRAY);
		button_11.setBounds(74, 336, 50, 50);
		contentPane.add(button_11);
		
		JButton button_12 = new JButton("\u00F7");
		button_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				changeOperation(Operation.Div);
			}
		});
		button_12.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 18));
		button_12.setBackground(new Color(176, 196, 222));
		button_12.setBounds(198, 83, 50, 50);
		contentPane.add(button_12);
		
		JButton button_10 = new JButton("=");
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				doCalculation();
				
				lblNewLabel.setText(Double.toString(getCurrentNumber()) + "+");
				operation = Operation.Sum;
				newNumber = true;
			}
		});
		button_10.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 18));
		button_10.setBackground(new Color(176, 196, 222));
		button_10.setBounds(198, 336, 50, 50);
		contentPane.add(button_10);
		
		textField = new JLabel();
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 27));
		textField.setForeground(Color.WHITE);
		textField.setText("0");
		textField.setBackground(Color.DARK_GRAY);
		textField.setBounds(12, 13, 236, 57);
		contentPane.add(textField);
		
		JButton btnC = new JButton("C");
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText("0");
			}
		});
		btnC.setForeground(Color.WHITE);
		btnC.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 18));
		btnC.setBackground(new Color(119, 136, 153));
		btnC.setBounds(136, 83, 50, 50);
		contentPane.add(btnC);
		
		JButton button_13 = new JButton(",");
		button_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				displayDigit(".");
			}
		});
		button_13.setForeground(Color.WHITE);
		button_13.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 18));
		button_13.setBackground(new Color(112, 128, 144));
		button_13.setBounds(136, 336, 50, 50);
		contentPane.add(button_13);
		contentPane.add(getLblNewLabel());
		
		JButton btnCe = new JButton("CE");
		btnCe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				oldNumber = 0;
				textField.setText("0");
				lblNewLabel.setText("");
				operation = Operation.Sum;
			}
		});
		btnCe.setForeground(Color.WHITE);
		btnCe.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 13));
		btnCe.setBackground(new Color(119, 136, 153));
		btnCe.setBounds(74, 83, 50, 50);
		contentPane.add(btnCe);
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel.setForeground(new Color(204, 204, 204));
			lblNewLabel.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 13));
			lblNewLabel.setBackground(new Color(51, 51, 51));
			lblNewLabel.setBounds(12, 54, 236, 16);
		}
		return lblNewLabel;
	}
}
