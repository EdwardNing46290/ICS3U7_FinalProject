// just print out info similiar to MonkeyType
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;

public class Info implements ActionListener {
  	JLabel infoText = new JLabel;
 	public Info () throws MalformedURLException{
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    		JLabel infoText = new JLabel();
		JFrame frame = new JFrame();
		JLabel signUpInfo = new JLabel("To sign up, enter a username and password; no email required");
		JLabel loginInfo = new JLabel("To log in, enter the username and password you used to sign up previously");
		JLabel settingsInfo = new JLabel("I have no idea rn")
		JLabel scoreInfo = new JLabel("Stats shown: WPM (words per minute), percentage of correct words, and total words");
		JLabel contactInfo = new JLabel("If you have any problems with our test, you can contact us here ___ play rickroll");
		JLabel wordsInfo = new JLabel("We use the 100 most common english words for easy mode, 200 for medium, and 500 more difficult words for hard")
