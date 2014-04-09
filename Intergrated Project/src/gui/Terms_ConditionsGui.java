package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import javax.swing.border.Border;

public class Terms_ConditionsGui extends JPanel implements ActionListener { 
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8670650550571225109L;
	private JCheckBox iAgree;
	private BorderLayout layout;
	private JFrame conditions;
	private JLabel terms_of_agreement;
	private JLabel agreeLabel;
	private JTextArea terms;
	private JButton agreed;
	private JButton notAgreed;
	private Border blackline = BorderFactory.createLineBorder(Color.BLACK);
	private static final String TEXT = " This is an agreement between Chatser Inc., \n"
			+ " a Dutch corporation (“Chatser”), \n"
			+ " the owner and operator of www.Chatser.nl (the “Chatser Site”), \n"
			+ " the Chatser software, \n"
			+ " including Chatser Messenger (collectively, including all content provided \n"
			+ " by Chatser through Chatser Messenger and the Chatser Site, \n"
			+ " the “Chatser Service”, or the “Service”), and you (“you” or “You”),\n"
			+ " a user of the Service. \n\n"
			+ " BY USING THE SERVICE, YOU ACKNOWLEDGE AND AGREE \n"
			+ " TO THESE TERMS OF SERVICE, AND CHATSERS'S PRIVACY POLICY, \n"
			+ " WHICH CAN BE FOUND AT: \n"
			+ " http://www.Chatser.com/legal/#Privacy, \n"
			+ " AND WHICH ARE INCORPORATED HEREIN BY REFERENCE. \n\n"
			+ " If you choose to not agree with any of these terms, \n"
			+ " you may not use the Service. \n\n"
			+ " PS. Don't take this seriously, because you know you are not a fool! \n\n"
			+ " BUT DON'T EVER EVER EVER SELL YOUR SOUL TO FACEBOOK! \n"
			+ " JUST LIKE WHATSAPP AND OCULUS RIFT. \n\n"
			+ " COME TO OUR SIDE, WE HAVE COOKIES ;)";
	

	public Terms_ConditionsGui() {
		conditions = new JFrame();
		conditions.setTitle("Terms and Conditions");
		layout = new BorderLayout();
		conditions.setLayout(layout);
		conditions.add(title(), BorderLayout.NORTH);
		conditions.add(termsBoxPanel(), BorderLayout.CENTER);
		conditions.add(agreeing(), BorderLayout.SOUTH);
		conditions.setVisible(true);
		conditions.setSize(450, 300);
		conditions.setLocationRelativeTo(null);
		conditions.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
	private JPanel title() {
		JPanel titlePanel = new JPanel();
		terms_of_agreement = new JLabel("Accept the following terms and conditions:");
		titlePanel.add(terms_of_agreement);
		return titlePanel;
	}
	
	private JPanel agreeing() {
		JPanel agreePanel = new JPanel();
		iAgree = new JCheckBox();
		iAgree.addActionListener(this);
		agreeLabel = new JLabel("I agree with the terms and conditions");
		agreed = new JButton("Next");
		agreed.setEnabled(false);
		agreed.addActionListener(this);
		notAgreed = new JButton("Cancel");
		notAgreed.addActionListener(this);
		agreePanel.add(iAgree);
		agreePanel.add(agreeLabel);
		agreePanel.add(agreed);
		agreePanel.add(notAgreed);
		return agreePanel;
	}
	
	private JScrollPane termsBoxPanel(){
		terms = new JTextArea(25,30);
		terms.setBorder(blackline);
		terms.setText(TEXT);
		terms.setEditable(false);
		JScrollPane chatBoxScrollPane = new JScrollPane(terms);
		chatBoxScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		chatBoxScrollPane.setPreferredSize(new Dimension(250, 250));
		return chatBoxScrollPane;
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == agreed) {
			new ConnectGUI("Nickname");
			conditions.dispose();
		}
		if (e.getSource() == notAgreed) {
			conditions.dispose();
		}
		if (iAgree != null);
			agreed.setEnabled(true);
	}
	
	public static void main(String[] args0){
		new Terms_ConditionsGui();
	}
}