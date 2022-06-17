/**
 * Generates random text depending on test difficulty.
 */

public class TextGenerator {

	// Sets the test level, generates random text, and displays random text on a JTextArea
	public static void generateTextCache(int testLevel) {
		try {
			Global.textDisplay.remove(Global.resultsPanel);
			Global.typingArea.setEditable(true);
		} catch (Exception e) {}

		Global.testLevel = testLevel;

		// Decide which word bank to generate text from
		switch (Global.testLevel) {
			case 1:
				Global.currentBank = Global.easyBank;
				break;
			case 2:
				Global.currentBank = Global.mediumBank;
				break;
			case 3:
				Global.currentBank = Global.hardBank;
				break;
		}

		// Generate 300 words for user to type
		int wordCount = 0;
		int maxIndex = Global.currentBank.size();
		int randomIndex;
		Global.textCache.clear();

		while (wordCount < 300) {
			randomIndex = (int) (Math.random() * maxIndex);
			Global.textCache.add(Global.currentBank.get(randomIndex));
			wordCount++;
		}

		// Reset timer and display newly generated text
		if (Global.testActive) {
			Timer.setTime(Global.testDuration);
		}
		Global.generatedText.setText(getTextCacheAsString());
		Global.userText.clear();
	}

	public static String getTextCacheAsString() {
		String output = "";

		for (String word : Global.textCache) {
			output += word + " ";
		}

		return output;
	}
}
