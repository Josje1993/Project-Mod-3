package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import main.Messager;

/**
 * ActionListener class that is responsible for monitoring the JButton that
 * needs to pressed in order to broadcast a message.
 * 
 * @author Joshua
 * 
 */
public class SendButtonListener implements ActionListener {
	JButton send;
	JTextArea input;
	Messager messager;

	public SendButtonListener(Messager messager, JButton sendButton,
			JTextArea inputArea) {
		send = sendButton;
		input = inputArea;
		this.messager = messager;
	}

	/**
	 * When the <code>send</code> JButton is pressed then the message that is
	 * given in the <code>input</code> JTextArea is broadcasted to all members
	 * of the multicast group as specified in the settings in the Messager class
	 * of <code>target</code>
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == send) {
			if (input.getText().trim().length() != 0) {
				messager.sendMsg(input.getText());
				input.setText(null);
			}
		}

	}

}
