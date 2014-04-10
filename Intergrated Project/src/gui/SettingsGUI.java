package gui;

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
		notificationSoundCheckbox = new JCheckBox();
		if(statusSetting){
			notificationSoundCheckbox.setSelected(true);
			statusSetting2 = false;
		}else{
			notificationSoundCheckbox.setSelected(false);
			statusSetting2 = true;
		}
		notificationLabel = new JButton("Zet notificatie-geluid uit");
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
		versionLabel = new JLabel("Alpha version 0.1");
		versionPanel.add(versionLabel);
		return versionPanel;
	}
	
	private JPanel copyRight() {
		JPanel copyRightPanel = new JPanel();
		copyrightLabel = new JLabel("Chatser\u00a9");
		copyRightPanel.add(copyrightLabel);
		return copyRightPanel;
	}
	
	private JPanel okButton() {
		JPanel okButtonPanel = new JPanel();
		okButton = new JButton("Save and Apply Settings");
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
