/**
 * Class of methods for creating panels.
 * @version Wed June 1, 10AM
 */
import javax.swing.*;
import java.awt.*;

public class Panels {
	/* Make pretty buttons */
	/*public static JButton sideButton(String text) {
		JButton button = new JButton(text);
		
		return button;
	}
	*/
	/* Typing test difficulty panel (left side) */
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
		timePanel.setLayout(new GridLayout(3, 1, 80, 80)); // Rows, columns, horizontal gap, vertical gap
		timePanel.setBackground(new Color(68, 53, 99)); // RGB
		timePanel.setBorder(Global.sideBorder);

		return timePanel;
	}

	/* Typing test typing area panel (center) */
	public static JPanel createTypingPanel() {
		JPanel typingPanel = new JPanel();

		typingPanel.setBounds(Global.sidePanelWidth, 0, Global.centerPanelWidth, Global.Y);
		typingPanel.setBackground(new Color(67, 67, 67)); // RGB
		typingPanel.setBorder(Global.centerBorder);

		return typingPanel;
	}
}
