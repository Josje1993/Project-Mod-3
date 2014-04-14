package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import utils.RoundJTextField;

public class RegisteredConnectGUI implements ActionListener{

	private String nickname;
	private String password;
	private JFrame connectedFrame;
	private JPanel connectPortPanel;
	private JPanel connectButtons;
	private JPanel editProfile;
	private JPanel emptyPanel;
	private BorderLayout layout;
	private JButton connect;
	private JButton shutDown;
	private JButton editProfileButton;
	private JTextField connectAddress;
	private JTextField portnumber;
	private String TITLE;
	private static final Font myButtonFont = new Font("28 Days Later", Font.PLAIN,16);
	
	public RegisteredConnectGUI(String nickname){
		this.nickname = nickname;
		this.password = new String("");
		TITLE = new String("Welcome " + nickname);
		connectedFrame();
	}
	
	public RegisteredConnectGUI(String nickname, String password){
		this.nickname = nickname;
		this.password = password;
		System.out.println(this.nickname);
		System.out.println(this.password);
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
			connectedFrame.setSize(300,150);
		}else{
			connectedFrame.setSize(300, 120);
			connectedFrame.add(emptyPanel(), BorderLayout.CENTER);
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
		connectAddress = new RoundJTextField("   Connect Address", 10);
		connectAddress.setForeground(Color.WHITE);
		connectAddress.setBackground(Color.GRAY);
		connectAddress.setEditable(true);
		portnumber = new RoundJTextField("   Port Number", 10);
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
	
	private JPanel emptyPanel(){
		emptyPanel = new JPanel();
		emptyPanel.setBackground(Color.DARK_GRAY);
		return emptyPanel;
	}
	
	public static void main(String[] args){
		new RegisteredConnectGUI("Henk", "ni");
		//new RegisteredConnectGUI("Piet");
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == shutDown){
			new InlogGUI();
			connectedFrame.dispose();
		}
		if(ae.getSource() == editProfileButton){
			System.out.println(nickname);
			System.out.println(password);
			new MaakProfielGUIUpgrade(nickname, password);
			connectedFrame.dispose();
		}
	}
}
