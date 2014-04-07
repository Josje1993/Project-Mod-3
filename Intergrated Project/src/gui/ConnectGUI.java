package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import java.awt.BorderLayout;

import javax.swing.JButton;
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
	private JButton createProfile;
	private JTextField connAddr;
	private JButton connect;
	private BorderLayout layout;
	private JFrame connecting;
	private JPanel nickNamePanel;
	private JPanel connectAddrPanel;
	private JPanel connectPanel;
	private JPanel createProfilePanel;
	private static final String TITLE = "Connect";
	
//---------------------------------------------------------------------//
	
	public ConnectGUI() {
		connecting = new JFrame();
		connecting.setTitle(TITLE);
		layout = new BorderLayout();
		connecting.setLayout(layout);
		connecting.add(layOut(), BorderLayout.NORTH);
		connecting.add(connectAddr(), BorderLayout.CENTER);
		connecting.add(southLayout(),BorderLayout.SOUTH);
		connecting.setVisible(true);
		connecting.setSize(400, 160);
		connecting.setLocationRelativeTo(null);
		connecting.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
	private JPanel nickName() {
		nickName = new JTextField("Nickname", 10);
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
	
	public static void main(String[] args0){
		new ConnectGUI();
	}
	
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
}
