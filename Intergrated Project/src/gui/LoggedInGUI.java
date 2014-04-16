package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import utils.RoundJTextField;

public class LoggedInGUI implements ActionListener{

//-----------------------------------------------------------------------//	
	
	private String nickname;
	private String password;
	private JFrame connectedFrame;
	private JPanel connectPortPanel;
	private JPanel connectButtons;
	private JPanel editProfile;
	private BorderLayout layout;
	private JButton connect;
	private JButton shutDown;
	private JButton editProfileButton;
	private JTextField connectAddress;
	private JTextField portnumber;
	private JComboBox<String> amountChatters;
	private String TITLE;
	private static final Font myButtonFont = new Font("28 Days Later", Font.PLAIN,16);

//-----------------------------------------------------------------------//	
	
	public LoggedInGUI(String nickname){
		this.nickname = nickname;
		this.password = new String("");
		TITLE = new String("Welcome " + nickname);
		connectedFrame();
	}
	
	public LoggedInGUI(String nickname, String password){
		this.nickname = nickname;
		this.password = password;
		TITLE = new String("Welcome " + nickname);
		connectedFrame();
	}
	
	private JFrame connectedFrame(){
		connectedFrame = new JFrame();
		connectedFrame.setTitle(TITLE);
		layout = new BorderLayout();
		connectedFrame.setLayout(layout);
		if(!password.equals("")){
			connectedFrame.add(editProfile(), BorderLayout.CENTER);
			connectedFrame.add(chatterChooser(), BorderLayout.WEST);
			connectedFrame.setSize(300,150);
		}else{
			connectedFrame.setSize(300, 150);
			connectedFrame.add(chatterChooser(), BorderLayout.CENTER);
		}
		connectedFrame.add(connectAddr(), BorderLayout.NORTH);
		connectedFrame.add(connectButtons(), BorderLayout.SOUTH);
		connectedFrame.setVisible(true);
		connectedFrame.setLocationRelativeTo(null);
		connectedFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		return connectedFrame;
	}
	
	private JPanel connectAddr(){
		connectPortPanel = new JPanel();
		connectPortPanel.setBackground(Color.DARK_GRAY);
		connectAddress = new RoundJTextField("Connect Address", 10);
		connectAddress.setForeground(Color.WHITE);
		connectAddress.setBackground(Color.GRAY);
		connectAddress.setEditable(true);
		portnumber = new RoundJTextField("Port Number", 10);
		portnumber.setForeground(Color.WHITE);
		portnumber.setBackground(Color.GRAY);
		portnumber.setEditable(true);
		connectPortPanel.add(connectAddress);
		connectPortPanel.add(portnumber);
		return connectPortPanel;
	}
	
	private JPanel connectButtons(){
		connectButtons = new JPanel();
		connectButtons.setBackground(Color.DARK_GRAY);
		connect = new JButton("<html> <font color = 'white'>Connect</font>");
		connect.setOpaque(false);
		connect.setContentAreaFilled(false);
		connect.setBorderPainted(false);
		connect.addActionListener(this);
		connect.setFont(myButtonFont);
		shutDown = new JButton("<html> <font color = 'white'>Shut down</font>");
		shutDown.setOpaque(false);
		shutDown.setContentAreaFilled(false);
		shutDown.setBorderPainted(false);
		shutDown.addActionListener(this);
		shutDown.setFont(myButtonFont);
		connectButtons.add(connect);
		connectButtons.add(shutDown);
		
		return connectButtons;
	}
	
	private JPanel editProfile(){
		editProfile = new JPanel();
		editProfile.setBackground(Color.DARK_GRAY);
		editProfileButton = new JButton("<html> <font color = 'white'>Edit Profile</font>");
		editProfileButton.setOpaque(false);
		editProfileButton.setContentAreaFilled(false);
		editProfileButton.setBorderPainted(false);
		editProfileButton.addActionListener(this);
		editProfileButton.setFont(myButtonFont);
		editProfile.add(editProfileButton);
		return editProfile;
	}
	
	private JPanel chatterChooser(){
		JPanel chatterChooserPanel = new JPanel();
		chatterChooserPanel.setBackground(Color.DARK_GRAY);
		amountChatters = new JComboBox<String>();
		amountChatters.setForeground(Color.WHITE);
		amountChatters.setBackground(Color.DARK_GRAY);
		amountChatters.addItem("Two chatters");
		amountChatters.addItem("Four chatters");
		Font amountFont = new Font("28 Days Later",Font.PLAIN,16);
		amountChatters.setFont(amountFont);
		amountChatters.addActionListener(this);
		chatterChooserPanel.add(amountChatters);
		return chatterChooserPanel;
	}
	
	public static void main(String[] args){
		//new RegisteredConnectGUI("Henk", "ni");
		new LoggedInGUI("Piet");
	}

	public boolean onlyNumbersAbove1023(String numbers){
		boolean result = false;
		for(int x = 0; x < 6000; x++){
			String stringx = Integer.toString(x);
			if(numbers.equals(stringx) && x >= 1024){
				result = true;
			}
		}
		return result;
	}
	
	public boolean onlyNumbersconnAddr(String numbers){
		int resultint = 0;
		String[] splitter = numbers.split("\\.");
		boolean result = false;
		if(splitter.length == 4){
			for(int y = 0; y < splitter.length; y++){
				for(int x = 0; x < 256; x++){
					String stringx = Integer.toString(x);
					if(splitter[y].equals(stringx)){
						resultint++;
						if(resultint == 4){
							result = true;
						}
					}
				}
			}
		}
		return result;
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == shutDown){
			new InlogGUI();
			connectedFrame.dispose();
		}
		if(ae.getSource() == editProfileButton){
			new EditProfileGUI(nickname, password);
			connectedFrame.dispose();
		}
		if(ae.getSource() == connect){
			if(connectAddress.getText().equals("Connect Address") || connectAddress.getText().equals("") || !onlyNumbersconnAddr(connectAddress.getText())){
				new ErrorGUI("Incorrect connect Address", 200);
			}
			else if(!onlyNumbersAbove1023(portnumber.getText())){
				new ErrorGUI("Voer geldige portnummer in", 230);
			}
			else if(amountChatters.getSelectedItem().equals("Four chatters")){
				connectedFrame.dispose();
				new ChatGUI(nickname, 4);
			}
			else if(amountChatters.getSelectedItem().equals("Two chatters")){
				connectedFrame.dispose();
				new ChatGUI(nickname, 2);
			}	
		}
	}
}
