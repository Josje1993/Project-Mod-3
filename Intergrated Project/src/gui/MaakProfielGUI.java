package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class MaakProfielGUI implements ActionListener{
	JButton maakProfielButton;
	JButton geenNieuwProfiel;
	JButton okButton;
	JFrame errorFrame;
	JFrame maakProfielFrame;
	JTextField voornaam;
	JTextField achternaam;
	JTextField leeftijd;
	JTextField nickname;

	public MaakProfielGUI(){
		maakProfielFrame();
	}
	
	public JFrame maakProfielFrame(){
		maakProfielFrame = new JFrame("Maak nieuw Profiel");
		
		GridLayout grid = new GridLayout();
		grid.setRows(6);
		grid.setColumns(1);
		JPanel labelPanel = new JPanel(grid);
		JPanel textFieldPanel = new JPanel(grid);
		JPanel maakProfielPanel = new JPanel(new BorderLayout());
		JPanel maakProfielPanel1 = new JPanel();
		
		JPanel labelPanel1 = new JPanel();
		JPanel labelPanel2 = new JPanel();
		JPanel labelPanel3 = new JPanel();
		JPanel labelPanel4 = new JPanel();
		JPanel labelPanel5 = new JPanel();
		JPanel labelPanel6 = new JPanel();
		JPanel labelPanel7 = new JPanel();
		
		labelPanel6.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
		labelPanel1.setBorder(BorderFactory.createEmptyBorder(0,10,0,0));
		labelPanel2.setBorder(BorderFactory.createEmptyBorder(0,10,0,0));
		labelPanel3.setBorder(BorderFactory.createEmptyBorder(0,10,0,0));
		labelPanel4.setBorder(BorderFactory.createEmptyBorder(0,10,0,0));
		labelPanel5.setBorder(BorderFactory.createEmptyBorder(0,10,30,0));
		
		JPanel textFieldPanel1 = new JPanel();
		JPanel textFieldPanel2 = new JPanel();
		JPanel textFieldPanel3 = new JPanel();
		JPanel textFieldPanel4 = new JPanel();
		JPanel textFieldPanel5 = new JPanel();
		JPanel textFieldPanel6 = new JPanel();
		
		textFieldPanel6.setBorder(BorderFactory.createEmptyBorder(0,10,0,0));
		textFieldPanel1.setBorder(BorderFactory.createEmptyBorder(0,10,0,0));
		textFieldPanel2.setBorder(BorderFactory.createEmptyBorder(0,10,0,0));
		textFieldPanel3.setBorder(BorderFactory.createEmptyBorder(0,10,0,0));
		textFieldPanel4.setBorder(BorderFactory.createEmptyBorder(0,10,0,0));
		textFieldPanel5.setBorder(BorderFactory.createEmptyBorder(0,10,30,0));
		
		geenNieuwProfiel = new JButton("Ga terug!");
		maakProfielButton = new JButton("Maak Profiel");
		//maakProfielButton.setEnabled(false);
		maakProfielButton.addActionListener(this);
		geenNieuwProfiel.addActionListener(this);
		JPanel maakProfielButtonPanel = new JPanel();	
		maakProfielButtonPanel.add(labelPanel6);
		maakProfielButtonPanel.add(maakProfielButton);
		maakProfielButtonPanel.add(geenNieuwProfiel);
		
		nickname = new JTextField("", 30);
		voornaam = new JTextField("", 30);
		achternaam = new JTextField("", 30);
		leeftijd = new JTextField("", 30);
		JTextField interesses = new JTextField(" ", 30);
		JTextField relatiestatus = new JTextField(" ", 30);
		nickname.setEditable(true);
		voornaam.setEditable(true);
		achternaam.setEditable(true);
		leeftijd.setEditable(true);
		interesses.setEditable(true);
		relatiestatus.setEditable(true);
		
		JLabel nicknameLabel = new JLabel("Nickname*: ");
		JLabel voornaamLabel = new JLabel("Voornaam*: ");
		JLabel achternaamLabel = new JLabel("Achternaam*: ");
		JLabel leeftijdLabel = new JLabel("Leeftijd*: ");
		JLabel interessesLabel = new JLabel("Interesses: ");
		JLabel relatiestatusLabel = new JLabel("relatiestatus: ");
		JLabel verplichteVelden = new JLabel("* Verlplichte velden");

		voornaam.setEditable(true);
		achternaam.setEditable(true);
		leeftijd.setEditable(true);
		interesses.setEditable(true);
		relatiestatus.setEditable(true);
		
		labelPanel1.add(voornaamLabel);
		textFieldPanel1.add(voornaam);
		labelPanel2.add(achternaamLabel);
		textFieldPanel2.add(achternaam);
		labelPanel3.add(leeftijdLabel);
		textFieldPanel3.add(leeftijd);
		labelPanel4.add(interessesLabel);
		textFieldPanel4.add(interesses);
		labelPanel5.add(relatiestatusLabel);
		textFieldPanel5.add(relatiestatus);
		labelPanel6.add(nicknameLabel);
		textFieldPanel6.add(nickname);
		labelPanel7.add(verplichteVelden);
		
		textFieldPanel.add(textFieldPanel6);
		textFieldPanel.add(textFieldPanel1);
		textFieldPanel.add(textFieldPanel2);
		textFieldPanel.add(textFieldPanel3);
		textFieldPanel.add(textFieldPanel4);
		textFieldPanel.add(textFieldPanel5);
		
		labelPanel.add(labelPanel6);
		labelPanel.add(labelPanel1);
		labelPanel.add(labelPanel2);
		labelPanel.add(labelPanel3);
		labelPanel.add(labelPanel4);
		labelPanel.add(labelPanel5);
		
		maakProfielFrame.setSize(500,480);
		maakProfielFrame.setVisible(true);
		maakProfielFrame.setResizable(false);
		maakProfielFrame.setLocationRelativeTo(null);
		maakProfielFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		maakProfielPanel.add(labelPanel, BorderLayout.WEST);
		maakProfielPanel.add(textFieldPanel, BorderLayout.CENTER);
		maakProfielPanel.add(maakProfielButtonPanel, BorderLayout.SOUTH);
		maakProfielPanel1.add(maakProfielPanel);
		maakProfielPanel1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Maak chat profiel aan:"));
		maakProfielFrame.add(maakProfielPanel1);
		return maakProfielFrame;
	}
	
	public JFrame errorFrame(){
		errorFrame = new JFrame();
		errorFrame.setLayout(new FlowLayout());
		JLabel errorLabel = new JLabel("Niet alle verplichte velden zijn ingevoerd");
		errorFrame.add(errorLabel);
		okButton = new JButton("OK");
		okButton.addActionListener(this);
		errorFrame.add(okButton);
		errorFrame.setVisible(true);
		errorFrame.setSize(250, 120);
		errorFrame.setResizable(false);
		errorFrame.setLocationRelativeTo(null);
		errorFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		return errorFrame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == maakProfielButton){
			if(voornaam.getText().equals("")||achternaam.getText().equals("")||leeftijd.getText().equals("")||nickname.getText().equals("")){
				errorFrame();
				maakProfielFrame.setEnabled(false);
			}
			else{
				maakProfielFrame.dispose();
				new ConnectGUI(nickname.getText());
			}
		}
		if(e.getSource() == okButton){
			errorFrame.dispose();
			maakProfielFrame.setEnabled(true);
		}
		if(e.getSource() == geenNieuwProfiel){
			maakProfielFrame.dispose();
			new ConnectGUI("Nickname");
		}
	}
}
