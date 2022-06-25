import javax.swing.*;
import java.io.IOException;

/**
 * Typing test GUI
 */
public class TypingTest {
	public static void main() throws IOException {

		// Compile word bank for text generation
		WordBankCompiler.compileBank();
		
		// Build GUI
		JFrame frame = new JFrame("WPM test");
		Global.frame = frame;
		frame.setSize(Global.Screen.WIDTH, Global.Screen.HEIGHT);

		JPanel levelPanel = Panels.createLevelPanel();
		JPanel timePanel = Panels.createTimePanel();
		JPanel centerPanel = Panels.createCenterPanel();
		Global.levelPanel = levelPanel;
		Global.timePanel = timePanel;
		Global.centerPanel = centerPanel;
		frame.add(levelPanel);
		frame.add(timePanel);
		frame.add(centerPanel); // Must add last, GUI will not build properly otherwise.
		frame.setLocationRelativeTo(null); // Move frame to center of screen.

		frame.setVisible(true);

		// Start threads
		Threads.startCheckTestStartedThread();
		Threads.startDeleteTextThread();
		Threads.startRepaintFrameThread();
		Threads.startMiscThread();
	}

	// Reset typing test variables to properly start next test.
	public static void reset() {

		// Delete user-typed text
		Global.typingArea.setText("");

		// Delete text storage
		Global.allUserText.clear();
		Global.deletedUserText = "";

		// Remove WPM line graph data
		Global.wpmUpdates.clear();

		// Reset generated text
		Global.generatedTextArea.setText(TextGenerator.getTextCacheAsString());
	}
}
