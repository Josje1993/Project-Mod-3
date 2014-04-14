package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import utils.RoundJTextField;
import utils.RoundJPasswordField;

public class InlogGUI implements ActionListener{
	
	private RoundJTextField userName;
	private RoundJPasswordField password;
	private JFrame inlogFrame;
	private JPanel usernamePanel;
	private JPanel passwordPanel;
	private JPanel usernamepasswordPanel;
	private JPanel buttonPanel;
	private JButton inlog;
	private JButton register;
	private JButton anoniem;
	private JLabel userNameLabel;
	private JLabel passwordLabel;
	private BorderLayout layout;
	private String passwordString;
	private final static String TITLE = "Log in";
	
	public InlogGUI(){
		makeInlogFrame();
	}
	
	private JFrame makeInlogFrame(){
		inlogFrame = new JFrame();
		inlogFrame.setTitle(TITLE);
		inlogFrame.setBackground(Color.DARK_GRAY);
		layout = new BorderLayout();
		inlogFrame.setLayout(layout);
		inlogFrame.add(inlogpasswordFields(), BorderLayout.CENTER);
		inlogFrame.add(buttonPanel(), BorderLayout.SOUTH);
		inlogFrame.setVisible(true);
		inlogFrame.setSize(400, 150);
		inlogFrame.setLocationRelativeTo(null);
		inlogFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		return inlogFrame;
	}
	
	private JPanel inlogpasswordFields(){
		Font labelFont = new Font("28 Days Later", Font.PLAIN, 12);
		GridLayout gridlayout = new GridLayout();
		gridlayout.setColumns(1);
		gridlayout.setRows(2);
		usernamepasswordPanel = new JPanel(gridlayout);
		usernamepasswordPanel.setBackground(Color.DARK_GRAY);
		usernamePanel = new JPanel();
		passwordPanel = new JPanel();
		usernamePanel.setBackground(Color.DARK_GRAY);
		passwordPanel.setBackground(Color.DARK_GRAY);
		userName = new RoundJTextField(10);
		password = new RoundJPasswordField(10);
		userNameLabel = new JLabel("<html> <font color= 'white'> Username </font></html>");
		passwordLabel = new JLabel("<html> <font color= 'white'> Password </font></html>");
		userNameLabel.setFont(labelFont);
		passwordLabel.setFont(labelFont);
		userName.setEditable(true);
		password.setEditable(true);
		usernamePanel.add(userNameLabel);
		usernamePanel.add(userName);
		passwordPanel.add(passwordLabel);
		passwordPanel.add(password);
		usernamepasswordPanel.add(usernamePanel);
		usernamepasswordPanel.add(passwordPanel);
		return usernamepasswordPanel;
	}
	
	private JPanel buttonPanel(){
		Font buttonFont = new Font("28 Days Later", Font.PLAIN, 16);
		buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.DARK_GRAY);
		inlog = new JButton("Log in");
		inlog.addActionListener(this);
		register = new JButton("Registreer");
		register.addActionListener(this);
		anoniem = new JButton("Anoniem Inloggen");
		anoniem.addActionListener(this);
		inlog.setFont(buttonFont);
		register.setFont(buttonFont);
		anoniem.setFont(buttonFont);
		inlog.setOpaque(false);
		inlog.setContentAreaFilled(false);
		inlog.setBorderPainted(false);
		register.setOpaque(false);
		register.setContentAreaFilled(false);
		register.setBorderPainted(false);
		anoniem.setOpaque(false);
		anoniem.setContentAreaFilled(false);
		anoniem.setBorderPainted(false);
		inlog.setForeground(Color.WHITE);
		register.setForeground(Color.WHITE);
		anoniem.setForeground(Color.WHITE);
		buttonPanel.add(inlog);
		buttonPanel.add(register);
		buttonPanel.add(anoniem);
		 
		return buttonPanel;
	}
	
	public static void main(String[] args){
		new InlogGUI();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == anoniem){
			if(userName.getText().equals("")){
				new ErrorGUI("Voer een username in", 200);
			}else if(!userName.getText().equals("") && password.getPassword().length != 0){
				new ErrorGUI("Geen wachtwoord nodig", 200);
			}else{
				new RegisteredConnectGUI(userName.getText());
				inlogFrame.dispose();
			}
		}
		if(ae.getSource() == inlog){
			if(userName.getText().equals("") && password.getPassword().length != 0){
				new ErrorGUI("Voer een username in", 200);
			}else if(userName.getText().equals("") && password.getPassword().length == 0){
				new ErrorGUI("Voer een username en password in", 250);
			}else if(!userName.getText().equals("") && password.getPassword().length == 0){
				new ErrorGUI("Voer een password in", 200);
			}else{
				passwordString = new String(password.getPassword());
				System.out.println(userName.getText());
				System.out.println(passwordString);
				new RegisteredConnectGUI(userName.getText(), passwordString);
				inlogFrame.dispose();
			}
			
		}
		if(ae.getSource() == register){
			new MaakProfielGUIUpgrade();
			inlogFrame.dispose();
		}
		
	}
}
