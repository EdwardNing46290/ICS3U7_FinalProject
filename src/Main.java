/**
 * @version Wed June 3, 9PM
 *
 * Main program. Creates a frame and adds panels.
 */
import javax.swing.*;

public class Main {
	public static void main(String[] args) {
		JFrame frame = new JFrame("WPM test");
		frame.setSize(Global.X, Global.Y);

		// Add panels to frame
		JPanel levelPanel = Panels.createLevelPanel();
		Global.levelPanel = levelPanel;
		JPanel timePanel = Panels.createTimePanel();
		Global.timePanel = timePanel;
		JPanel centerPanel = Panels.createCenterPanel();
		Global.centerPanel = centerPanel;
		frame.add(levelPanel);
		frame.add(timePanel);
		frame.add(centerPanel); // Must add last, GUI will not render properly otherwise. Reason unknown.

		frame.setVisible(true);
	}
}
