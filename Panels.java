/**
 * Class of methods for creating panels.
 * @version Wed June 2, 8PM
 */
import javax.swing.*;
import java.awt.*;

public class Panels {
	public static JPanel createLevelPanel() {
		JPanel levelPanel = new JPanel();

		JButton levelEasy = new JButton("Easy");
		JButton levelMed = new JButton("Medium");
		JButton levelHard = new JButton("Hard");
		levelPanel.add(levelEasy);
		levelPanel.add(levelMed);
		levelPanel.add(levelHard);

		levelPanel.setBounds(0, 0, Global.sidePanelWidth, Global.Y);
		levelPanel.setBorder(Global.sideBorder);
		levelPanel.setBackground(new Color(68, 53, 99)); // RGB
		levelPanel.setLayout(new GridLayout(3, 1, 80, 80)); // Rows, columns, horizontal gap, vertical gap

		return levelPanel;
	}

	/* Typing test time panel (right side) */
	public static JPanel createTimePanel() {
		JPanel timePanel = new JPanel();

		JButton tensec = new JButton("10 sec");
		JButton thirtysec = new JButton("30 sec");
		JButton sixtysec = new JButton("60 sec");
		timePanel.add(tensec);
		timePanel.add(thirtysec);
		timePanel.add(sixtysec);

		timePanel.setBounds(Global.sidePanelWidth + Global.centerPanelWidth, 0, Global.sidePanelWidth, Global.Y);
		timePanel.setLayout(new GridLayout(3, 1, 80, 80));
		timePanel.setBackground(new Color(68, 53, 99));
		timePanel.setBorder(Global.sideBorder);

		return timePanel;
	}

	/* Typing test typing area panel (center) */
	public static JPanel createTypingPanel() {
		JPanel typingPanel = new JPanel();
		JTextArea typingArea = createTypingArea();

		typingPanel.setBounds(Global.sidePanelWidth, 0, Global.centerPanelWidth, Global.Y);
		typingPanel.setBackground(new Color(67, 67, 67));
		typingPanel.setBorder(Global.centerBorder);
		typingPanel.add(typingArea);

		ClearText.main();

		return typingPanel;
	}

	/* Typing panel text area */
	public static JTextArea createTypingArea() {
		JTextArea typingArea = new JTextArea("", 6, 40);

		typingArea.setFont(Global.typingAreaFont);
		typingArea.setLineWrap(true);
		typingArea.setWrapStyleWord(true);

		typingArea.setBackground(new Color(135, 60, 0));
		typingArea.setForeground(Color.white);

		typingArea.setCaretColor(new Color(170, 251, 77));
		int gap = 40;
		typingArea.setMargin(new Insets(gap, gap, gap, gap));
		typingArea.setAlignmentX(Global.X/2);

		Global.typingArea = typingArea;
		return typingArea;
	}
}
