/**
 * Typing test GUI
 */
import javax.swing.*;
import java.io.IOException;

public class TypingTest {
	public static void main() throws IOException {

		// Compile word bank for text generation
		WordBankCompiler.compileBank();
		
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
		frame.add(centerPanel); // Must add last, GUI will not build properly otherwise. Reason unknown.
		frame.setLocationRelativeTo(null);

		frame.setVisible(true);

		// Start checking when the user starts the test.
		Threads.startCheckTestStartedThread();

		// Regularly repaint frame
		Threads.startRepaintFrameThread();
	}
}
