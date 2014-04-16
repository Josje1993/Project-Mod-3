package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import java.io.File;

import utils.RoundJPasswordField;
import utils.RoundJTextField;
import security.HASHencrp;
import security.HASHencrp.Algorithm;

public class MaakProfielGUI implements ActionListener {
	
	
	WindowListener listener = new WindowAdapter(){
		public void windowClosing(WindowEvent we){
			maakProfielFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			new InlogGUI();
		}	
	};
	
	private JButton maakProfielButton;
	private JButton geenNieuwProfiel;
	private JFrame maakProfielFrame;
	private JTextField voornaam;
	private JTextField achternaam;
	private JTextField leeftijd;
	private JTextField nickname;
	private JPasswordField password;
	private JPasswordField herhaalPassword;
	private JTextField interesses;
	private JTextField relatiestatus;
	private String[] profileInformation = new String[6];
	
	public MaakProfielGUI(){
		maakProfielFrame();
	}
	
	public JPanel labelPanel(){
		GridLayout grid = new GridLayout();
		grid.setRows(8);
		grid.setColumns(1);
		JPanel labelPanel = new JPanel(grid);
		labelPanel.setBackground(Color.DARK_GRAY);
		
		JPanel labelPanel1 = new JPanel();
		labelPanel1.setBackground(Color.GRAY);
		JPanel labelPanel2 = new JPanel();
		labelPanel2.setBackground(Color.GRAY);
		JPanel labelPanel3 = new JPanel();
		labelPanel3.setBackground(Color.GRAY);
		JPanel labelPanel4 = new JPanel();
		labelPanel4.setBackground(Color.GRAY);
		JPanel labelPanel5 = new JPanel();
		labelPanel5.setBackground(Color.GRAY);
		JPanel labelPanel6 = new JPanel();
		labelPanel6.setBackground(Color.GRAY);
		JPanel labelPanel8 = new JPanel();
		labelPanel8.setBackground(Color.GRAY);
		JPanel labelPanel9 = new JPanel();
		labelPanel9.setBackground(Color.GRAY);
		
		JLabel nicknameLabel = new JLabel("<html> <font color='black'>Nickname*: </font></html>");
		Font labelsFont = new Font("Bauhaus 93",Font.PLAIN,14);
		nicknameLabel.setFont(labelsFont);
		JLabel voornaamLabel = new JLabel("<html> <font color='black'>Voornaam*: </font></html>");
		voornaamLabel.setFont(labelsFont);
		JLabel achternaamLabel = new JLabel("<html> <font color='black'>Achternaam*: </font></html>");
		achternaamLabel.setFont(labelsFont);
		JLabel leeftijdLabel = new JLabel("<html> <font color='black'>Leeftijd*: </font></html>");
		leeftijdLabel.setFont(labelsFont);
		JLabel interessesLabel = new JLabel("<html> <font color='black'>Interesses: </font></html>");
		interessesLabel.setFont(labelsFont);
		JLabel relatiestatusLabel = new JLabel("<html> <font color='black'>Relatie status: </font></html>");
		relatiestatusLabel.setFont(labelsFont);
		JLabel passwordLabel = new JLabel("<html> <font color='black'>Wachtwoord*: </font></html>");
		passwordLabel.setFont(labelsFont);
		JLabel herhaalPasswordLabel = new JLabel("<html> <font color='black'>Herhaal wachtwoord*: </font></html>");
		herhaalPasswordLabel.setFont(labelsFont);
		
		labelPanel1.add(voornaamLabel);
		labelPanel2.add(achternaamLabel);
		labelPanel3.add(leeftijdLabel);
		labelPanel4.add(interessesLabel);
		labelPanel5.add(relatiestatusLabel);
		labelPanel6.add(nicknameLabel);
		labelPanel8.add(passwordLabel);
		labelPanel9.add(herhaalPasswordLabel);
		
		labelPanel.add(labelPanel6);
		labelPanel.add(labelPanel8);
		labelPanel.add(labelPanel9);
		labelPanel.add(labelPanel1);
		labelPanel.add(labelPanel2);
		labelPanel.add(labelPanel3);
		labelPanel.add(labelPanel4);
		labelPanel.add(labelPanel5);
		
		
		return labelPanel;
	}
	
