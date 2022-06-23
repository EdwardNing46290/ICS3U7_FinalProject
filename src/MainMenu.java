import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainMenu implements ActionListener {
	
	JFrame frame = new JFrame();
	// main menu icons
	JButton button = new JButton();
	
	JButton typingTest = new JButton("Typing Test");
	JButton settings = new JButton("Settings"); // add image of a gear
	JButton scores = new JButton("Scores"); // add image of trophy
	JButton info = new JButton("Info"); // add an image of an i
	JButton login = new JButton("Login");
	JButton signUp = new JButton("Sign Up");
	
	
	try {
		Image keyboard = ImageIO.read(getClass().getResource("resources/keyboard.jpg"));
		typingTest.setIcon(new ImageIcon(keyboard));
	} catch (Exception ex) {
		System.out.println(ex);
	}
	
	try {
		Image gear = ImageIO.read(getClass().getResource("resources/gear.jpg"));
		settings.setIcon(new ImageIcon(gear));
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
		info.setIcon(new ImageIcon(gear));
	} catch (Exception ex) {
		System.out.println(ex);
	}
	// Borrowed from Rogach
	
	JLabel title = new JLabel();
	JLabel light_title = new JLabel();
	
	// background/font colours
	Color yellow = new Color(255,255,0);
	Color grey = new Color(1,1,1);
	Color orange = new Color(255,215,0);

	public MainMenu () throws MalformedURLException{
		ActionListener startGame = e -> {
			try {
				frame.dispose();
				TypingTest.main();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		};
		typingTest.addActionListener(startGame);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setTitle("TypingTest Menu");
		frame.setResizable(false);
		
		// images
		ImageIcon background = new ImageIcon("background.jpg");
		frame.setIconImage(background.getImage());
		
		Icon image = new ImageIcon("typing.image");
	
	    JLabel imageLabel = new JLabel(image);
	    frame.getContentPane().setBackground(Color.black);
	  
	    frame.getContentPane().add(imageLabel);

	    frame.pack();
	    
	    imageLabel.setBounds(200,200,400,400);
		frame.setSize(900,800);

		
		login.setBounds(20, 20, 200, 75);
		login.setFocusable(false);
		login.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		login.addActionListener(this);
		login.setBackground(grey);
		
		signUp.setBounds(250, 20, 200, 75);
		signUp.setFocusable(false);
		signUp.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		signUp.addActionListener(this);
		signUp.setBackground(grey);
		
		settings.setBounds(660, 20, 200, 75);
		settings.setFocusable(false);
		settings.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		settings.addActionListener(this);
		settings.setBackground(grey);
		
		info.setBounds(660, 120, 200, 75);
		info.setFocusable(false);
		info.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		info.addActionListener(this);
		info.setBackground(grey);
		
		scores.setBounds(20, 660, 200, 75);
		scores.setFocusable(false);
		scores.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		scores.addActionListener(this);
		scores.setBackground(orange);
		
		typingTest.setBounds(660, 660, 200, 75);
		typingTest.setFocusable(false);
		typingTest.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		typingTest.addActionListener(this);
		typingTest.setBackground(yellow);
		
		
		title.setText("TypingTest Menu");
		title.setFont(new Font("Times New Roman", Font.BOLD, 80));
		title.setBounds(220,-100,800,1000);
		title.setForeground(yellow);
	
		frame.add(typingTest);
		frame.add(login);
		frame.add(signUp);
		frame.add(info);
		frame.add(scores);
		frame.add(title);
		frame.add(light_title);
			
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == typingTest) {
			try {
				MainMenu menuPage = new MainMenu();
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			frame.dispose();
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == info) {
			try {
				MainMenu info = new MainMenu();
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			frame.dispose();
		}
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == scores) {
			try {
				MainMenu scores = new MainMenu();
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			frame.dispose();
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == login) {
			try {
				MainMenu login = new MainMenu();
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			frame.dispose();
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == signUp) {
			try {
				MainMenu signUp = new MainMenu();
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			frame.dispose();
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == settings) {
			try {
				MainMenu settings = new MainMenu();
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			frame.dispose();
		}
	}
	public static void main(String[] args) throws MalformedURLException {
		MainMenu menuPage = new MainMenu();
	}
}
