import java.io.*;
import java.net.MalformedURLException;

import javax.swing.*;
import java.awt.Color;
import java.util.HashMap;
import java.awt.Component;
import java.awt.Font;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUp {

	static String file = "login.txt";
	static JTextField usernameText;
	static JTextField passwordText;
	static HashMap <String, String> signUpInfo;


	// Times New Roman

	public static void SignUp() throws IOException {
		JFrame signUpFrame = new JFrame();
		signUpFrame.setSize(900, 800);

		signUpFrame.setLayout(null);
		signUpFrame.setVisible(true);
		signUpFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		signUpFrame.setTitle("Sign Up Menu");
		signUpFrame.setResizable(false);

		HashMap signUpInfo = new HashMap<> ();
		usernameText = new JTextField("Type Here");
		passwordText = new JTextField("Type Here");
		JButton signUp = new JButton("Sign Up");

		//store all the info from the text file into the hashmap

		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String username = "";
			String password = "";
			String[] seperateUserPass;
			String currentLine;
			while ((currentLine = reader.readLine()) != null) {

				//put information into hashmap
				seperateUserPass = currentLine.split(" ");
				username = seperateUserPass[0];
				password = seperateUserPass[1];
				signUpInfo.put(username, password);

			}


		} catch (Exception IOX) {
			JOptionPane.showMessageDialog(signUpFrame, "Error, sign in could not register");
		}

		JLabel usernameDisplay = new JLabel("Username");
		usernameDisplay.setBounds(100, 300, 200, 50);
		usernameDisplay.setFont(new Font("Times New Roman", Font.BOLD, 30));
		// Component loginFrame;
		// PopupMenu usernameInput;
		signUpFrame.add(usernameDisplay);

		JLabel passwordDisplay = new JLabel("Password");
		passwordDisplay.setBounds(100, 400, 200, 50);
		passwordDisplay.setFont(new Font("Times New Roman", Font.BOLD, 30));
		// PopupMenu passwordInput;
		signUpFrame.add(passwordDisplay);

		signUp.setBounds(300, 500, 200, 75);
		signUp.setFocusable(false);
		signUp.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		signUp.setForeground(Color.WHITE);
		signUp.setBackground(Color.BLACK);

		usernameText.setBounds(250, 300, 400, 50);
		signUpFrame.add(usernameText);

		passwordText.setBounds(250, 400, 400, 50);
		signUpFrame.add(passwordText);

		signUp.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e)
			{
				if (e.getSource() == signUp) {
					String username = usernameText.getText();
					String password = passwordText.getText();


					signUpInfo.put(username, password);

					//put the new account information into the text file
					try {
						BufferedWriter text = new BufferedWriter(new FileWriter(file,true));
						text.write(username + " " + password);

						signUp.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								try {
									signUpFrame.dispose();
									new MainMenu();
								} catch (MalformedURLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}
						});
						text.close();

					} catch (IOException iox) {
						JOptionPane.showMessageDialog(signUpFrame, "Error");

					}
				}
			}

		}
				);

		signUpFrame.add(signUp);
		signUpFrame.add(usernameText);
		signUpFrame.add(passwordText);
		signUpFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}


	public static void addActionListener(ActionListener signIn) {
		// TODO Auto-generated method stub

	}
}
