/**
 * Threads can run simultaneously while other code is executed.
 */
import java.util.concurrent.TimeUnit;

public class Threads {

	// Updates what the frame shows at a regular rate, which is set by framesPerSecond variable.
	static Thread repaintFrameThread = new Thread() {
		public void run() {

			int framesPerSecond = 30;

			while (true) {
				Global.frame.repaint();
				try {
					TimeUnit.MILLISECONDS.sleep(1000/framesPerSecond);
				} catch (InterruptedException e) {}
			}
		}
	};

	public static void repaintFrame() {
		repaintFrameThread.start();
	}

	// This thread checks if the user started typing.
	// While the user is typing, this thread will make the timer countdown.
	static Thread checkTestStartedThread = new Thread() {

		public void run() {

			// The text the user has typed so far
			String userText;

			while (true) {

				// Check if user started typing
				while (!Global.testActive) {

					try {
						userText = Global.typingArea.getText();

						// True after user starts typing
						if (userText.length() != 0) {
							Global.testActive = true;
							Global.timeDisplay.setText(Integer.toString(Global.testDuration));
							Global.secondsRemaining = Global.testDuration;
						}
					}

					// .getText() is sometimes null and can cause an error. Not preventable.
					catch (Exception e) {}
				}

				// Timer countdown.
				while (Global.testActive) {
					Global.timeDisplay.setText(Integer.toString(Global.secondsRemaining));

					// Test ended.
					if (Global.secondsRemaining == 0) {

						// Stop user from typing.
						Global.typingArea.setVisible(false);
						Global.typingArea.setText("");
						Global.typingArea.setVisible(true);

						Global.testActive = false;
					}

					// Decrement timer by 1 second
					Global.secondsRemaining--;

					// Wait 1 second
					try {
						TimeUnit.SECONDS.sleep(1);
					}

					// Try catch is mandatory for .sleep()
					catch (InterruptedException e) {}
				}
			}
		}
	};

	public static void startCheckTestStarted() {
		checkTestStartedThread.start();
	}
}
