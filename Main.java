/**
 * Main program.
 * @version Wed June 2, 8PM
 */
import javax.swing.*;

public class Main {
	public static void main(String[] args) {
		JFrame frame = new JFrame("WPM test");

		// Add panels to frame
		JPanel typingPanel = Panels.createTypingPanel();
		Global.typingPanel = typingPanel;
		JPanel levelPanel = Panels.createLevelPanel();
		JPanel timePanel = Panels.createTimePanel();
		frame.add(levelPanel);
		frame.add(timePanel);
		frame.add(typingPanel); // Must add last, GUI will not render properly otherwise. Reason unknown.

		// Frame formatting
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(Global.X, Global.Y);
		frame.setVisible(true);

	}
}
