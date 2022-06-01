/**
 * A thread that clears the typing area text when necessary.
 * @version Wed June 1, 11AM
 */
import javax.swing.*;

public class TypingArea extends Thread {
	static JTextArea typingArea;

	public static void main(JTextArea input) {
		typingArea = input;
		TypingArea thread = new TypingArea();
		thread.start();
	}

	public void run() {
		int characterLimit = 40;

		// Checks if the amount of text exceeds a limit.
		while (true) {

			// typingArea.getText() is sometimes null
			if (typingArea.getText() == null) {
				continue;
			}

			// Condition should be true if there is a second row of text
			if (typingArea.getText().length() / characterLimit == 1) {
				typingArea.setText("");
			}
		}
	}
}
