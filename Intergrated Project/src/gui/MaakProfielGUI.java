package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class MaakProfielGUI implements ActionListener{
	WindowListener listener = new WindowAdapter(){
		public void windowClosing(WindowEvent we){
			maakProfielFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			new ConnectGUI("Nickname");
		}	
	};
	JButton maakProfielButton;
	JButton geenNieuwProfiel;
	JFrame maakProfielFrame;
	JTextField voornaam;
	JTextField achternaam;
	JTextField leeftijd;
	JTextField nickname;

	public MaakProfielGUI(){
		maakProfielFrame();
	}
	
	public JPanel labelPanel(){
		GridLayout grid = new GridLayout();
		grid.setRows(6);
		grid.setColumns(1);
		JPanel labelPanel = new JPanel(grid);
		
		JPanel labelPanel1 = new JPanel();
		JPanel labelPanel2 = new JPanel();
		JPanel labelPanel3 = new JPanel();
		JPanel labelPanel4 = new JPanel();
		JPanel labelPanel5 = new JPanel();
		JPanel labelPanel6 = new JPanel();
		
		labelPanel6.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
		labelPanel1.setBorder(BorderFactory.createEmptyBorder(0,10,0,0));
		labelPanel2.setBorder(BorderFactory.createEmptyBorder(0,10,0,0));
		labelPanel3.setBorder(BorderFactory.createEmptyBorder(0,10,0,0));
		labelPanel4.setBorder(BorderFactory.createEmptyBorder(0,10,0,0));
		labelPanel5.setBorder(BorderFactory.createEmptyBorder(0,10,30,0));
		
		JLabel nicknameLabel = new JLabel("Nickname*: ");
		JLabel voornaamLabel = new JLabel("Voornaam*: ");
		JLabel achternaamLabel = new JLabel("Achternaam*: ");
		JLabel leeftijdLabel = new JLabel("Leeftijd*: ");
		JLabel interessesLabel = new JLabel("Interesses: ");
		JLabel relatiestatusLabel = new JLabel("relatiestatus: ");
		
		labelPanel1.add(voornaamLabel);
		labelPanel2.add(achternaamLabel);
		labelPanel3.add(leeftijdLabel);
		labelPanel4.add(interessesLabel);
		labelPanel5.add(relatiestatusLabel);
		labelPanel6.add(nicknameLabel);
		
		labelPanel.add(labelPanel6);
		labelPanel.add(labelPanel1);
		labelPanel.add(labelPanel2);
		labelPanel.add(labelPanel3);
		labelPanel.add(labelPanel4);
		labelPanel.add(labelPanel5);
		
		return labelPanel;
	}
	
	public JPanel textFieldPanel(){
		GridLayout grid = new GridLayout();
		grid.setRows(6);
		grid.setColumns(1);
		JPanel textFieldPanel = new JPanel(grid);
		
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
		
		textFieldPanel1.add(voornaam);
		textFieldPanel2.add(achternaam);
		textFieldPanel3.add(leeftijd);
		textFieldPanel4.add(interesses);
		textFieldPanel5.add(relatiestatus);
		textFieldPanel6.add(nickname);
		
		textFieldPanel.add(textFieldPanel6);
		textFieldPanel.add(textFieldPanel1);
		textFieldPanel.add(textFieldPanel2);
		textFieldPanel.add(textFieldPanel3);
		textFieldPanel.add(textFieldPanel4);
		textFieldPanel.add(textFieldPanel5);
		
		return textFieldPanel;
	}
	
	public JPanel maakProfielButtonPanel(){
		JPanel labelPanel7 = new JPanel();
		geenNieuwProfiel = new JButton("Ga terug!");
		maakProfielButton = new JButton("Maak Profiel");
		//maakProfielButton.setEnabled(false);
		maakProfielButton.addActionListener(this);
		geenNieuwProfiel.addActionListener(this);
		JPanel maakProfielButtonPanel = new JPanel();	
		maakProfielButtonPanel.add(labelPanel7);
		maakProfielButtonPanel.add(maakProfielButton);
		maakProfielButtonPanel.add(geenNieuwProfiel);
		
		return maakProfielButtonPanel;
	}
	
	public JPanel maakProfielPanel(){
		JPanel maakProfielPanel = new JPanel(new BorderLayout());
		maakProfielPanel.add(labelPanel(), BorderLayout.WEST);
		maakProfielPanel.add(textFieldPanel(), BorderLayout.CENTER);
		maakProfielPanel.add(maakProfielButtonPanel(), BorderLayout.SOUTH);
		return maakProfielPanel;
	}
	
	public JPanel maakProfielPanel1(){
		JPanel maakProfielPanel1 = new JPanel();
		maakProfielPanel1.add(maakProfielPanel());
		maakProfielPanel1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Maak chat profiel aan:"));
		
		return maakProfielPanel1;
	}

	public JFrame maakProfielFrame(){
		maakProfielFrame = new JFrame("Maak nieuw Profiel");
		maakProfielFrame.addWindowListener(listener);
		maakProfielFrame.setSize(500,480);
		maakProfielFrame.setVisible(true);
		maakProfielFrame.setResizable(false);
		maakProfielFrame.setLocationRelativeTo(null);
		maakProfielFrame.add(maakProfielPanel1());
		return maakProfielFrame;
	}
	
	public boolean onlyNumbers(String numbers){
		boolean result = false;
		for(int x = 0; x < 200; x++){
			String stringx = Integer.toString(x);
			if(numbers.equals(stringx)){
				result = true;
			}
		}
		return result;
	}
	
	public boolean max20(String nickname){
		boolean result = false;
		if(nickname.length() <= 20){
			result = true;
		}
		return result;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == maakProfielButton){
			if(voornaam.getText().equals("")||achternaam.getText().equals("")||leeftijd.getText().equals("")||nickname.getText().equals("")){
				new ErrorGUI("Niet alle verplichte velden zijn ingevoerd", 250);
			}
			else if(!max20(nickname.getText())){
				new ErrorGUI("Nickname te lang", 200);
			}
			else if(!onlyNumbers(leeftijd.getText())){
				new ErrorGUI("Voer geldige leeftijd in", 230);
			}
			else{
				maakProfielFrame.dispose();
				new ConnectGUI(nickname.getText());
			}
		}
		if(e.getSource() == geenNieuwProfiel){
			maakProfielFrame.dispose();
			new ConnectGUI("Nickname");
		}
	}
}