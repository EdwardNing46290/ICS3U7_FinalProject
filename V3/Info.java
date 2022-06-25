// just print out info similiar to MonkeyType
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Info {
	public static void Info() throws MalformedURLException {
		JFrame infoFrame = new JFrame(); 
		
		infoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		infoFrame.setLayout(null);
		infoFrame.setVisible(true);
		infoFrame.setTitle("Info Menu");
		infoFrame.setResizable(false);
		
		JLabel infoText = new JLabel();
		JLabel signUpInfo = new JLabel();
		JLabel loginInfo = new JLabel();
		JLabel loginInfo2 = new JLabel();
		JLabel scoreInfo = new JLabel();
		JLabel scoreInfo2 = new JLabel();
		JLabel wordsInfo = new JLabel();
		JLabel wordsInfo2 = new JLabel();
		JButton exit = new JButton("EXIT");
		JButton home = new JButton("Main Menu");

		infoFrame.setSize(900,800);
		infoFrame.setBackground(Color.BLACK);
		infoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		infoText.setText("Created by Vincent Liu and Edward Ning");
		infoText.setFont(new Font("Times New Roman", Font.BOLD, 30));
		infoText.setBounds(20, -450, 800, 1000);
		infoText.setForeground(Color.BLACK);

		signUpInfo.setText("To sign up, enter a username and password; no email required");
		signUpInfo.setFont(new Font("Times New Roman", Font.BOLD, 30));
		signUpInfo.setBounds(20, -350, 800, 1000);
		signUpInfo.setForeground(Color.BLACK);

		loginInfo.setText("To log in, enter the username and password you used to sign");
		loginInfo.setFont(new Font("Times New Roman", Font.BOLD, 30));
		loginInfo.setBounds(20, -250, 800, 1000);
		loginInfo.setForeground(Color.BLACK);
		
		loginInfo2.setText("up previously");
		loginInfo2.setFont(new Font("Times New Roman", Font.BOLD, 30));
		loginInfo2.setBounds(20, -200, 800, 1000);
		loginInfo2.setForeground(Color.BLACK);
		
		scoreInfo.setText("Stats shown: WPM (words per minute), percentage of correct");
		scoreInfo.setFont(new Font("Times New Roman", Font.BOLD, 30));
		scoreInfo.setBounds(20, -100, 800, 1000);
		scoreInfo.setForeground(Color.BLACK);

		scoreInfo2.setText("words, and total words");
		scoreInfo2.setFont(new Font("Times New Roman", Font.BOLD, 30));
		scoreInfo2.setBounds(20, -50, 800, 1000);
		scoreInfo2.setForeground(Color.BLACK);
		
		wordsInfo.setText("We used 300 english words for easy mode, 500 for medium");
		wordsInfo.setFont(new Font("Times New Roman", Font.BOLD, 30));
		wordsInfo.setBounds(20, 50, 800, 1000);
		wordsInfo.setForeground(Color.BLACK);

		wordsInfo2.setText("for medium, and 1000 for hard");
		wordsInfo2.setFont(new Font("Times New Roman", Font.BOLD, 30));
		wordsInfo2.setBounds(20, 100, 800, 1000);
		wordsInfo2.setForeground(Color.BLACK);
		
		home.setBounds(660, 20, 200, 75);
		home.setFocusable(false);
		home.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		
		exit.setBounds(660, 650, 200, 75);
		exit.setFocusable(false);
		exit.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		exit.setBackground(Color.RED);
		
		infoFrame.add(infoText);
		infoFrame.add(signUpInfo);
		infoFrame.add(loginInfo);
		infoFrame.add(loginInfo2);
		infoFrame.add(scoreInfo);
		infoFrame.add(scoreInfo2);
		infoFrame.add(wordsInfo);
		infoFrame.add(wordsInfo2);
		infoFrame.add(home);
		infoFrame.add(exit);
		
		home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					infoFrame.dispose();
					new MainMenu();
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				infoFrame.dispose();
			}
		});
		
		infoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