	public JPanel textFieldPanel(){
		GridLayout grid = new GridLayout();
		grid.setRows(8);
		grid.setColumns(1);
		JPanel textFieldPanel = new JPanel(grid);
		
		JPanel textFieldPanel1 = new JPanel();
		JPanel textFieldPanel2 = new JPanel();
		JPanel textFieldPanel3 = new JPanel();
		JPanel textFieldPanel4 = new JPanel();
		JPanel textFieldPanel5 = new JPanel();
		JPanel textFieldPanel6 = new JPanel();
		JPanel textFieldPanel7 = new JPanel();
		JPanel textFieldPanel8 = new JPanel();
		
		nickname = new RoundJTextField("", 15);
		nickname.setBackground(Color.LIGHT_GRAY);
		nickname.setForeground(Color.BLACK);
		password = new RoundJPasswordField("", 15);
		password.setBackground(Color.LIGHT_GRAY);
		password.setForeground(Color.BLACK);
		herhaalPassword = new RoundJPasswordField("", 15);
		herhaalPassword.setBackground(Color.LIGHT_GRAY);
		herhaalPassword.setForeground(Color.BLACK);
		voornaam = new RoundJTextField("", 15);
		voornaam.setBackground(Color.LIGHT_GRAY);
		voornaam.setForeground(Color.BLACK);
		achternaam = new RoundJTextField("", 15);
		achternaam.setBackground(Color.LIGHT_GRAY);
		achternaam.setForeground(Color.BLACK);
		leeftijd = new RoundJTextField("", 15);
		leeftijd.setBackground(Color.LIGHT_GRAY);
		leeftijd.setForeground(Color.BLACK);
		interesses = new RoundJTextField("", 15);
		interesses.setBackground(Color.LIGHT_GRAY);
		interesses.setForeground(Color.BLACK);
		relatiestatus = new RoundJTextField("", 15);
		relatiestatus.setBackground(Color.LIGHT_GRAY);
		relatiestatus.setForeground(Color.BLACK);
		nickname.setEditable(true);
		voornaam.setEditable(true);
		achternaam.setEditable(true);
		leeftijd.setEditable(true);
		interesses.setEditable(true);
		relatiestatus.setEditable(true);
		
		textFieldPanel1.add(voornaam);
		textFieldPanel1.setBackground(Color.GRAY);
		textFieldPanel2.add(achternaam);
		textFieldPanel2.setBackground(Color.GRAY);
		textFieldPanel3.add(leeftijd);
		textFieldPanel3.setBackground(Color.GRAY);
		textFieldPanel4.add(interesses);
		textFieldPanel4.setBackground(Color.GRAY);
		textFieldPanel5.add(relatiestatus);
		textFieldPanel5.setBackground(Color.GRAY);
		textFieldPanel6.add(nickname);
		textFieldPanel6.setBackground(Color.GRAY);
		textFieldPanel7.add(password);
		textFieldPanel7.setBackground(Color.GRAY);
		textFieldPanel8.add(herhaalPassword);
		textFieldPanel8.setBackground(Color.GRAY);
		
		textFieldPanel.add(textFieldPanel6);
		textFieldPanel.add(textFieldPanel7);
		textFieldPanel.add(textFieldPanel8);
		textFieldPanel.add(textFieldPanel1);
		textFieldPanel.add(textFieldPanel2);
		textFieldPanel.add(textFieldPanel3);
		textFieldPanel.add(textFieldPanel4);
		textFieldPanel.add(textFieldPanel5);
		
		return textFieldPanel;
	}
	
	public JPanel maakProfielButtonPanel(){
		JPanel labelPanel7 = new JPanel();
		labelPanel7.setBackground(Color.GRAY);
		geenNieuwProfiel = new JButton("<html> <font color='black'>Ga terug!</font></html>");
		Font buttonFont = new Font("Bauhaus 93",Font.PLAIN,18);
		geenNieuwProfiel.setFont(buttonFont);
		geenNieuwProfiel.setOpaque(false);
		geenNieuwProfiel.setContentAreaFilled(false);
		geenNieuwProfiel.setBorderPainted(false);
		maakProfielButton = new JButton("<html> <font color='black'>Maak Profiel!</font></html>");
		maakProfielButton.setFont(buttonFont);
		maakProfielButton.setOpaque(false);
		maakProfielButton.setContentAreaFilled(false);
		maakProfielButton.setBorderPainted(false);
		maakProfielButton.addActionListener(this);
		geenNieuwProfiel.addActionListener(this);
		JPanel maakProfielButtonPanel = new JPanel();
		maakProfielButtonPanel.setBackground(Color.GRAY);
		maakProfielButtonPanel.add(labelPanel7);
		maakProfielButtonPanel.add(maakProfielButton);
		maakProfielButtonPanel.add(geenNieuwProfiel);
		
		return maakProfielButtonPanel;
	}
	
