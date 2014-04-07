package gui;

import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class MaakProfielGUI implements ActionListener{

	public MaakProfielGUI(){
		maakProfielFrame();
	}
	
	public JFrame maakProfielFrame(){
		GridBagConstraints c = new GridBagConstraints();
		JFrame maakProfielFrame = new JFrame("Maak nieuw Profiel");
		JPanel maakProfielPanel = new JPanel(new GridLayout(5,2));
		JLabel voornaamLabel = new JLabel("Voornaam: ");
		maakProfielPanel.add(voornaamLabel);
		JTextField voornaam = new JTextField(" ", 10000);
		maakProfielPanel.add(voornaam);
		
		JTextField achternaam = new JTextField(" ", 10000);
		
		JTextField leeftijd = new JTextField(" ", 10000);
		
		JTextField interesses = new JTextField(" ", 10000);
		
		JTextField relatiestatus = new JTextField(" ", 10000);
		
		JLabel achternaamLabel = new JLabel("Achternaam: ");
		JLabel leeftijdLabel = new JLabel("Leeftijd: ");
		JLabel interessesLabel = new JLabel("Interesses: ");
		JLabel relatiestatusLabel = new JLabel("relatiestatus: ");
		voornaam.setEditable(true);
		achternaam.setEditable(true);
		leeftijd.setEditable(true);
		interesses.setEditable(true);
		relatiestatus.setEditable(true);
		
		maakProfielPanel.add(achternaamLabel);
		maakProfielPanel.add(achternaam);
		maakProfielPanel.add(leeftijdLabel);
		maakProfielPanel.add(leeftijd);
		maakProfielPanel.add(interessesLabel);
		maakProfielPanel.add(interesses);
		maakProfielPanel.add(relatiestatusLabel);
		maakProfielPanel.add(relatiestatus);
		maakProfielPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		maakProfielFrame.setSize(500,500);
		maakProfielFrame.setVisible(true);
		maakProfielFrame.setLocationRelativeTo(null);
		//maakProfielFrame.setResizable(false);
		maakProfielFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		maakProfielFrame.add(maakProfielPanel);
		return maakProfielFrame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	static public void main(String[] args) {
	    new MaakProfielGUI();
	}
}
