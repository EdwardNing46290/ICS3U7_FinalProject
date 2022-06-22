import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Class of methods that construct the following panels <br>
 * - Level or difficulty panel - left side <br>
 * - Time (test duration) panel - right side <br>
 * - Center panel <br>
 *   - Text display - user input, randomly generated text <br>
 *   - Timer <br>
 *   - WPM graph - user typing speed during the entire test
 */
public class Panels {

	/** Typing test difficulty (left side of screen) */
	public static JPanel createLevelPanel() {
		JPanel levelPanel = new JPanel();
		Global.levelPanel = levelPanel;

		// Format
		levelPanel.setBounds(0, 0, Global.SIDE_PANEL_WIDTH, Global.Screen.HEIGHT);
		levelPanel.setLayout(new GridLayout(3, 1, 80, 80)); // Rows, columns, horizontal gap, vertical gap

		// Optional formatting
		levelPanel.setBorder(Global.Borders.LEVEL_PANEL_BORDER);
		levelPanel.setBackground(new Color(57, 51, 70)); // RGB

		// Components
		JButton levelEasy = new JButton("Easy");
		JButton levelMedium = new JButton("Medium");
		JButton levelHard = new JButton("Hard");

		ActionListener levelEasyAL = al -> TextGenerator.setDifficulty(1, true, true);
		ActionListener levelMediumAL = al -> TextGenerator.setDifficulty(2, true, true);
		ActionListener levelHardAL = al -> TextGenerator.setDifficulty(3, true, true);

		levelEasy.addActionListener(levelEasyAL);
		levelMedium.addActionListener(levelMediumAL);
		levelHard.addActionListener(levelHardAL);
		levelPanel.add(levelEasy);
		levelPanel.add(levelMedium);
		levelPanel.add(levelHard);

		return levelPanel;
	}

	/** For choosing typing test duration (right side of screen) */
	public static JPanel createTimePanel() {
		JPanel timePanel = new JPanel();
		Global.timePanel = timePanel;

		// Format
		timePanel.setLayout(new GridLayout(3, 1, 80, 80));
		timePanel.setBounds(Global.SIDE_PANEL_WIDTH + Global.CENTER_PANEL_WIDTH, 0,
				Global.SIDE_PANEL_WIDTH, Global.Screen.HEIGHT);

		// Optional formatting
		timePanel.setBorder(Global.Borders.TIME_PANEL_BORDER);
		timePanel.setBackground(new Color(57, 51, 70));

		// Components
		JButton tenSecondButton = new JButton("10 sec");
		JButton thirtySecondButton = new JButton("30 sec");
		JButton sixtySecondButton = new JButton("60 sec");

		ActionListener tenSecondButtonAL = e -> Timer.setTime(10);
		ActionListener thirtySecondButtonAL = e -> Timer.setTime(30);
		ActionListener sixtySecondButtonAL = e -> Timer.setTime(60);

		tenSecondButton.addActionListener(tenSecondButtonAL);
		thirtySecondButton.addActionListener(thirtySecondButtonAL);
		sixtySecondButton.addActionListener(sixtySecondButtonAL);
		timePanel.add(tenSecondButton);
		timePanel.add(thirtySecondButton);
		timePanel.add(sixtySecondButton);

		return timePanel;
	}

	/** Center panel with text display and timer */
	public static JPanel createCenterPanel() {
		JPanel centerPanel = new JPanel();
		Global.centerPanel = centerPanel;

		// Format
		centerPanel.setLayout(null);
		centerPanel.setBounds(Global.SIDE_PANEL_WIDTH, 0, Global.CENTER_PANEL_WIDTH, Global.Screen.HEIGHT);

		// Optional formatting
		centerPanel.setBorder(Global.Borders.CENTER_BORDER);
		centerPanel.setBackground(new Color(57, 51, 70));

		// Components
		JLayeredPane textDisplay = createTextDisplay();
		centerPanel.add(textDisplay);

		JTextField timeDisplay = createTimeDisplay();
		centerPanel.add(timeDisplay);

		return centerPanel;
	}

