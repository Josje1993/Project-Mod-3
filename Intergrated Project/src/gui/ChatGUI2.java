package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class ChatGUI2 implements ActionListener {

	// --------------------------------------------------------------------------//

	@SuppressWarnings("unused")
	private static final long serialVersionUID = -591603013574440445L;
	private String myNickName;
	private JFrame chatser;
	private JButton settings;
	private JButton log_out;
	private JButton extentions;
	private JButton send;
	private JTextArea nameAndProfile;
	private JTextField input;
	private JTextArea chatBox;
	private BorderLayout layout;
	private ImageIcon settingsPic;
	private ImageIcon logoutPic;
	private static final String TITLE = "Chatser";
	private Border blackline = BorderFactory.createLineBorder(Color.BLACK);
	

	// --------------------------------------------------------------------------//

	public ChatGUI2(String myNickName) {
		this.myNickName = myNickName;
		importPictures();
		chatser = new JFrame();
		chatser.setTitle(TITLE + " - " + myNickName);
		layout = new BorderLayout();
		chatser.setLayout(layout);
		chatser.add(chatBoxPanel(), BorderLayout.CENTER);
		chatser.add(eastSide(), BorderLayout.EAST);
		chatser.add(toSend_ExtentionsAndSendPanel(), BorderLayout.SOUTH);
		chatser.setVisible(true);
		chatser.setSize(600, 500);
		chatser.setResizable(false);
		chatser.setLocationRelativeTo(null);
		chatser.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	private void importPictures() {
		settingsPic = new ImageIcon("settings.png");
		logoutPic = new ImageIcon("logout.png");
	}

	private JScrollPane chatBoxPanel() {
		chatBox = new JTextArea(25, 30);
		chatBox.setBorder(blackline);
		chatBox.setEditable(false);
		JScrollPane chatBoxScrollPane = new JScrollPane(chatBox);
		chatBoxScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		chatBoxScrollPane.setPreferredSize(new Dimension(250, 250));
		return chatBoxScrollPane;
	}

	private JPanel eastSide() {
		BorderLayout layOut = new BorderLayout();
		JPanel eastSidePanel = new JPanel(layOut);
		eastSidePanel.add(settingsAndLogoutPanel(), BorderLayout.CENTER);
		eastSidePanel.add(profileInfo(), BorderLayout.SOUTH);

		return eastSidePanel;
	}

	private JPanel profileInfo() {
		JPanel profileInfoPanel = new JPanel();
		nameAndProfile = new JTextArea(14, 20);
		nameAndProfile.setEditable(false);
		TitledBorder title = BorderFactory.createTitledBorder(blackline,"Profile of name1");
		title.setTitleJustification(TitledBorder.CENTER);
		nameAndProfile.setBorder(title);
		profileInfoPanel.add(nameAndProfile);
		return profileInfoPanel;
	}

	private JPanel toSend_ExtentionsAndSendPanel() {
		JPanel toSend_ExtentionsAndSendPanel = new JPanel();
		input = new JTextField("", 37);
		extentions = new JButton("Extentions");
		send = new JButton("Send");
		toSend_ExtentionsAndSendPanel.add(input);
		toSend_ExtentionsAndSendPanel.add(send);
		toSend_ExtentionsAndSendPanel.add(extentions);
		return toSend_ExtentionsAndSendPanel;
	}

	private JPanel settingsAndLogoutPanel() {
		JPanel settingsAndLogoutPanel = new JPanel();
		settings = new JButton(settingsPic);
		settings.setOpaque(false);
		settings.setContentAreaFilled(false);
		settings.setBorderPainted(false);
		log_out = new JButton(logoutPic);
		log_out.setOpaque(false);
		log_out.setContentAreaFilled(false);
		log_out.setBorderPainted(false);
		log_out.addActionListener(this);
		settingsAndLogoutPanel.add(settings);
		settingsAndLogoutPanel.add(log_out);
		return settingsAndLogoutPanel;
	}

	public static void main(String[] args) {
		new ChatGUI2("hoi");
	}

	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == log_out){
			chatser.dispose();
			new ConnectGUI(myNickName);
		}
	}

}
