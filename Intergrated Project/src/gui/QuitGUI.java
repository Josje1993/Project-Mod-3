package gui;

import java.awt.BorderLayout;
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
		quitFrame.setSize(220,110);
		quitFrame.setVisible(true);
		quitFrame.setLocationRelativeTo(null);
		quitFrame.setResizable(false);
		quitFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
	
	public JPanel textPanel(){
		JLabel textLabel = new JLabel("Weet u zeker dat u wilt afsluiten?");
		JPanel textPanel = new JPanel();
		textPanel.add(textLabel);
		return textPanel;
	}
	
	public JPanel yesPanel(){
		JPanel yesPanel = new JPanel();
		yesButton = new JButton("Ja");
		yesButton.addActionListener(this);
		yesPanel.add(yesButton);
		yesPanel.setBorder(BorderFactory.createEmptyBorder(0,20,0,0));
		return yesPanel;
	}
	
	public JPanel noPanel(){
		JPanel noPanel = new JPanel();
		noButton = new JButton("Nee");
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
