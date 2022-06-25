import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainMenu implements ActionListener {

	static JFrame frame = new JFrame();
	// main menu icons
	JButton button = new JButton();

	static JButton typingTest = new JButton("Typing Test");
	static JButton settings = new JButton("Settings"); // add image of a gear
	static JButton scores = new JButton("Scores"); // add image of trophy
	static JButton info = new JButton("Info"); // add an image of an i
	static JButton login = new JButton("Login");
	static JButton signUp = new JButton("Sign Up");
	static JButton exit = new JButton("EXIT");

	public MainMenu () throws MalformedURLException{


		try {
			Image keyboard = ImageIO.read(getClass().getResource("resources/keyboard.jpg"));
			typingTest.setIcon(new ImageIcon(keyboard));
		} catch (Exception ex) {
			System.out.println(ex);
		}

		try {
			Icon gear = new ImageIcon("resources/gear.jpg");
			info.setIcon(gear);
		} catch (Exception ex) {
			System.out.println(ex);
		}

		try {
			Image trophy = ImageIO.read(getClass().getResource("resources/trophy.jpg"));
			scores.setIcon(new ImageIcon(trophy));
		} catch (Exception ex) {
			System.out.println(ex);
		}

		try {
			Image i = ImageIO.read(getClass().getResource("resources/i.jpg"));
			//info.setIcon(new ImageIcon(gear));
		} catch (Exception ex) {
			System.out.println(ex);
		}

		// Borrowed from Rogach

		JLabel title = new JLabel();
		JLabel light_title = new JLabel();
		
		ActionListener startGame = e -> {
			try {
				frame.dispose();
				TypingTest.main();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		};
		typingTest.addActionListener(startGame);

		ActionListener information = e -> {
			try {
				frame.dispose();
				Info.Info();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		};
		info.addActionListener(information);

		ActionListener signIn = e -> {
			try {
				frame.dispose();
				SignUp.SignUp();
			} catch (IOException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			}
		};
		signUp.addActionListener(signIn);
		
		ActionListener logIn = e -> {
			try {
				frame.dispose();
				Login.Login();
			} catch (IOException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			}
		};
		login.addActionListener(logIn);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setTitle("TypingTest Menu");
		frame.setResizable(false);

		// images
		ImageIcon luffy = new ImageIcon("luffy.png");
		frame.setIconImage(luffy.getImage());

		Icon image = new ImageIcon("luffy.png");

		JLabel imageLabel = new JLabel(image);
		
		// frame.getContentPane().setBackground("luffy.png");
		frame.add(new JLabel(new ImageIcon("luffy.png")));
		
		frame.getContentPane().add(imageLabel);

		frame.pack();

		imageLabel.setBounds(200,200,400,400);
		frame.setSize(900,800);


		login.setBounds(20, 20, 200, 75);
		login.setFocusable(false);
		login.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		login.addActionListener(this);
		login.setForeground(Color.WHITE);
		login.setBackground(Color.BLACK);

		signUp.setBounds(250, 20, 200, 75);
		signUp.setFocusable(false);
		signUp.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		signUp.addActionListener(this);
		signUp.setForeground(Color.WHITE);
		signUp.setBackground(Color.BLACK);

		info.setBounds(660, 20, 200, 75);
		info.setFocusable(false);
		info.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		info.addActionListener(this);
		
		/**
		scores.setBounds(660, 120, 200, 75);
		scores.setFocusable(false);
		scores.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		scores.addActionListener(this);
		scores.setBackground(Color.ORANGE);
		*/ // Scores and averages are shown after the Typing Test is completed
		
		exit.setBounds(20, 660, 200, 75);
		exit.setFocusable(false);
		exit.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		exit.addActionListener(this);
		exit.setBackground(Color.RED);
		
		typingTest.setBounds(660, 660, 200, 75);
		typingTest.setFocusable(false);
		typingTest.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		typingTest.addActionListener(this);
		typingTest.setBackground(Color.YELLOW);


		title.setText("TypingTest Menu");
		title.setFont(new Font("Times New Roman", Font.BOLD, 80));
		title.setBounds(120,-100,800,1000);
		title.setForeground(Color.BLUE);

		frame.add(typingTest);
		frame.add(login);
		frame.add(signUp);
		frame.add(info);
		frame.add(scores);
		frame.add(exit);
		frame.add(title);
		frame.add(light_title);
	}
	public static void main(String[] args) throws MalformedURLException {
		MainMenu menuPage = new MainMenu();
	}

	public static void MainMenu() {
		// TODO Auto-generated method stub
		
	}

	public static void addActionListener(ActionListener home) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