	/** Area where user reads and types words */
	public static JLayeredPane createTextDisplay() {
		JLayeredPane textDisplay = new JLayeredPane();
		Global.textDisplay = textDisplay;

		// Format
		textDisplay.setAlignmentX(Global.Screen.WIDTH / 2);
		textDisplay.setBounds(Global.SIDE_PANEL_WIDTH, 0, Global.CENTER_PANEL_WIDTH, Global.Screen.HEIGHT / 2);

		// Components
		JTextArea generatedText = createGeneratedTextArea();
		textDisplay.add(generatedText, 1);

		JTextArea typingArea = createUserTypingArea();
		textDisplay.add(typingArea, 0);

		return textDisplay;
	}

	/** Show generated text for user to type */
	public static JTextArea createGeneratedTextArea() {

		// Generate text, default difficulty is medium.
		JTextArea generatedTextArea = new JTextArea();
		Global.generatedTextArea = generatedTextArea;
		TextGenerator.setDifficulty(2, true, true);

		// Format
		generatedTextArea.setLineWrap(true);
		generatedTextArea.setEditable(false);
		generatedTextArea.setWrapStyleWord(true);
		generatedTextArea.setBounds(0, 0, Global.CENTER_PANEL_WIDTH, Global.Screen.HEIGHT / 2);

		// Optional formatting
		int gap = 40;
		generatedTextArea.setMargin(new Insets(gap, gap, gap, gap));
		generatedTextArea.setBorder(Global.Borders.GENERATED_TEXT_BOX_BORDER);
		generatedTextArea.setFont(Global.TypingAreaFont.FONT);
		generatedTextArea.setForeground(new Color(186, 132, 94));
		generatedTextArea.setBackground(new Color(83, 67, 55, 255));

		return generatedTextArea;
	}

	/** Where user types in characters. */
	public static JTextArea createUserTypingArea() {
		JTextArea typingArea = new JTextArea();
		Global.typingArea = typingArea;

		// Format
		typingArea.setLineWrap(true);
		typingArea.setWrapStyleWord(true);
		typingArea.setBounds(0, 0, Global.CENTER_PANEL_WIDTH, Global.Screen.HEIGHT / 2);

		// Optional formatting
		int gap = 40;
		typingArea.setMargin(new Insets(gap, gap, gap, gap));
		typingArea.setBorder(Global.Borders.GENERATED_TEXT_BOX_BORDER);
		typingArea.setFont(Global.TypingAreaFont.FONT);
		typingArea.setForeground(new Color(255, 123, 0));
		typingArea.setBackground(new Color(0, 0, 0, 0));
		typingArea.setCaretColor(Color.white);

		return typingArea;
	}

	/** Timer */
	public static JTextField createTimeDisplay() {
		JTextField timeDisplay = new JTextField(Integer.toString(Global.secondsRemaining));
		Global.timeDisplay = timeDisplay;

		// Format
		timeDisplay.setHorizontalAlignment(JTextField.CENTER);
		timeDisplay.setEditable(false);
		timeDisplay.setBounds(Global.SIDE_PANEL_WIDTH, Global.Screen.HEIGHT / 2, Global.CENTER_PANEL_WIDTH, Global.Screen.HEIGHT / 2);

		// Optional formatting
		timeDisplay.setFont(Global.TimeDisplayFont.FONT);
		timeDisplay.setBorder(Global.Borders.CENTER_PANEL_LINE_BORDER);
		timeDisplay.setForeground(new Color(188, 188, 188));
		timeDisplay.setBackground(new Color(67, 67, 67, 0));

		// Components
		JButton restart = new JButton("Restart");

		ActionListener restartAL = e -> {

			// Restart progress if test hasn't finished.
			if (Global.testActive) {
				TypingTest.reset();
				Timer.setTime(Global.testDuration);
			}

			// If test ended, generate and display new text.
			if (Global.testEnded) {
				Timer.setTime(Global.testDuration);
				TextGenerator.setDifficulty(Global.testLevel, true, true);
				Global.testEnded = false;
			}
		};

		restart.setBounds(Global.CENTER_PANEL_WIDTH / 2 - Global.CENTER_PANEL_WIDTH / 8, Global.Screen.HEIGHT/40,
				Global.CENTER_PANEL_WIDTH / 4, Global.Screen.HEIGHT / 10);
		restart.setAlignmentX(Global.CENTER_PANEL_WIDTH / 2);
		restart.setAlignmentX(Global.Screen.WIDTH / 2);
		restart.addActionListener(restartAL);
		timeDisplay.add(restart);

		return timeDisplay;
	}
}
