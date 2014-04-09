package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 * 
 */
public class ConnectAccountGUI extends JPanel implements ActionListener {
	
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
	private JTextField passWord;
	private JCheckBox vinkje;
	private JLabel onthoud;
	private JButton connect;
	private JButton quitButton;
	private JComboBox<String> amountChatters;
	private BorderLayout layout;
	private JFrame connecting;
	private JPanel nickNamePanel;
	private JPanel connectAddrPanel;
	private JPanel connectPanel;
	private JPanel createProfilePanel;
	private JPanel passwordPanel;
	private JPanel onthoudPanel;
	private static final String TITLE = "Connect";
	
//---------------------------------------------------------------------//
	
	public ConnectAccountGUI(String nickNameString) {
		this.nickNameString = nickNameString;
		connecting();
	}
	
	private JFrame connecting(){
		connecting = new JFrame();
		connecting.setTitle(TITLE);
		layout = new BorderLayout();
		connecting.setLayout(layout);
		connecting.add(layOut(), BorderLayout.NORTH);
		connecting.add(flowPanel(), BorderLayout.CENTER);
		connecting.add(southLayout(),BorderLayout.SOUTH);
		connecting.setVisible(true);
		connecting.setSize(400, 300);
		connecting.setLocationRelativeTo(null);
		connecting.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		return connecting;
	}
	
	private JPanel nickName() {
		nickName = new JTextField(nickNameString, 10);
		nickName.setEditable(true);
		nickNamePanel = new JPanel();
		nickNamePanel.setBackground(Color.DARK_GRAY);
		nickNamePanel.add(nickName);
		return nickNamePanel;
	}
	
	private JPanel connectAddr() {
		connAddr = new JTextField("Connect Address", 10);
		
		connAddr.setEditable(true);
		port = new JTextField("Port Address", 10);
		connectAddrPanel = new JPanel();
		connectAddrPanel.setLayout(new GridLayout(2,1));
		connectAddrPanel.setBackground(Color.DARK_GRAY);
		connectAddrPanel.add(connAddr);
		connectAddrPanel.add(port);
		return connectAddrPanel;
	}
	
	private JPanel onthoud() {
		vinkje = new JCheckBox();
		onthoud = new JLabel("Wachtwoord onthouden?");
		onthoudPanel = new JPanel();
		onthoudPanel.setLayout(new FlowLayout());
		onthoudPanel.setBackground(Color.DARK_GRAY);
		onthoudPanel.add(vinkje);
		onthoudPanel.add(onthoud);
		return onthoudPanel;
	}
	
	private JPanel pOV() {
		JPanel pOVPanel = new JPanel();
		pOVPanel.setLayout(new GridLayout(2,2));
		pOVPanel.setBackground(Color.DARK_GRAY);
		pOVPanel.add(passWord());
		pOVPanel.add(onthoud());
		return pOVPanel;
	}
	
	private JPanel passWord() {
		passWord = new JTextField("Password", 10);
		passWord.setEditable(true);
		passwordPanel = new JPanel();
		passwordPanel.setLayout(new GridLayout(1,1));
		passwordPanel.setBackground(Color.DARK_GRAY);
		passwordPanel.add(passWord);
		return passwordPanel;
	}
	
	private JPanel flowPanel() {
		JPanel flow = new JPanel(new FlowLayout());
		flow.setBackground(Color.DARK_GRAY);
		flow.add(pOV());
		flow.add(connectAddr());
		return flow;
		
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
		System.out.println(numbers);
		int resultint = 0;
		String[] splitter = numbers.split("\\.");
		System.out.println(Arrays.toString(splitter));
		boolean result = false;
		if(splitter.length == 4){
			for(int y = 0; y < splitter.length; y++){
				for(int x = 0; x < 255; x++){
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
	
	private JPanel createProfile() {
		createProfile = new JButton("Create Profile");
		createProfile.addActionListener(this);
		createProfilePanel = new JPanel();
		createProfilePanel.setBackground(Color.DARK_GRAY);
		createProfilePanel.add(createProfile);
		return createProfilePanel;
	}
	
	private JPanel quitPanel(){
		JPanel quitPanel = new JPanel();
		quitPanel.setBackground(Color.DARK_GRAY);
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
		connectPanel.setBackground(Color.DARK_GRAY);
		connectPanel.add(connect);
		connectPanel.add(amountChatters);
		connectPanel.add(quitPanel());
		return connectPanel;
	}
	
	private JPanel southLayout() {
		JPanel southPaneltje = new JPanel();
		southPaneltje.setBackground(Color.DARK_GRAY);
		southPaneltje.add(connect(), BorderLayout.NORTH);
		
		return southPaneltje;
	}
	
	private JPanel layOut() {
		JPanel paneltje = new JPanel();
		paneltje.setBackground(Color.DARK_GRAY);
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
			if((nickName.getText().equals("Nickname") || nickName.getText().equals(""))&&(connAddr.getText().equals("Connect Address") || connAddr.getText().equals("")||port.getText().equals(""))){
				new ErrorGUI("Nickname en connect address incorrect", 260);
			}
			else if(nickName.getText().equals("Nickname") || nickName.getText().equals("")){
				new ErrorGUI("Voer nickname in of maak nieuw profiel aan", 280);
			}
			else if(connAddr.getText().equals("Connect Address") || connAddr.getText().equals("") || !onlyNumbersconnAddr(connAddr.getText())){
				new ErrorGUI("Incorrect connect Address", 200);
			}
			else if(!onlyNumbersAbove1023(port.getText())){
				new ErrorGUI("Voer geldige portnummer in", 230);
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
	
	public static void main (String[] args) {
		new ConnectAccountGUI("Henk");
	}
}
