import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Threads can run simultaneously while other code is executed.
 */
public class Threads {

	/** Checks if the user started typing. While the user is typing, this thread will make the timer countdown. */
	static Thread checkTestStartedThread = new Thread() {
		public void run() {
			while (true) {

				// Check if user started typing.
				while (!Global.testActive) {

					// A pause is necessary for the code below to work.
					try {
						TimeUnit.MILLISECONDS.sleep(20);
					} catch (InterruptedException e) {}

					// Condition is true after user starts typing.
					if (Global.currentUserTextAsString.length() != 0) {
						Global.testActive = true;
					}
				}

				// Timer countdown.
				while (Global.testActive) {

					// Update timer text.
					Global.timeDisplay.setText(Integer.toString(Global.secondsRemaining));

					// Test ended.
					if (Global.secondsRemaining == 0) {
						Global.testActive = false;
						Global.testEnded = true;
						try {
							TestResult.endTest();
						} catch (IOException e) {
							e.printStackTrace();
						}

						break;
					}

					// Wait 1 second.
					try {
						TimeUnit.SECONDS.sleep(1);
					}

					// Try/catch is mandatory for .sleep()
					catch (InterruptedException e) {
					}

					// Decrement timer by 1 second.
					Global.secondsRemaining--;

					// Store current WPM for WPM line graph.
					TestResult.storeWPM();
				}
			}
		}
	};

	public static void startCheckTestStartedThread() {
		if (!checkTestStartedThread.isAlive()) {
			checkTestStartedThread.start();
		}
	}
	
	

	/** Regularly delete text so that the user text cursor stays in the middle of the text box. */
	static Thread deleteTextThread = new Thread() {
		public void run() {
			while (true) {

				// A pause to save CPU.
				try {
					TimeUnit.MILLISECONDS.sleep(10);
				} catch (InterruptedException e) {}

				// Do not run if user has not typed anything or there is too much text.
				if (Global.currentUserTextAsString == null || Global.generatedTextArea.getText().length() < Global.currentUserTextAsString.length()) {
					continue;
				}

				// True if user typed 2 rows of words.
				if (Global.currentUserTextAsString.length() >= Global.TEXT_BOX_CHARACTER_LIMIT * 2) {

					// Store the text that is going to be deleted
					String deletedUserText = Global.currentUserTextAsString.substring(0, Global.TEXT_BOX_CHARACTER_LIMIT);
					Global.deletedUserText += deletedUserText;

					// Delete user-typed text.
					String remainingUserText = Global.currentUserTextAsString.substring(Global.TEXT_BOX_CHARACTER_LIMIT);
					Global.typingArea.setText(remainingUserText);
					Global.typingArea.setCaretPosition(0);
					Global.typingArea.setCaretPosition(Global.typingArea.getText().length());

					// Delete generated text.
					String remainingGeneratedText = Global.generatedTextArea.getText().substring(Global.TEXT_BOX_CHARACTER_LIMIT);
					Global.generatedTextArea.setText(remainingGeneratedText);
				}
			}
		}
	};

	public static void startDeleteTextThread() {
		if (!deleteTextThread.isAlive()) {
			deleteTextThread.start();
		}
	}

	
	
	/** Updates what the frame shows at a regular rate. */
	static Thread repaintFrameThread = new Thread() {
		public void run() {

			// Update frame as long as if the program is running.
			while (true) {

				// A pause to save CPU.
				try {
					TimeUnit.MILLISECONDS.sleep(4);
				} catch (InterruptedException e) {}

				Global.frame.repaint();
			}
		}
	};

	public static void startRepaintFrameThread() {
		if (!repaintFrameThread.isAlive()) {
			repaintFrameThread.start();
		}
	}
	

	
	/** Uncategorized code that must run in a thread. */
	static Thread miscThread = new Thread() {
		public void run() {
			while (true) {

				// A pause to save CPU.
				try {
					TimeUnit.MILLISECONDS.sleep(10);
				} catch (InterruptedException e) {}

				// Select text box, so user doesn't have to click it to start typing
				Global.typingArea.requestFocus();

				// Update the variable that stores user-typed text.
				try {
					Global.currentUserTextAsString = Global.typingArea.getText();
				} catch (Exception e) {}
			}
		}
	};

	public static void startMiscThread() {
		if (!miscThread.isAlive()) {
			miscThread.start();
		}
	}
}