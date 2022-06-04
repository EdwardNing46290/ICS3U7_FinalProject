/**
 * @version Wed June 3, 9PM
 *
 * Class of methods for constructing panels:
 * - Level or difficulty panel (left)
 * - Time panel (right)
 * - Center panel
 * 	- Text display for user input and randomly generated text
 */
import javax.swing.*;
import java.awt.*;

public class Panels {

	/* Typing test difficulty (left side of screen) */
	public static JPanel createLevelPanel() {
		JPanel levelPanel = new JPanel();
		Global.levelPanel = levelPanel;

		// Format
		levelPanel.setBounds(0, 0, Global.sidePanelWidth, Global.Y);
		levelPanel.setLayout(new GridLayout(3, 1, 80, 80)); // Rows, columns, horizontal gap, vertical gap

		// Optional formatting
		levelPanel.setBorder(Global.sideBorder);
		levelPanel.setBackground(new Color(68, 53, 99)); // RGB

		// Components
		JButton levelEasy = new JButton("Easy");
		JButton levelMed = new JButton("Medium");
		JButton levelHard = new JButton("Hard");
		levelPanel.add(levelEasy);
		levelPanel.add(levelMed);
		levelPanel.add(levelHard);

		return levelPanel;
	}

	/* Typing test duration (right side of screen) */
	public static JPanel createTimePanel() {
		JPanel timePanel = new JPanel();
		Global.timePanel = timePanel;

		// Format
		timePanel.setLayout(new GridLayout(3, 1, 80, 80));
		timePanel.setBounds(Global.sidePanelWidth + Global.centerPanelWidth, 0, Global.sidePanelWidth, Global.Y);

		// Optional formatting
		timePanel.setBorder(Global.sideBorder);
		timePanel.setBackground(new Color(68, 53, 99));

		// Components
		JButton tensec = new JButton("10 sec");
		JButton thirtysec = new JButton("30 sec");
		JButton sixtysec = new JButton("60 sec");
		timePanel.add(tensec);
		timePanel.add(thirtysec);
		timePanel.add(sixtysec);

		return timePanel;
	}

	/* Center panel */
	public static JPanel createCenterPanel() {
		JPanel centerPanel = new JPanel();
		Global.centerPanel = centerPanel;

		// Format
		centerPanel.setLayout(null);
		centerPanel.setBounds(Global.sidePanelWidth, 0, Global.centerPanelWidth, Global.Y);

		// Optional formatting
		centerPanel.setBorder(Global.centerLineBorder);
		centerPanel.setBackground(new Color(67, 67, 67));

		// Components
		JLayeredPane textDisplay = createTextDisplay();
		centerPanel.add(textDisplay);

		return centerPanel;
	}

	/* Where user reads and types words. */
	public static JLayeredPane createTextDisplay() {
		JLayeredPane textDisplay = new JLayeredPane();
		Global.textDisplay = textDisplay;

		// Format
		textDisplay.setAlignmentX(Global.X/2);
		textDisplay.setLayout(new GridLayout(1, 1));
		textDisplay.setBounds(Global.sidePanelWidth, 0, Global.centerPanelWidth, Global.Y/2);

		// Optional formatting
		textDisplay.setBorder(Global.textDisplayPaddingBorder);
		textDisplay.setBackground(new Color(106, 1, 135));

		// Components
		JTextArea generatedText = createGeneratedTextArea();
		textDisplay.add(generatedText);

		return textDisplay;
	}

	/* Generated text for user to type. */
	public static JTextArea createGeneratedTextArea() {
		JTextArea generatedText = new JTextArea // Temporary placeholder text
				("open fact interest take word group only some than public give year " +
						"think consider help each hold the good may some world can the " +
						"between how each person into few no say many could after",
						6, Global.textDisplayCharacterLimit);
		Global.generatedText = generatedText;

		// Format
		generatedText.setLineWrap(true);
		generatedText.setEditable(false);
		generatedText.setWrapStyleWord(true);
		generatedText.setAlignmentX(Global.X/2);
		generatedText.setBounds(Global.sidePanelWidth, 0, Global.centerPanelWidth, Global.Y/2);

		// Optional formatting
		int gap = 40;
		generatedText.setMargin(new Insets(gap, gap, gap, gap));
		generatedText.setFont(Global.typingAreaFont);
		generatedText.setForeground(Color.gray);
		generatedText.setBackground(new Color(135, 60, 0));

		return generatedText;
	}

	/* NOT IN USE Where user types in characters. */
	public static JTextArea createUserTypingArea() {
		JTextArea typingArea = new JTextArea("", 6, Global.textDisplayCharacterLimit);
		Global.typingArea = typingArea;

		// Format
		typingArea.setLineWrap(true);
		typingArea.setWrapStyleWord(true);
		typingArea.setAlignmentX(Global.X/2);

		// Optional formatting
		typingArea.setFont(Global.typingAreaFont);
		int gap = 40;
		typingArea.setMargin(new Insets(gap, gap, gap, gap));
		typingArea.setForeground(Color.white);
		typingArea.setBackground(new Color(135, 60, 0));
		typingArea.setCaretColor(new Color(170, 251, 77));

		return typingArea;
	}
}
