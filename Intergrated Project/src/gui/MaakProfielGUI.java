package gui;

import java.awt.BorderLayout;
import java.awt.Color;
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

	public MaakProfielGUI(){
		maakProfielFrame();
	}
	
	public JFrame maakProfielFrame(){
		JFrame maakProfielFrame = new JFrame("Maak nieuw Profiel");
		
		GridLayout grid = new GridLayout();
		grid.setRows(5);
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
		
		textFieldPanel1.setBorder(BorderFactory.createEmptyBorder(0,10,0,0));
		textFieldPanel2.setBorder(BorderFactory.createEmptyBorder(0,10,0,0));
		textFieldPanel3.setBorder(BorderFactory.createEmptyBorder(0,10,0,0));
		textFieldPanel4.setBorder(BorderFactory.createEmptyBorder(0,10,0,0));
		textFieldPanel5.setBorder(BorderFactory.createEmptyBorder(0,10,30,0));
		
		JButton maakProfielButton = new JButton("Maak Profiel");
		maakProfielButton.addActionListener(this);
		JPanel maakProfielButtonPanel = new JPanel();
		maakProfielButtonPanel.add(maakProfielButton);
		
		JTextField voornaam = new JTextField(" ", 30);
		JTextField achternaam = new JTextField(" ", 30);
		JTextField leeftijd = new JTextField(" ", 30);
		JTextField interesses = new JTextField(" ", 30);
		JTextField relatiestatus = new JTextField(" ", 30);
		
		JLabel voornaamLabel = new JLabel("Voornaam: ");
		JLabel achternaamLabel = new JLabel("Achternaam: ");
		JLabel leeftijdLabel = new JLabel("Leeftijd: ");
		JLabel interessesLabel = new JLabel("Interesses: ");
		JLabel relatiestatusLabel = new JLabel("relatiestatus: ");
		
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
		
		textFieldPanel.add(textFieldPanel1);
		textFieldPanel.add(textFieldPanel2);
		textFieldPanel.add(textFieldPanel3);
		textFieldPanel.add(textFieldPanel4);
		textFieldPanel.add(textFieldPanel5);
		
		labelPanel.add(labelPanel1);
		labelPanel.add(labelPanel2);
		labelPanel.add(labelPanel3);
		labelPanel.add(labelPanel4);
		labelPanel.add(labelPanel5);
		
		maakProfielFrame.setSize(500,430);
		maakProfielFrame.setVisible(true);
		maakProfielFrame.setResizable(true);
		maakProfielFrame.setLocationRelativeTo(null);
		maakProfielFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		maakProfielPanel.add(labelPanel, BorderLayout.WEST);
		maakProfielPanel.add(textFieldPanel, BorderLayout.CENTER);
		maakProfielPanel.add(maakProfielButtonPanel, BorderLayout.SOUTH);
		maakProfielPanel1.add(maakProfielPanel);
		maakProfielPanel1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Maak chat profiel aan:"));
		maakProfielFrame.add(maakProfielPanel1);
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
