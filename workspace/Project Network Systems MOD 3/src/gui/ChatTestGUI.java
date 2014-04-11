package gui;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.*;

import listeners.FileSendListener;
import listeners.FrameListener;
import listeners.SendButtonListener;
import main.Messager;

/**
 * Gui for testing the chat fuction. 
 * @author Joshua
 *
 */
public class ChatTestGUI {
	JFrame mainFrame;
	JTextArea input;
	JButton send;
	JButton file;
	Messager target;
	JPanel panel;
	private static final String nodeName = "Peter";
	public ChatTestGUI(Messager messager) {
		target = messager;
		mainFrame = new JFrame(nodeName + " Test GUI");
		input = new JTextArea(1, 23);
		input.setLineWrap(true);
		input.setWrapStyleWord(true);
		input.setAutoscrolls(true);
		input.setEditable(true);
		panel = new JPanel();
		send = new JButton("Send");
		file = new JButton("File");
		send.addActionListener(new SendButtonListener(target, send, input));
		file.addActionListener(new FileSendListener(target, file, input));
		mainFrame.addWindowListener(new FrameListener(mainFrame, target));
	}

	/**
	 * Sets the layout of the components and add the components to the JFrame.
	 */
	private void setUp() {
		input.setPreferredSize(new Dimension(100, 25));
		send.setPreferredSize(new Dimension(100, 25));
		file.setPreferredSize(new Dimension(100, 25));
		mainFrame.setSize(300, 200);
		mainFrame.setVisible(true);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setResizable(false);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 25));
		panel.add(input);
		panel.add(send);
		panel.add(file);
		mainFrame.add(panel);
	}

	/**
	 * Creates a new ChatGUI
	 * @param args
	 */
	public static void main(String[] args) {
		ChatTestGUI gui = new ChatTestGUI(new Messager(6879, "225.255.230.230",
				nodeName));
		gui.setUp();
	}

}
