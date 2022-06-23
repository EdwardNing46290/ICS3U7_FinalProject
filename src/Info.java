// just print out info similiar to MonkeyType
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;

public class Info {
	JFrame infoFrame = new JFrame(); 
	
	JLabel infoText = new JLabel();
	JLabel info = new JLabel();
	JLabel signUpInfo = new JLabel();
	JLabel loginInfo = new JLabel();
	JLabel settingsInfo = new JLabel();
	JLabel scoreInfo = new JLabel();
	JLabel contactInfo = new JLabel();
	JLabel wordsInfo = new JLabel();


	public Info () throws MalformedURLException {
		infoFrame.setSize(900,800);
		infoFrame.setBackground(Color.BLACK);
		infoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		infoText.setText("Created by Vincent Liu and Edward Ning");
		infoText.setFont(new Font("Times New Roman", Font.BOLD, 80));
		infoText.setBounds(130,-100,800,1000);
		infoText.setForeground(Color.WHITE);
		
		signUpInfo.setText("To sign up, enter a username and password; no email required");
		signUpInfo.setFont(new Font("Times New Roman", Font.BOLD, 80));
		signUpInfo.setBounds(130,-100,800,1000);
		signUpInfo.setForeground(Color.WHITE);
		
		loginInfo.setText("To log in, enter the username and password you used to sign up previously");
		loginInfo.setFont(new Font("Times New Roman", Font.BOLD, 80));
		loginInfo.setBounds(130,-100,800,1000);
		loginInfo.setForeground(Color.WHITE);
		
		settingsInfo.setText("");
		settingsInfo.setFont(new Font("Times New Roman", Font.BOLD, 80));
		settingsInfo.setBounds(130,-100,800,1000);
		settingsInfo.setForeground(Color.WHITE);
		
		scoreInfo.setText("Stats shown: WPM (words per minute), percentage of correct words, and total words");
		scoreInfo.setFont(new Font("Times New Roman", Font.BOLD, 80));
		scoreInfo.setBounds(130,-100,800,1000);
		scoreInfo.setForeground(Color.WHITE);
		
		wordsInfo.setText("We use the 300 most common english words for easy mode, 500 for medium, and 1000 for hard");
		wordsInfo.setFont(new Font("Times New Roman", Font.BOLD, 80));
		wordsInfo.setBounds(130,-100,800,1000);
		wordsInfo.setForeground(Color.WHITE);
		
		infoFrame.add(infoText);
		infoFrame.add(signUpInfo);
		infoFrame.add(loginInfo);
		infoFrame.add(settingsInfo);
		infoFrame.add(scoreInfo);
		infoFrame.add(wordsInfo);
	}
}
