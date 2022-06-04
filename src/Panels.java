/**
 * CONTENTS OF CENTER PANEL IS A WORK IN PROGRESS
 * Class of methods for creating panels.
 * @version Wed June 2, 8PM
 */
import javax.swing.*;
import java.awt.*;

public class Panels {
	/* Typing test difficulty (left side of screen) */
	public static JPanel createLevelPanel() {
		JPanel levelPanel = new JPanel();
		Global.levelPanel = levelPanel;
		levelPanel.setBounds(0, 0, Global.sidePanelWidth, Global.Y);
		levelPanel.setBorder(Global.sideBorder);
		levelPanel.setBackground(new Color(68, 53, 99)); // RGB
		levelPanel.setLayout(new GridLayout(3, 1, 80, 80)); // Rows, columns, horizontal gap, vertical gap

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
		timePanel.setBounds(Global.sidePanelWidth + Global.centerPanelWidth, 0, Global.sidePanelWidth, Global.Y);
		timePanel.setLayout(new GridLayout(3, 1, 80, 80));
		timePanel.setBackground(new Color(68, 53, 99));
		timePanel.setBorder(Global.sideBorder);

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
		centerPanel.setBounds(Global.sidePanelWidth, 0, Global.centerPanelWidth, Global.Y);
		centerPanel.setBackground(new Color(67, 67, 67));
		centerPanel.setBorder(Global.centerBorder);
		centerPanel.setLayout(null);

		JLayeredPane textDisplay = createTextDisplay();
		centerPanel.add(textDisplay);

		return centerPanel; //ClearText.main();
	}

	/* Where user reads and types words. */
	public static JLayeredPane createTextDisplay() {
		JLayeredPane textDisplay = new JLayeredPane();
		Global.textDisplay = textDisplay;
		textDisplay.setBounds(0, 0, Global.centerPanelWidth - 300, Global.Y/2);
		textDisplay.setAlignmentX(Global.X/2);
		textDisplay.setBackground(new Color(106, 1, 135));
		textDisplay.setLayout(new GridLayout(1, 1));

		textDisplay.add(createGeneratedText());
		//JTextArea generatedText = createGeneratedText();
		//textDisplay.add(generatedText, 1);

		return textDisplay; //JTextArea typingArea = createTypingArea(); //textDisplay.add(typingArea);
	}

	/* Generated text for user to type. */
	public static JTextArea createGeneratedText() {
		JTextArea generatedText = new JTextArea
				("open fact interest take word group only some than public give year " +
						"think consider help each hold the good may some world can the " +
						"between how each person into few no say many could after",
						6, Global.textDisplayCharacterLimit);
		Global.generatedText = generatedText;

		generatedText.setBounds(0, 0, Global.centerPanelWidth - 300, Global.Y/2);
		generatedText.setEditable(false);
		generatedText.setFont(Global.typingAreaFont);
		generatedText.setLineWrap(true);
		generatedText.setWrapStyleWord(true);

		generatedText.setBackground(new Color(135, 60, 0));
		generatedText.setForeground(Color.white);

		generatedText.setCaretColor(new Color(170, 251, 77));
		int gap = 40;
		generatedText.setMargin(new Insets(gap, gap, gap, gap));
		generatedText.setAlignmentX(Global.X/2);

		return generatedText;
	}

	/* Where user types in characters. */
	/* public static JTextArea createTypingArea() {
		JTextArea typingArea = new JTextArea("", 6, 40);
		Global.typingArea = typingArea;

		typingArea.setFont(Global.typingAreaFont);
		typingArea.setLineWrap(true);
		typingArea.setWrapStyleWord(true);

		typingArea.setBackground(new Color(135, 60, 0));
		typingArea.setForeground(Color.white);

		typingArea.setCaretColor(new Color(170, 251, 77));
		int gap = 40;
		typingArea.setMargin(new Insets(gap, gap, gap, gap));
		typingArea.setAlignmentX(Global.X/2);

		return typingArea;
	} */
}
