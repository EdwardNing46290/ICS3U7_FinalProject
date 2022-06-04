/**
 * @version Wed June 3, 9PM
 * NOT IN USE
 *
 * Deletes a row of user-typed text after the user types a full line. This is done to keep the user typing
 * at one row for the entire duration of the typing test.
 * Runs on a separate thread, so this will run in the background while other code is executed.
 */

public class ClearText {
	static Thread clearTextThread = new Thread() {
		public void run() {
			// Constantly check if the user typed more than one line of text.
			while (true) {
				try {
					// Clear text when text typed reaches the number of characters that one row can contain.
					if (Global.typingArea.getText().length() >= Global.textDisplayCharacterLimit) {
						Global.typingArea.setText(" ");
					}
				} catch (Exception e) {
					// .getText() is sometimes null and can cause an error.
				}
			}
		}
	};

	public static void main() {
		clearTextThread.start();
	}
}
