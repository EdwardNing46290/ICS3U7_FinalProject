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

public class Login {

	static String file = "login.txt";
	public JTextField usernameText;
	public JTextField passwordText;
	public HashMap<String,String> loginInfo;

	// Times New Roman
	Font roman = new Font("TimesRoman", Font.PLAIN, 20);

	Login() {
		// Username and Password
		JFrame loginFrame = new JFrame();
		loginFrame.setSize(900,800);
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
		usernameDisplay.setBounds(100, 100, 200, 50);
		usernameDisplay.setFont(roman);
		loginFrame.add(usernameInput);
		JLabel passwordDisplay = new JLabel("Password");
		passwordDisplay.setBounds(100, 120, 200, 50);
		passwordDisplay.setFont(roman);
		loginFrame.add(passwordInput);

		JButton confirm = new JButton("Submit Password");
		HashMap loginInformation = new HashMap<>();
		// ... check if the username exists and password is correct
		try {
			BufferedReader reader = new BufferedReader(new FileReader("login.txt"));
			String username = "";
			String password = "";
			String seperateUserPass [];
			String currentLine;
			while ((currentLine = reader.readLine()) != null) {
				// put a space between the username and password
				seperateUserPass = currentLine.split(" ");
				// username is the first word, then password is the second
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
