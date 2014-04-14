package listeners;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;

import main.Messager;

/**
 * ActionListener class that is responsible for making sure every member of the
 * node group knows when a member disconnects.
 * 
 * @author Joshua
 * 
 */
public class FrameListener implements WindowListener {
	JFrame frame;
	Messager target;

	public FrameListener(JFrame frame, Messager messager) {
		this.frame = frame;
		target = messager;
	}

	/**
	 * When the <code>send</code> JButton is pressed then the message that is
	 * given in the <code>input</code> JTextArea is broadcasted to all members
	 * of the multicast group as specified in the settings in the Messager class
	 * of <code>target</code>
	 */

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		target.close();
		System.exit(0);
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}
}
