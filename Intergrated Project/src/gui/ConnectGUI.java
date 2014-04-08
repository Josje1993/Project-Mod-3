package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 * 
 */
public class ConnectGUI extends JPanel implements ActionListener {
	
//--------------------------------------------------------------------//
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -928496846447179820L;
	private JTextField nickName;
	private String nickNameString;
	private JButton createProfile;
	private JTextField connAddr;
	private JButton connect;
	private JButton okButtonConnAddr;
	private JButton okButtonNickName;
	private BorderLayout layout;
	private JFrame connecting;
	private JFrame errorFrameConnAddr;
	private JFrame errorFrameNickName;
	private JPanel nickNamePanel;
	private JPanel connectAddrPanel;
	private JPanel connectPanel;
	private JPanel createProfilePanel;
	private static final String TITLE = "Connect";
	
//---------------------------------------------------------------------//
	
	public ConnectGUI(String nickNameString) {
		this.nickNameString = nickNameString;
		connecting = new JFrame();
		connecting.setTitle(TITLE);
		layout = new BorderLayout();
		connecting.setLayout(layout);
		connecting.add(layOut(), BorderLayout.NORTH);
		connecting.add(connectAddr(), BorderLayout.CENTER);
		connecting.add(southLayout(),BorderLayout.SOUTH);
		connecting.setVisible(true);
		connecting.setSize(400, 170);
		connecting.setLocationRelativeTo(null);
		connecting.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
	private JPanel nickName() {
		nickName = new JTextField(nickNameString, 10);
		nickName.setEditable(true);
		nickNamePanel = new JPanel();
		nickNamePanel.add(nickName);
		return nickNamePanel;
	}
	
	private JPanel connectAddr() {
		connAddr = new JTextField("Connect Address", 15);
		connAddr.setEditable(true);
		connectAddrPanel = new JPanel();
		connectAddrPanel.add(connAddr);
		return connectAddrPanel;
	}
	
	private JPanel createProfile() {
		createProfile = new JButton("Create Profile");
		createProfile.addActionListener(this);
		createProfilePanel = new JPanel();
		createProfilePanel.add(createProfile);
		return createProfilePanel;
	}
	
	private JPanel connect() {
		connect = new JButton("Connect");
		connect.addActionListener(this);
		connectPanel = new JPanel();
		connectPanel.add(connect);
		return connectPanel;
	}
	
	private JPanel southLayout() {
		JPanel southPaneltje = new JPanel();
		
		southPaneltje.add(connect(), BorderLayout.NORTH);
		
		return southPaneltje;
	}
	
	private JPanel layOut() {
		JPanel paneltje = new JPanel();
		
		paneltje.add(nickName(), BorderLayout.WEST);
		paneltje.add(createProfile(), BorderLayout.EAST);
		return paneltje;
	}
	
//	public static void main(String[] args0){
//		new ConnectGUI("Nickname");
//	}
	private JFrame errorFrameConnAddr(){
		errorFrameConnAddr = new JFrame("Error");
		errorFrameConnAddr.setLayout(new FlowLayout());
		JLabel errorLabel = new JLabel("Incorrect connect Address");
		errorFrameConnAddr.add(errorLabel);
		okButtonConnAddr = new JButton("OK");
		okButtonConnAddr.addActionListener(this);
		errorFrameConnAddr.add(okButtonConnAddr);
		errorFrameConnAddr.setVisible(true);
		errorFrameConnAddr.setSize(200, 120);
		errorFrameConnAddr.setResizable(false);
		errorFrameConnAddr.setLocationRelativeTo(null);
		errorFrameConnAddr.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		return errorFrameConnAddr;
	}
	
	
	private JFrame errorFrameNickName(){
		errorFrameNickName = new JFrame("Error");
		errorFrameNickName.setLayout(new FlowLayout());
		JLabel errorLabel = new JLabel("Voer nickname in of maak nieuw profiel aan");
		errorFrameNickName.add(errorLabel);
		okButtonNickName = new JButton("OK");
		okButtonNickName.addActionListener(this);
		errorFrameNickName.add(okButtonNickName);
		errorFrameNickName.setVisible(true);
		errorFrameNickName.setSize(280, 120);
		errorFrameNickName.setResizable(false);
		errorFrameNickName.setLocationRelativeTo(null);
		errorFrameNickName.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		return errorFrameNickName;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == createProfile){
			new MaakProfielGUI();
			connecting.dispose();
		}
		if(arg0.getSource() == connect){
			if(nickName.getText().equals("Nickname") || nickName.getText().equals("")){
				connecting.setEnabled(false);
				errorFrameNickName();
			}
			else if(connAddr.getText().equals("Connect Address") || connAddr.getText().equals("")){
				connecting.setEnabled(false);
				errorFrameConnAddr();
			}
			else{
				connecting.dispose();
				new ChatGUI();
			}
			
		}
		if(arg0.getSource() == okButtonNickName){
			connecting.setEnabled(true);
			errorFrameNickName.dispose();
		}
		if(arg0.getSource() == okButtonConnAddr){
			connecting.setEnabled(true);
			errorFrameConnAddr.dispose();
		}
	}
	
	
}
