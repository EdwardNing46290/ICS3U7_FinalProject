/**
 * Threads can run simultaneously while other code is executed.
 */
import java.util.concurrent.TimeUnit;

public class Threads {

	// Updates what the frame shows at a regular rate, which is set by framesPerSecond variable.
	static Thread repaintFrameThread = new Thread() {
		public void run() {

			int framesPerSecond = 160; // Lower than 150 will make the GUI appear glitchy

			while (true) {
				Global.frame.repaint();
				try {
					TimeUnit.MILLISECONDS.sleep(1000/framesPerSecond);
				} catch (InterruptedException e) {}

				// Select text box, so user doesn't have to click it to start typing
				Global.typingArea.requestFocus();
			}

		}
	};

	public static void startRepaintFrameThread() {
		repaintFrameThread.start();
	}

	// Checks if the user started typing. While the user is typing, this thread will make the timer countdown.
	static Thread checkTestStartedThread = new Thread() {

		public void run() {

			while (true) {

				// Check if user started typing
				while (!Global.testActive) {

					try {
						Global.userTextAsString = Global.typingArea.getText();

						// True after user starts typing
						if (Global.userTextAsString.length() != 0) {
							Global.testActive = true;
						}
					}

					// .getText() is sometimes null and can cause an error. Not preventable.
					catch (Exception e) {}
				}

				// Timer countdown.
				while (Global.testActive) {

					// Update timer text
					Global.timeDisplay.setText(Integer.toString(Global.secondsRemaining));

					// Test ended.
					if (Global.secondsRemaining == 0) {

						// Stop user from typing.
						Global.typingArea.setEditable(false);
						Global.typingArea.setText("");

						// Display results
						Global.testActive = false;
						TestResult.endTest();

						// Reuse timer number to display score
						Global.timeDisplay.setText("WPM: " + (int) (60.0 / (Global.testDuration) * Global.correctWords));

						break;
					}

					// Decrement timer by 1 second
					Global.secondsRemaining--;

					// Wait 1 second
					try {
						TimeUnit.SECONDS.sleep(1);
					}

					// Try catch is mandatory for .sleep()
					catch (InterruptedException e) {}

					// Store current WPM for results line graph
					TestResult.storeWPM();
				}
			}
		}
	};

	public static void startCheckTestStartedThread() {
		checkTestStartedThread.start();
	}

	static Thread startCheckGenerateText = new Thread() {
		public void run() {
			while (true) {

				// .getText() can return null for an unknown reason and cause errors
				try {
					if (Global.typingArea.getText().length() >= Global.textDisplayCharacterLimit) {
						Global.typingArea.setText("");
					}
				} catch (Exception e) {}
			}
		}
	};
}