	public JPanel maakProfielPanel(){
		JPanel maakProfielPanel = new JPanel(new BorderLayout());
		maakProfielPanel.setBackground(Color.GRAY);
		maakProfielPanel.add(labelPanel(), BorderLayout.WEST);
		maakProfielPanel.add(textFieldPanel(), BorderLayout.CENTER);
		maakProfielPanel.add(maakProfielButtonPanel(), BorderLayout.SOUTH);
		return maakProfielPanel;
	}
	
	public JPanel maakProfielPanel1(){
		JPanel maakProfielPanel1 = new JPanel();
		maakProfielPanel1.setBackground(Color.GRAY);
		maakProfielPanel1.add(maakProfielPanel());
		maakProfielPanel1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "<html> <font color='black'>Maak chatprofiel aan: </font></html>"));
		
		return maakProfielPanel1;
	}

	public JFrame maakProfielFrame(){
		maakProfielFrame = new JFrame("Maak nieuw Profiel");
		maakProfielFrame.addWindowListener(listener);
		maakProfielFrame.setSize(360,360);
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

	private void writeProfileToFile(){
		profileInformation[0] = nickname.getText();
		profileInformation[1] = voornaam.getText();
		profileInformation[2] = achternaam.getText();
		profileInformation[3] = leeftijd.getText();
		profileInformation[4] = interesses.getText();
		profileInformation[5] = relatiestatus.getText();
		savePassword();
		try
		{
			  PrintWriter pr = new PrintWriter(nickname.getText() + ".txt");
				  for (int i=0; i<profileInformation.length ; i++)
			  {
					  pr.println(profileInformation[i]);
			  }
			  pr.close();  
		}
		catch (Exception e)
		{
		    e.printStackTrace();
		    System.out.println("No such file exists.");
		}
	}
	
	private void savePassword(){
		String passwordString = new String(password.getPassword());
		String nicknamepasswordString = new String(passwordString + nickname.getText());
		try{
			byte[] nicknamepasswordByte = nicknamepasswordString.getBytes("UTF-8");
			byte[] nicknamepasswordHash = HASHencrp.getHash(Algorithm.SHA_256, nicknamepasswordByte);
			String testString = new String(nicknamepasswordHash);
			File file = new File("definitelyNotPasswords.txt");
			if(!file.exists()){
				file.createNewFile();
				FileWriter fos = new FileWriter(file.getName(), true);
				BufferedWriter bos = new BufferedWriter(fos);
				bos.write(testString);
				bos.newLine();
				bos.close();
			}else{
				FileWriter fos = new FileWriter(file.getName(), true);
				BufferedWriter bos = new BufferedWriter(fos);
				bos.write(testString);
				bos.newLine();
				bos.close();
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == maakProfielButton){
			if(voornaam.getText().equals("")||achternaam.getText().equals("")||leeftijd.getText().equals("")||nickname.getText().equals("")||password.getPassword().equals("") ||herhaalPassword.getPassword().equals("")){
				new ErrorGUI("Niet alle verplichte velden zijn ingevoerd", 250);
			}
			else if(!max20(nickname.getText())){
				new ErrorGUI("Nickname te lang", 200);
			}
			else if(!onlyNumbers(leeftijd.getText())){
				new ErrorGUI("Voer geldige leeftijd in", 230);
			}
			else if(!Arrays.equals(password.getPassword(),herhaalPassword.getPassword())){
				new ErrorGUI("Wachtwoorden zijn ongelijk", 240);
			}
			else{
				File file = new File(nickname.getText() + ".txt");
				if(file.exists() && !file.isDirectory()){
					new ErrorGUI("Nickname al in gebruik", 220);
				}else{
					maakProfielFrame.dispose();
					writeProfileToFile();
					new InlogGUI();
				}
			}
		}
		if(e.getSource() == geenNieuwProfiel){
			maakProfielFrame.dispose();
			new InlogGUI();
		}
	}
	
	public static void main(String[] args){
		new MaakProfielGUI();
	}
}