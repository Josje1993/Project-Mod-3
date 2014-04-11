package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class QuitGUI implements ActionListener{
	public JFrame quitFrame;
	public JButton yesButton;
	public JButton noButton;
	public boolean quitCheck = false;
	
	public QuitGUI(){
		quitFrame();
	}
	
	public void quitFrame(){
		quitFrame = new JFrame();
		quitFrame.setLayout(new BorderLayout());
		quitFrame.add(textPanel(), BorderLayout.NORTH);
		quitFrame.add(yesPanel(), BorderLayout.WEST);
		quitFrame.add(noPanel(), BorderLayout.EAST);
		quitFrame.add(dumb(), BorderLayout.CENTER);
		quitFrame.add(dumb2(), BorderLayout.SOUTH);
		quitFrame.setSize(220,110);
		quitFrame.setVisible(true);
		quitFrame.setLocationRelativeTo(null);
		quitFrame.setResizable(false);
		quitFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
	
	public JPanel dumb() {
		JPanel dumbPanel = new JPanel();
		dumbPanel.setBackground(Color.DARK_GRAY);
		return dumbPanel;
	}
	
	public JPanel dumb2() {
		JPanel dumb2Panel = new JPanel();
		dumb2Panel.setBackground(Color.DARK_GRAY);
		return dumb2Panel;
	}
	
	public JPanel textPanel(){
		JLabel textLabel = new JLabel("<html> <font color='white'>Weet u zeker dat u wilt afsluiten?</font></html>");
		Font labelFont = new Font("28 Days Later",Font.PLAIN,14);
		textLabel.setFont(labelFont);
		JPanel textPanel = new JPanel();
		textPanel.setBackground(Color.DARK_GRAY);
		textPanel.add(textLabel);
		return textPanel;
	}
	
	public JPanel yesPanel(){
		JPanel yesPanel = new JPanel();
		yesPanel.setBackground(Color.DARK_GRAY);
		yesButton = new JButton("<html> <font color='white'>Ja</font></html>");
		Font yesFont = new Font("28 Days Later",Font.PLAIN,20);
		yesButton.setFont(yesFont);
		yesButton.setOpaque(false);
		yesButton.setContentAreaFilled(false);
		yesButton.setBorderPainted(false);
		yesButton.addActionListener(this);
		yesPanel.add(yesButton);
		yesPanel.setBorder(BorderFactory.createEmptyBorder(0,20,0,0));
		return yesPanel;
	}
	
	public JPanel noPanel(){
		JPanel noPanel = new JPanel();
		noPanel.setBackground(Color.DARK_GRAY);
		noButton = new JButton("<html> <font color='white'>No</font></html>");
		Font noFont = new Font("28 Days Later",Font.PLAIN,20);
		noButton.setFont(noFont);
		noButton.setOpaque(false);
		noButton.setContentAreaFilled(false);
		noButton.setBorderPainted(false);
		noButton.addActionListener(this);
		noPanel.add(noButton);
		noPanel.setBorder(BorderFactory.createEmptyBorder(0,0,0,20));
		return noPanel;
	}
	
	static public void main(String[] args) {
	    new QuitGUI();
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == yesButton){
			quitFrame.dispose();
			quitCheck = true;
		}
		if(ae.getSource() == noButton){
			quitFrame.dispose();
			quitCheck = false;
		}
	}

	public boolean getQuitCheck() {
		return quitCheck;
	}
	
}
