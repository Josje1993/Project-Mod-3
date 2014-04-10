package gui;

import java.awt.BorderLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class StartGUI extends JPanel implements ActionListener {

//-----------------------------------------------------------------------//
	
	private static final long serialVersionUID = 2294551299848220328L;
	private JLabel title;
	private JButton start;
	private JButton quit;
	private JLabel groep;
	private ImageIcon namePic;
	private ImageIcon titlePic;
	private ImageIcon startPic;
	private ImageIcon quitPic;
	private JFrame starter;
	private JPanel titlePanel;
	private JPanel centerPanel;
	private JPanel namePanel;
	private BorderLayout layout;
//-----------------------------------------------------------------------//

	public StartGUI() {
		importPNGs();
		starter = new JFrame("Chatser");
		layout = new BorderLayout();
		starter.setLayout(layout);
		starter.add(northTitle(), BorderLayout.NORTH);
		starter.add(centerSQ(), BorderLayout.CENTER);
		starter.add(names(), BorderLayout.SOUTH);
		
		starter.setVisible(true);
		starter.setSize(400, 300);
		starter.setLocationRelativeTo(null);
		starter.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
	private void importPNGs() {
		namePic = new ImageIcon("groep.png");
		titlePic = new ImageIcon("ChatserStart.png");
		startPic = new ImageIcon("Startbutton.png");
		quitPic = new ImageIcon("Quitbutton.png");
	}
	
	
	
	private JPanel northTitle() {
		title = new JLabel(titlePic);
		titlePanel = new JPanel();
		titlePanel.add(title);
		return titlePanel;
	}
	
	private JPanel centerSQ() {
		start = new JButton(startPic);
		start.setOpaque(false);
		start.setContentAreaFilled(false);
		start.setBorderPainted(false);
		start.addActionListener(this);
		quit = new JButton(quitPic);
		quit.setOpaque(false);
		quit.setContentAreaFilled(false);
		quit.setBorderPainted(false);
		quit.addActionListener(this);
		centerPanel = new JPanel();
		centerPanel.add(start);
		centerPanel.add(quit);
		return centerPanel;
	}
	
	private JPanel names() {
		groep = new JLabel(namePic);
		namePanel = new JPanel();
		namePanel.add(groep);
		return namePanel;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == start) {
			new Terms_ConditionsGui();
			starter.dispose();
		}
		
		if (arg0.getSource() == quit) {
			starter.dispose();
		}
	}
	
	public static void main(String[] args0) {
		new StartGUI();
	}

}
