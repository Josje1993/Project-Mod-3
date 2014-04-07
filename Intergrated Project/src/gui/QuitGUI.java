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
	
	public QuitGUI(){
		quitFrame();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
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
		quitFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
	public JPanel textPanel(){
		JLabel textLabel = new JLabel("Weet u zeker dat u wilt afsluiten?");
		JPanel textPanel = new JPanel();
		textPanel.add(textLabel);
		return textPanel;
	}
	
	public JPanel yesPanel(){
		JPanel yesPanel = new JPanel();
		JButton yesButton = new JButton("Ja");
		yesButton.addActionListener(this);
		yesPanel.add(yesButton);
		yesPanel.setBorder(BorderFactory.createEmptyBorder(0,20,0,0));
		return yesPanel;
	}
	
	public JPanel noPanel(){
		JPanel noPanel = new JPanel();
		JButton noButton = new JButton("Nee");
		noButton.addActionListener(this);
		noPanel.add(noButton);
		noPanel.setBorder(BorderFactory.createEmptyBorder(0,0,0,20));
		return noPanel;
	}

	static public void main(String[] args) {
	    new QuitGUI();
	}
}
