import java.io.*;
import javax.swing.*;
import java.awt.Color;
import java.util.HashMap;
import java.awt.Component;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUp {

	static String file = "login.txt";
	static JTextField usernameText;
	static JTextField passwordText;
	static HashMap <String, String> signUpInfo;
	
	// Times New Roman
	Font roman = new Font("TimesRoman", Font.PLAIN, 20);
	
	public static void SignUp() {
		JFrame signUpFrame = new JFrame();
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
		usernameDisplay.setBounds(100, 100, 200, 50);
		usernameDisplay.setFont(roman);
		Component loginFrame;
		PopupMenu usernameInput;
		loginFrame.add(usernameInput);

		JLabel passwordDisplay = new JLabel("Password");
		passwordDisplay.setBounds(100, 120, 200, 50);
		passwordDisplay.setFont(roman);
		PopupMenu passwordInput;
		loginFrame.add(passwordInput);

		usernameText.setBounds(300, 100, 180, 45);
		signUpFrame.add(usernameText);

		passwordText.setBounds(300, 120, 200, 50);
		signUpFrame.add(passwordText);

		signUp.setBounds(400, 400, 400, 400);
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
							 signUpFrame.dispose();

						 } catch (IOException iox) {
							 JOptionPane.showMessageDialog(signUpFrame, "Error");

						 }
					 }
				 }

			 }
		);

		signUpFrame.add(signUp);
		signUpFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
