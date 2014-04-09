package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
	private JTextField port;
	private JButton connect;
	private JButton quitButton;
	private JComboBox<String> amountChatters;
	private BorderLayout layout;
	private JFrame connecting;
	private JPanel nickNamePanel;
	private JPanel connectAddrPanel;
	private JPanel connectPanel;
	private JPanel createProfilePanel;
	private static final String TITLE = "Connect";
	
//---------------------------------------------------------------------//
	
	public ConnectGUI(String nickNameString) {
		this.nickNameString = nickNameString;
		connecting();
	}
	
	private JFrame connecting(){
		connecting = new JFrame();
		connecting.setTitle(TITLE);
		layout = new BorderLayout();
		connecting.setLayout(layout);
		connecting.add(layOut(), BorderLayout.NORTH);
		connecting.add(connectAddr(), BorderLayout.CENTER);
		connecting.add(southLayout(),BorderLayout.SOUTH);
		connecting.setVisible(true);
		connecting.setSize(400, 180);
		connecting.setLocationRelativeTo(null);
		connecting.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		return connecting;
	}
	
	private JPanel nickName() {
		nickName = new JTextField(nickNameString, 10);
		nickName.setEditable(true);
		nickNamePanel = new JPanel();
		nickNamePanel.add(nickName);
		return nickNamePanel;
	}
	
	private JPanel connectAddr() {
		connAddr = new JTextField("Connect Address", 10);
		connAddr.setEditable(true);
		port = new JTextField("Port Address", 10);
		connectAddrPanel = new JPanel();
		connectAddrPanel.add(connAddr);
		connectAddrPanel.add(port);
		return connectAddrPanel;
	}
	
	private JPanel createProfile() {
		createProfile = new JButton("Create Profile");
		createProfile.addActionListener(this);
		createProfilePanel = new JPanel();
		createProfilePanel.add(createProfile);
		return createProfilePanel;
	}
	
	private JPanel quitPanel(){
		JPanel quitPanel = new JPanel();
		quitButton = new JButton("Shut down");
		quitButton.addActionListener(this);
		quitPanel.add(quitButton);
		quitPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
		
		return quitPanel;
	}
	
	private JPanel connect() {
		connect = new JButton("Connect");
		connect.addActionListener(this);
		amountChatters = new JComboBox<String>();
		amountChatters.addItem("Two chatters");
		amountChatters.addItem("Four chatters");
		amountChatters.addActionListener(this);
		connectPanel = new JPanel();
		connectPanel.add(connect);
		connectPanel.add(amountChatters);
		connectPanel.add(quitPanel());
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
	
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == createProfile){
			new MaakProfielGUI();
			connecting.dispose();
		}
		if(arg0.getSource() == connect){
			if((nickName.getText().equals("Nickname") || nickName.getText().equals(""))&&(connAddr.getText().equals("Connect Address") || connAddr.getText().equals(""))){
				new ErrorGUI("Nickname en connect address incorrect", 260);
			}
			else if(nickName.getText().equals("Nickname") || nickName.getText().equals("")){
				new ErrorGUI("Voer nickname in of maak nieuw profiel aan", 280);
			}
			else if(connAddr.getText().equals("Connect Address") || connAddr.getText().equals("")){
				new ErrorGUI("Incorrect connect Address", 200);
			}
			else if(amountChatters.getSelectedItem().equals("Four chatters")){
				connecting.dispose();
				new ChatGUI(nickName.getText(), 4);
			}
			else if(amountChatters.getSelectedItem().equals("Two chatters")){
				connecting.dispose();
				new ChatGUI(nickName.getText(),2);
			}	
		}
		if(arg0.getSource() == quitButton){
			connecting.dispose();
		}
	}
}
