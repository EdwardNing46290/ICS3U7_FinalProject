import java.util.HashMap;

import javax.swing.*;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.io.*;


public class SignUp implements ActionListener{

	static String file = "login.txt";
	public JTextField usernameText;
	public JTextField passwordText;
	public HashMap <String, String> signUpInfo;

	void Signup() {
		JFrame signupFrame = new JFrame();
		Component signUpFrame;
		signUpFrame.setSize(900, 800);
		HashMap signUpInfo = new HashMap<> ();
		usernameText = new JTextField("");
		passwordText = new JTextField("");
		JButton signUp = new JButton("Sign up");

		//store all the info from the text file into the hashmap

		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String username = "";
			String password = "";
			String seperateUserPass[];
			while (reader.hasNextLine) {
				//put information into hashmap
				String currentLine;
				seperateUserPass = currentLine.split(" ");
				username = seperateUserPass[0];
				password = seperateUserPass[1];
				signUpInfo.put(username, password);

			}


		} catch (Exception IOX) {
			JOptionPane.showMessageDialog(signupFrame, "Error, sign in could not register");
		}

		JLabel usernameDisplay = new JLabel("Username");
		// usernameDisplay.setBounds(__, __, __, __);
		// usernameDisplay.setFont(TimesRoman);
		Component loginFrame;
		PopupMenu usernameInput;
		loginFrame.add(usernameInput);

		JLabel passwordDisplay = new JLabel("Password");
		// passwordDisplay.setBounds(__, __, __, __);
		// passwordDisplay.setFont(TimesRoman);
		PopupMenu passwordInput;
		loginFrame.add(passwordInput);

		usernameText.setBounds(260,60,180,45);
		signupFrame.add(usernameText);

		passwordText.setBounds(260,130,180,45);
		signupFrame.add(passwordText);

		signUp.setBounds(400,400,400,400);
		signUp.setBackground(Color.white);
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

						text.close();
						signupFrame.dispose();

					} catch (IOException iox) {
						JOptionPane.showMessageDialog(signupFrame, "Error");

					}
				}
			}

		}


				);

		signupFrame.add(signUp);
		signupFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
*/
