package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class ErrorGUI implements ActionListener{
	JFrame errorFrame;
	JButton okButton;
	String errorMessage;
	int width;
	
	public ErrorGUI(String errorMessage, int width){
		this.errorMessage = errorMessage;
		this.width = width;
		errorFrame();
	}
	
	public JPanel textPanel(){
		JPanel textPanel = new JPanel();
		JLabel errorLabel = new JLabel(errorMessage);
		textPanel.add(errorLabel);
		return textPanel;
	}
	
	public JPanel buttonPanel(){
		JPanel buttonPanel = new JPanel();
		okButton = new JButton("OK");
		okButton.addActionListener(this);
		buttonPanel.add(okButton);
		return buttonPanel;
	}
	
	public JFrame errorFrame(){
		errorFrame = new JFrame("Error!");
		errorFrame.setLayout(new GridLayout(2,1));
		errorFrame.add(textPanel());
		errorFrame.add(buttonPanel());
		errorFrame.setVisible(true);
		errorFrame.setSize(width, 120);
		errorFrame.setResizable(false);
		errorFrame.setLocationRelativeTo(null);
		errorFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		return errorFrame;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == okButton){
			errorFrame.dispose();
		}
	}

}
