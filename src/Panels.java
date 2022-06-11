/**
 * Class of methods for constructing panels:
 * - Level or difficulty panel (left)
 * - Time panel (right)
 * - Center panel
 * 	- Text display for user input and shows randomly generated text
 * 	- Time display for showing time remaining before end of test
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Panels {

	/* Typing test difficulty (left side of screen) */
	public static JPanel createLevelPanel() {
		JPanel levelPanel = new JPanel();
		Global.levelPanel = levelPanel;

		// Format
		levelPanel.setBounds(0, 0, Global.sidePanelWidth, Global.Y);
		levelPanel.setLayout(new GridLayout(3, 1, 80, 80)); // Rows, columns, horizontal gap, vertical gap

		// Optional formatting
		levelPanel.setBorder(Global.levelPanelBorder);
		levelPanel.setBackground(new Color(57, 51, 70)); // RGB

		// Components
		JButton levelEasy = new JButton("Easy");
		JButton levelMed = new JButton("Medium");
		JButton levelHard = new JButton("Hard");
		ActionListener levelEasyAL = e -> textGenerator.generateTextCache(1);
		ActionListener levelMedAL = e -> textGenerator.generateTextCache(2);
		ActionListener levelHardAL = e -> textGenerator.generateTextCache(3);
		levelEasy.addActionListener(levelEasyAL);
		levelMed.addActionListener(levelMedAL);
		levelHard.addActionListener(levelHardAL);
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
		timePanel.setBorder(Global.timePanelBorder);
		timePanel.setBackground(new Color(57, 51, 70));

		// Components
		JButton tensec = new JButton("10 sec");
		JButton thirtysec = new JButton("30 sec");
		JButton sixtysec = new JButton("60 sec");
		ActionListener tensecAL = e -> Timer.setTime(10);
		ActionListener thirtysecAL = e -> Timer.setTime(30);
		ActionListener sixtysecAL = e -> Timer.setTime(60);
		tensec.addActionListener(tensecAL);
		thirtysec.addActionListener(thirtysecAL);
		sixtysec.addActionListener(sixtysecAL);
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
		centerPanel.setBorder(Global.centerBorder);
		centerPanel.setBackground(new Color(57, 51, 70));

		// Components
		JLayeredPane textDisplay = createTextDisplay();
		centerPanel.add(textDisplay);

		JTextField timeDisplay = createTimeDisplay(30);
		centerPanel.add(timeDisplay);

		return centerPanel;
	}

	/* Where user reads and types words. */
	public static JLayeredPane createTextDisplay() {
		JLayeredPane textDisplay = new JLayeredPane();
		Global.textDisplay = textDisplay;

		// Format
		textDisplay.setAlignmentX(Global.X/2);
		textDisplay.setBounds(Global.sidePanelWidth, 0, Global.centerPanelWidth, Global.Y/2);

		// Components
		JTextArea generatedText = createGeneratedTextArea();
		textDisplay.add(generatedText, 1);

		JTextArea typingArea = createUserTypingArea();
		textDisplay.add(typingArea, 0);

		JButton restart = new JButton("Restart");
		ActionListener restartAL = e -> Timer.setTime(Global.testDuration);
		restart.addActionListener(restartAL);
		restart.setBounds(Global.centerPanelWidth/2-Global.centerPanelWidth/8, Global.Y/3, Global.centerPanelWidth/4, Global.Y/10);
		restart.setAlignmentX(Global.X/2);
		textDisplay.add(restart, 0);

		return textDisplay;
	}

	/* Generated text for user to type. */
	public static JTextArea createGeneratedTextArea() {

		// Temporary placeholder text
		JTextArea generatedText = new JTextArea(6, Global.textDisplayCharacterLimit);
		Global.generatedText = generatedText;
		textGenerator.generateTextCache(2);

		// Format
		generatedText.setLineWrap(true);
		generatedText.setEditable(false);
		generatedText.setWrapStyleWord(true);
		generatedText.setBounds(0, 0, Global.centerPanelWidth, Global.Y/2);

		// Optional formatting
		int gap = 40;
		generatedText.setMargin(new Insets(gap, gap, gap, gap));
		generatedText.setBorder(Global.generatedTextBorder);
		generatedText.setFont(Global.typingAreaFont);
		generatedText.setForeground(new Color(186, 132, 94));
		generatedText.setBackground(new Color(83, 67, 55, 255));

		return generatedText;
	}

	/* Where user types in characters. */
	public static JTextArea createUserTypingArea() {
		JTextArea typingArea = new JTextArea("", 6, Global.textDisplayCharacterLimit);
		Global.typingArea = typingArea;

		// Format
		typingArea.setLineWrap(true);
		typingArea.setWrapStyleWord(true);
		typingArea.setBounds(0, 0, Global.centerPanelWidth, Global.Y/2);

		// Optional formatting
		int gap = 40;
		typingArea.setMargin(new Insets(gap, gap, gap, gap));
		typingArea.setBorder(Global.generatedTextBorder);
		typingArea.setFont(Global.typingAreaFont);
		typingArea.setForeground(new Color(255, 123, 0));
		typingArea.setBackground(new Color(0, 0, 0, 0));
		typingArea.setCaretColor(Color.white);

		return typingArea;
	}

	/* Remaining seconds before typing test ends */
	public static JTextField createTimeDisplay(int seconds) {
		Global.secondsRemaining = seconds;
		JTextField timeDisplay = new JTextField(Integer.toString(Global.secondsRemaining));
		Global.timeDisplay = timeDisplay;

		// Format
		timeDisplay.setHorizontalAlignment(JTextField.CENTER);
		timeDisplay.setEditable(false);
		timeDisplay.setBounds(Global.sidePanelWidth, Global.Y/2, Global.centerPanelWidth, Global.Y/2);

		// Optional formatting
		timeDisplay.setFont(Global.timeDisplayFont);
		timeDisplay.setBorder(Global.centerLineBorder);
		timeDisplay.setForeground(new Color(188, 188, 188));
		timeDisplay.setBackground(new Color(67, 67, 67, 0));

		return timeDisplay;
	}
}
