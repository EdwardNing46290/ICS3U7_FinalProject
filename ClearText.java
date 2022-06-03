/**
 * Clears the typing area text when necessary.
 * @version Wed June 2, 8PM
 */

public class ClearText {
	static Thread clearTextThread = new Thread() {
		public void run() {
			int characterLimit = 40;
			while (true) {
				try {
					// Condition should be true if there is a second row of text
					if (Global.typingArea.getText().length() == characterLimit) {
						Global.typingArea.setText(" ");
					}
				} catch (Exception e) {
					// Global.typingArea.getText() is sometimes null and causes an error.
				}
			}
		}
	};

	public static void main() {
		clearTextThread.start();
	}
}
