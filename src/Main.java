/**
 * Main program.
 *
 * To-do: test end results, store user results
 */
import javax.swing.*;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		
		// Compile word bank for text generation
		WordBankCompiler.compileBank();
		
	public Menu() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(900,800);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setTitle("Chess"); 
		frame.setResizable(false);
		
		ImageIcon logo = new ImageIcon("logo.jpg");
		frame.setIconImage(logo.getImage());
		
		frame.getContentPane().setBackground(Color.black);
		con = frame.getContentPane();
		
		frame.setTitle("Chess"); 
		
		mainTitle1 = new JLabel();
		mainTitle1.setText("Game");
		mainTitle1.setFont(new Font("Times New Roman", Font.BOLD, 80));
		mainTitle1.setBounds(145,-190,650,650);
		mainTitle1.setForeground(green);
		
		inputPanel = new JPanel();
		inputPanel.setBounds(190, 550, 500, 50);
		inputPanel.setBackground(Color.black);
		inputPanel.setLayout(new GridLayout(1,2));
		
		
		instructionsB = new JButton("INSTRUCTIONS");
		instructionsB.setBounds(50, 320, 300, 75);
		instructionsB.setFocusable(false);
		instructionsB.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		instructionsB.setBackground(green);
		instructionsB.setForeground(Color.white);
		
		exitB = new JButton("EXIT");
		exitB.setBounds(540, 320, 300, 75);
		exitB.setFocusable(false);
		exitB.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		exitB.setBackground(green);
		exitB.setForeground(Color.white);
		
		frame.add(instructionsB);
		frame.add(exitB);
		frame.add(mainTitle1);
		// from the example
		
		// Build GUI
		JFrame frame = new JFrame("WPM test");
		Global.frame = frame;
		frame.setSize(Global.X, Global.Y);

		JPanel levelPanel = Panels.createLevelPanel();
		JPanel timePanel = Panels.createTimePanel();
		JPanel centerPanel = Panels.createCenterPanel();
		Global.levelPanel = levelPanel;
		Global.timePanel = timePanel;
		Global.centerPanel = centerPanel;
		frame.add(levelPanel);
		frame.add(timePanel);
		frame.add(centerPanel); // Must add last, GUI will not render properly otherwise. Reason unknown.
		frame.setLocationRelativeTo(null);

		frame.setVisible(true);

		// Start checking when the user starts the test.
		Threads.startCheckTestStarted();

		// Regularly repaint frame
		Threads.repaintFrame();
	}
}
