import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Login implements ActionListener {
	
	static String file = "login.txt";
	public JTextField usernameText;
	public JTextField passwordText;
	public HashMap<String,String> loginInfo;
	
	// Times New Roman
	Font roman = new Font("TimesRoman", Font.PLAIN, 20);

	Login() {
		// Username and Password
		JFrame loginFrame = new JFrame();
		loginFrame.setSize(550,300);
		loginFrame.setBackground(Color.GREEN);

		JTextField usernameText = new JTextField("");
		JLabel usernameLabel = new JLabel();  
		usernameLabel.setText("Username");

		passwordText = new JTextField("");
		JLabel passwordLabel = new JLabel();  
		passwordLabel.setText("Password");

		JTextField textField = new JTextField(15);
		JTextField usernameInput = new JTextField("Enter your Username: ");
		JTextField passwordInput = new JTextField("Enter your Password: ");
        String usernameValue = usernameInput.getText();
        String passwordValue = passwordInput.getText(); 
		JButton login = new JButton("Login");
		loginFrame.setSize(200,200);

		// setBounds
		JLabel usernameDisplay = new JLabel("Username");
		// usernameDisplay.setBounds(__, __, __, __);
		// usernameDisplay.setFont(TimesRoman);
		loginFrame.add(usernameInput);
		JLabel passwordDisplay = new JLabel("Password");
		// passwordDisplay.setBounds(__, __, __, __);
		// passwordDisplay.setFont(TimesRoman);
		loginFrame.add(passwordInput);

		JButton confirm = new JButton("SUBMIT");
		HashMap loginInformation = new HashMap<>();
		// ... check if the username exists and password is correct
		try {
			BufferedReader reader = new BufferedReader(new FileReader(login.txt));
			String username = "";
			String password = "";
			String seperateUserPass [];
			while (reader.hasNextLine) != null) {
				seperateUserPass = currentLine.split(" ");
				username = seperateUserPass[0];
				password = seperateUserPass[1];
				loginInformation.put(username, password);

			}
			// some login code from Javatpoint

		} catch (Exception IOX) {
			JOptionPane.showMessageDialog(loginFrame, "Error, something is wrong with the login.");
		}
		// error code from tutorialspoint.com

	}
}
