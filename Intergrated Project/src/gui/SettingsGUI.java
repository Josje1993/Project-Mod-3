package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.WindowConstants;

public class SettingsGUI extends JPanel implements ActionListener{

	private static final long serialVersionUID = 2649087924237302027L;
	public JCheckBox notificationSoundCheckbox;
	private BoxLayout layout;
	private JFrame settings;
	private JButton notificationLabel;
	private JLabel versionLabel;
	private JLabel copyrightLabel;
	private static final String TITLE = "Settings";
	private boolean statusSetting;
	private boolean statusSetting2 = false;
	private JButton okButton;
	
	//---------------------------------------------------------------------//
	
	public SettingsGUI(boolean status) {
		statusSetting = status;
		settings = new JFrame();
		settings.setTitle(TITLE);
		layout = new BoxLayout(settings.getContentPane(), BoxLayout.Y_AXIS);
		settings.setLayout(layout);
		settings.add(notificationSound());
		settings.add(okButton());
		settings.add(version());
		settings.add(copyRight());
		settings.setVisible(true);
		settings.setSize(300,170);
		settings.setLocationRelativeTo(null);
		settings.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
	
	private JPanel notificationSound() {
		JPanel notSoundPanel = new JPanel();
		notSoundPanel.setBackground(Color.GRAY);
		notificationSoundCheckbox = new JCheckBox();
		notificationSoundCheckbox.setBackground(Color.GRAY);
		if(statusSetting){
			notificationSoundCheckbox.setSelected(true);
			statusSetting2 = false;
		}else{
			notificationSoundCheckbox.setSelected(false);
			statusSetting2 = true;
		}
		notificationLabel = new JButton("<html> <font color='white'>Zet notificatie-geluid uit</font></html>");
		Font notFont = new Font("28 Days Later",Font.PLAIN,16);
		notificationLabel.setFont(notFont);
		notificationLabel.setOpaque(false);
		notificationLabel.setContentAreaFilled(false);
		notificationLabel.setBorderPainted(false);
		notificationLabel.addActionListener(this);
		notSoundPanel.add(notificationSoundCheckbox);
		notSoundPanel.add(notificationLabel);
		return notSoundPanel;
	}
	
	private JPanel version(){
		JPanel versionPanel = new JPanel();
		versionPanel.setBackground(Color.GRAY);
		versionLabel = new JLabel("<html> <font color='white'>Alpha version 0.1</font></html>");
		Font verFont = new Font("28 Days Later",Font.PLAIN,14);
		versionLabel.setFont(verFont);
		versionPanel.add(versionLabel);
		return versionPanel;
	}
	
	private JPanel copyRight() {
		JPanel copyRightPanel = new JPanel();
		copyRightPanel.setBackground(Color.GRAY);
		copyrightLabel = new JLabel("<html> <font color='white'>Chatser\u00a9</font></html>");
		Font copFont = new Font("28 Days Later",Font.PLAIN,14);
		copyrightLabel.setFont(copFont);
		copyRightPanel.add(copyrightLabel);
		return copyRightPanel;
	}
	
	private JPanel okButton() {
		JPanel okButtonPanel = new JPanel();
		okButtonPanel.setBackground(Color.GRAY);
		okButton = new JButton("<html> <font color='white'>Save and Apply Settings</font></html>");
		Font okFont = new Font("28 Days Later",Font.PLAIN,16);
		okButton.setFont(okFont);
		okButton.setOpaque(false);
		okButton.setContentAreaFilled(false);
		okButton.setBorderPainted(false);
		okButton.addActionListener(this);
		okButtonPanel.add(okButton);
		return okButtonPanel;
	}
	
	public static void main(String[] args){
		new SettingsGUI(false);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == okButton){
			settings.dispose();
		}
		if (ae.getSource() == notificationLabel) {
			if(statusSetting2){
				notificationSoundCheckbox.setSelected(true);
				statusSetting2 = false;
			}
			else{
				notificationSoundCheckbox.setSelected(false);
				statusSetting2 = true;
			}
			
		}
	}
	
}
