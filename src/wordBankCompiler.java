/**
 * Stores word bank words into a list.
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class wordBankCompiler {

	// Compile the word bank for each typing test difficulty
	public static void compileBank() throws IOException {
		FileReader fr = new FileReader("WordBanks/wordBank300.txt");
		Global.easyBank = compileBank(fr);

		fr = new FileReader("WordBanks/wordBank500.txt");
		Global.mediumBank = compileBank(fr);

		fr = new FileReader("WordBanks/wordBank1000.txt");
		Global.hardBank = compileBank(fr);
	}

	// Fill an ArrayList with all the words from a given word bank
	public static ArrayList<String> compileBank(FileReader fr) throws IOException {
		BufferedReader br = new BufferedReader(fr);
		ArrayList<String> wordBank = new ArrayList<>();
		String word;

		while ((word = br.readLine()) != null) {
			wordBank.add(word);
		}

		return (ArrayList<String>) wordBank.clone();
	}
}
