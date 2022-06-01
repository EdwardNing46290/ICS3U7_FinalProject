/**
 * Main program.
 */
import javax.swing.*;

public class Main {

	public static void main(String[] args) {

		JFrame frame = new JFrame("WPM test");

		// Add panels to frame
		JPanel levelPanel = Panels.createLevelPanel();
		JPanel timePanel = Panels.createTimePanel();
		JPanel typingPanel = Panels.createTypingPanel();
		frame.add(levelPanel); // Don't add last
		frame.add(timePanel); // Don't add last
		frame.add(typingPanel);

		// Frame formatting
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(Global.X, Global.Y);
		frame.setVisible(true);

	}
}