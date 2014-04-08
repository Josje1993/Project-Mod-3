package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
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
/**
 * 
 * @author Gerwin
 *
 */
public class ChatGUI extends JPanel implements ActionListener{

//--------------------------------------------------------------------------//
	
	private static final long serialVersionUID = -591603013574440445L;
	private String myNickName;
	private JFrame chatser;
	private JButton settings;
	private JButton log_out;
	private JButton name1;
	private JButton name2;
	private JButton name3;
	private JButton extentions;
	private JButton send;
	private JTextArea nameAndProfile;
	private JTextField input;
	private JTextArea chatBox;
	private JPanel card1;
	private JPanel card2;
	private JPanel card3;
	private JPanel switchPanel;
	private BorderLayout layout;
	private ImageIcon settingsPic;
	private ImageIcon logoutPic;
	private static final String TITLE = "Chatser";
	private Border blackline = BorderFactory.createLineBorder(Color.BLACK);
	
//--------------------------------------------------------------------------//
	
	public ChatGUI(String myNickName) {
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
	
	private void importPictures(){
		settingsPic = new ImageIcon("settings.png");
		logoutPic = new ImageIcon("logout.png");
	}
	
	private JScrollPane chatBoxPanel(){
		chatBox = new JTextArea(25,30);
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
		eastSidePanel.add(settingsAndLogoutPanel(),BorderLayout.NORTH);
		eastSidePanel.add(namesChooser(), BorderLayout.CENTER);
		eastSidePanel.add(switchingPanel(), BorderLayout.SOUTH);
		
		return eastSidePanel;
	}
	
	private JPanel namesChooser(){
		GridLayout grid = new GridLayout();
		grid.setColumns(1);
		grid.setRows(3);
		JPanel namesChooserPanel = new JPanel(grid);
		name1 = new JButton("Name1");
		name2 = new JButton("Name2");
		name3 = new JButton("Name3");
		name1.addActionListener(this);
		name2.addActionListener(this);
		name3.addActionListener(this);
		JPanel name1Panel = new JPanel();
		JPanel name2Panel = new JPanel();
		JPanel name3Panel = new JPanel();
		name1Panel.add(name1);
		name2Panel.add(name2);
		name3Panel.add(name3);
		namesChooserPanel.add(name1Panel);
		namesChooserPanel.add(name2Panel);
		namesChooserPanel.add(name3Panel);
		return namesChooserPanel;
	}
	
	private JPanel profileInfo1(){
		JPanel profileInfoPanel = new JPanel();
		nameAndProfile = new JTextArea(14,20);
		nameAndProfile.setEditable(false);
		TitledBorder title = BorderFactory.createTitledBorder(blackline, "Profile of name1");
		title.setTitleJustification(TitledBorder.CENTER);
		nameAndProfile.setBorder(title);
		profileInfoPanel.add(nameAndProfile);
		return profileInfoPanel;
	}
	
	private JPanel profileInfo2(){
		JPanel profileInfoPanel = new JPanel();
		nameAndProfile = new JTextArea(14,20);
		nameAndProfile.setEditable(false);
		TitledBorder title = BorderFactory.createTitledBorder(blackline, "Profile of name2");
		title.setTitleJustification(TitledBorder.CENTER);
		nameAndProfile.setBorder(title);
		profileInfoPanel.add(nameAndProfile);
		return profileInfoPanel;
	}
	
	private JPanel profileInfo3(){
		JPanel profileInfoPanel = new JPanel();
		nameAndProfile = new JTextArea(14,20);
		nameAndProfile.setEditable(false);
		TitledBorder title = BorderFactory.createTitledBorder(blackline, "Profile of name3");
		title.setTitleJustification(TitledBorder.CENTER);
		nameAndProfile.setBorder(title);
		profileInfoPanel.add(nameAndProfile);
		return profileInfoPanel;
	}
	
	private JPanel toSend_ExtentionsAndSendPanel(){
		JPanel toSend_ExtentionsAndSendPanel = new JPanel();
		input = new JTextField("",37);
		extentions = new JButton("Extentions");
		send = new JButton("Send");
		toSend_ExtentionsAndSendPanel.add(input);
		toSend_ExtentionsAndSendPanel.add(send);
		toSend_ExtentionsAndSendPanel.add(extentions);
		return toSend_ExtentionsAndSendPanel;
	}
	
	private JPanel settingsAndLogoutPanel(){
		JPanel settingsAndLogoutPanel = new JPanel();
		settings = new JButton(settingsPic);
		settings.setOpaque(false);
		settings.setContentAreaFilled(false);
		settings.setBorderPainted(false);
		log_out = new JButton(logoutPic);
		log_out.setOpaque(false);
		log_out.setContentAreaFilled(false);
		log_out.setBorderPainted(false);
		settingsAndLogoutPanel.add(settings);
		settingsAndLogoutPanel.add(log_out);
		return settingsAndLogoutPanel;
	}
	
	private JPanel switchingPanel() {
		switchPanel = new JPanel(new CardLayout());
		card1 = profileInfo1();
		card2 = profileInfo2();
		card3 = profileInfo3();
		switchPanel.add(card1, "Person1");
		switchPanel.add(card2, "Person2");
		switchPanel.add(card3, "Person3");
		return switchPanel;
	}
	
	public static void main(String[] args){
		new ChatGUI("hoi");
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		CardLayout cl = (CardLayout) switchPanel.getLayout();
		if(ae.getSource() == name1){
			cl.show(switchPanel, "Person1");
		}else if(ae.getSource() == name2){
			cl.show(switchPanel, "Person2");
		}else if(ae.getSource() == name3){
			cl.show(switchPanel, "Person3");
		}
	}

}
