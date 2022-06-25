import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
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
	public static JTextField usernameText;
	public static JTextField passwordText;
	public static HashMap<String,String> loginInfo;

	// Times New Roman
	Font roman = new Font("TimesRoman", Font.PLAIN, 20);

	public static void Login() throws IOException {
		// Username and Password
		JFrame loginFrame = new JFrame();
		loginFrame.setSize(900, 800);
		loginFrame.setBackground(Color.GREEN);

		loginFrame.setLayout(null);
		loginFrame.setVisible(true);
		loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel usernameDisplay = new JLabel("Username");
		usernameDisplay.setBounds(100, 300, 200, 50);
		usernameDisplay.setFont(new Font("Times New Roman", Font.BOLD, 30));
		// Component loginFrame;
		// PopupMenu usernameInput;
		loginFrame.add(usernameDisplay);

		JLabel passwordDisplay = new JLabel("Password");
		passwordDisplay.setBounds(100, 400, 200, 50);
		passwordDisplay.setFont(new Font("Times New Roman", Font.BOLD, 30));
		// PopupMenu passwordInput;
		loginFrame.add(passwordDisplay);

		JButton login = new JButton("Login");

		login.setBounds(300, 500, 200, 75);
		login.setFocusable(false);
		login.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		login.setForeground(Color.WHITE);
		login.setBackground(Color.BLACK);

		JTextField usernameInput = new JTextField("");
		JLabel usernameLabel = new JLabel();
		usernameLabel.setText("Username");

		JTextField passwordInput = new JTextField("");
		JLabel passwordLabel = new JLabel();
		passwordLabel.setText("Password");

		usernameInput.setBounds(250, 300, 400, 50);
		loginFrame.add(usernameInput);

		passwordInput.setBounds(250, 400, 400, 50);
		loginFrame.add(passwordInput);

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
			login.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (e.getSource() == login) {
						String username = usernameText.getText();
						String password = passwordText.getText();

						//check if the username exists 
						if(loginInfo.containsKey(username)) {
							try {
								if((loginInfo.get(username).equals(password))) {
									JOptionPane.showMessageDialog(loginFrame, "Login successful!");
									loginFrame.dispose();
								}
								else {
									JOptionPane.showMessageDialog(loginFrame, "Login unsuccessful.");
								}
							} catch (HeadlessException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					}
				}
			});
			// some login code from Javatpoint

			JButton home = new JButton("Main Menu");

			home.setBounds(660, 20, 200, 75);
			home.setFocusable(false);
			home.setFont(new Font("Times New Roman", Font.PLAIN, 30));

			home.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						loginFrame.dispose();
						new MainMenu();
					} catch (MalformedURLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});

			loginFrame.add(home);
			loginFrame.add(login);
			loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		} catch (Exception IOX) {
			JOptionPane.showMessageDialog(loginFrame, "Error, something is wrong with the login.");
		}
		// error code from tutorialspoint.com

	}
}
