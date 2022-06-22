import java.util.ArrayList;

/**
 * Generates random text depending on test difficulty.
 */
public class TextGenerator {

	// Set the test difficulty, optionally generate and show text.
	public static void setDifficulty(int testLevel, boolean generateText, boolean showText) {
		Global.testLevel = testLevel;

		// If typing test ended, remove the WPM line graph, allow user to type again, and generate new text.
		if (Global.testEnded) {
			Global.textDisplay.remove(Global.resultsPanel);
			Global.typingArea.setEditable(true);
			Global.testEnded = false;
			Timer.setTime(Global.testDuration);
		}

		// Reset test if the test hasn't finished.
		else if (Global.testActive) {
			Global.testActive = false;
			TypingTest.reset();
			Timer.setTime(Global.testDuration);
		}

		if (generateText) {
			generateTextCache();
		}

		if (showText) {
			Global.generatedTextArea.setText(getTextCacheAsString());
		}
	}

	// Generates random text.
	public static void generateTextCache() {

		// Decide which word bank to generate text from
		ArrayList<String> currentWordBank = new ArrayList<>();
		switch (Global.testLevel) {
			case 1:
				currentWordBank = Global.easyBank;
				break;
			case 2:
				currentWordBank = Global.mediumBank;
				break;
			case 3:
				currentWordBank = Global.hardBank;
				break;
		}

		// Generate 300 words for user to type
		int wordCount = 0;
		int maxIndex = currentWordBank.size();
		int randomIndex;
		Global.generatedText.clear();
		while (wordCount < 300) {
			randomIndex = (int) (Math.random() * maxIndex);
			Global.generatedText.add(currentWordBank.get(randomIndex));
			wordCount++;
		}
	}

	public static String getTextCacheAsString() {
		String output = "";
		for (String word : Global.generatedText) {
			output += word + " ";
		}

		return output;
	}
}
