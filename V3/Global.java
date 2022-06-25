import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;

/**
 * Variables to be accessed by multiple classes.
 */
public class Global {

	// Screen size
	enum Screen {;
		final static Dimension SCREEN = Toolkit.getDefaultToolkit().getScreenSize();
		final static int WIDTH = SCREEN.width - 200; // Subtract to make sure that the entire window is visible.
		final static int HEIGHT = SCREEN.height - 100;
	}

	// Panel size
	final static int CENTER_PANEL_WIDTH = Screen.WIDTH / 2;
	final static int SIDE_PANEL_WIDTH = (Screen.WIDTH - CENTER_PANEL_WIDTH) / 2;

	// Fonts
	enum TypingAreaFont {;
		final static int SCALE = 28;
		final static int SIZE = Screen.HEIGHT / SCALE;
		final static Font FONT = new Font(Font.MONOSPACED, Font.PLAIN, SIZE);

	}
	enum TimeDisplayFont {;
		final static int TIMER_SCALE = 7;
		final static int SCORE_SCALE = 12;
		final static int TIMER_SIZE = Screen.HEIGHT / TIMER_SCALE;
		final static int SCORE_SIZE = Screen.HEIGHT / SCORE_SCALE;
		final static Font TIMER_FONT = new Font(Font.MONOSPACED, Font.PLAIN, TIMER_SIZE);
		final static Font SCORE_FONT = new Font(Font.MONOSPACED, Font.PLAIN, SCORE_SIZE);
	}

	// Padding values determine the size of the gap between components and panel edges.
	enum Padding {;
		final static int SIDE_PANEL_PADDING_SCALE = 15;
		final static int SIDE_PANEL = Screen.HEIGHT / SIDE_PANEL_PADDING_SCALE;

		final static int CENTER_PANEL_PADDING_SCALE = 15;
		final static int CENTER_PANEL = Screen.HEIGHT / CENTER_PANEL_PADDING_SCALE;

		final static int GENERATED_TEXT_BOX_SCALE = 30;
		final static int GENERATED_TEXT_BOX = Screen.HEIGHT / GENERATED_TEXT_BOX_SCALE;
	}

	// Borders for panels and text boxes
	enum Borders {;
		final static Border SIDE_PANEL_PADDING_BORDER = BorderFactory.createEmptyBorder
				(Padding.SIDE_PANEL, Padding.SIDE_PANEL, Padding.SIDE_PANEL, Padding.SIDE_PANEL); // top left bottom right

		final static Border LEVEL_PANEL_LINE_BORDER = BorderFactory.createMatteBorder
				(Screen.HEIGHT /10, Screen.HEIGHT /50, Screen.HEIGHT /10, 0, Color.BLACK);

		final static Border TIME_PANEL_LINE_BORDER = BorderFactory.createMatteBorder
				(Screen.HEIGHT /10, 0, Screen.HEIGHT /10, Screen.HEIGHT /50, Color.BLACK);

		final static Border CENTER_PANEL_PADDING_BORDER = BorderFactory.createEmptyBorder
				(Padding.CENTER_PANEL, Padding.CENTER_PANEL, Padding.CENTER_PANEL, Padding.CENTER_PANEL);

		final static Border CENTER_PANEL_LINE_BORDER = BorderFactory.createMatteBorder
				(0, 0, 20, 0, Color.BLACK);

		final static Border GENERATED_TEXT_BOX_PADDING_BORDER = BorderFactory.createEmptyBorder
				(Padding.GENERATED_TEXT_BOX, Padding.GENERATED_TEXT_BOX, Padding.GENERATED_TEXT_BOX, Padding.GENERATED_TEXT_BOX);

		final static Border GENERATED_TEXT_BOX_LINE_BORDER = BorderFactory.createMatteBorder
				(20, 20, 20, 20, new Color(45, 31, 19, 255));

		final static Border BUTTON_BORDER = BorderFactory.createMatteBorder
				(10, 10, 10, 10, new Color(45, 31, 19, 255));

		// Final borders to be used (a combination of 2 borders)
		final static Border LEVEL_PANEL_BORDER = new CompoundBorder
				(Borders.LEVEL_PANEL_LINE_BORDER, Borders.SIDE_PANEL_PADDING_BORDER);

		final static Border TIME_PANEL_BORDER = new CompoundBorder
				(Borders.TIME_PANEL_LINE_BORDER, Borders.SIDE_PANEL_PADDING_BORDER);

		final static Border CENTER_BORDER = new CompoundBorder
				(Borders.CENTER_PANEL_LINE_BORDER, Borders.CENTER_PANEL_PADDING_BORDER);

		final static Border GENERATED_TEXT_BOX_BORDER = new CompoundBorder
				(Borders.GENERATED_TEXT_BOX_LINE_BORDER, Borders.GENERATED_TEXT_BOX_PADDING_BORDER);
	}

	// Components
	static JFrame frame;
	static JPanel levelPanel;
	static JPanel timePanel;
	static JPanel centerPanel; // Contains textDisplay, timeDisplay, and resultsPanel
		static JLayeredPane textDisplay; // Contains generatedTextArea and typingArea
			static JTextArea generatedTextArea;
			static JTextArea typingArea;
		static JTextField timeDisplay;
		static JTextField scoreDisplay;
		static JPanel resultsPanel;
	static ArrayList<JButton> levelButtons = new ArrayList<>();
	static ArrayList<JButton> timeButtons = new ArrayList<>();

	// TypingTest menu setup
	static JFrame settingsFrame = new JFrame("Settings");
	static JFrame achievementFrame = new JFrame("Achievements");
	static JFrame informationFrame = new JFrame("Information");
	static JFrame signupFrame = new JFrame("Sign up");
	static JFrame loginFrame = new JFrame("Login");

	// Text generation
	static int testLevel = 2; // 1 = easy, 2 = medium, 3 = hard
	static ArrayList<String> easyBank = new ArrayList<>();
	static ArrayList<String> mediumBank = new ArrayList<>();
	static ArrayList<String> hardBank = new ArrayList<>();
	static ArrayList<String> generatedText = new ArrayList<>();

	// Calculate number of characters in a line of text for text deleting purposes (see Threads class -> clearTextThread)
	final static int TEXT_BOX_CHARACTER_LIMIT = (CENTER_PANEL_WIDTH - Padding.CENTER_PANEL * 2 -
			Padding.GENERATED_TEXT_BOX * 2 - 80) / (TypingAreaFont.SIZE / 2);

	// Timer
	static int testDuration = 30;
	static int secondsRemaining = 30;
	static boolean testActive = false;

	// Test results
	static String currentUserTextAsString = ""; // User-typed text that is currently visible
	static ArrayList<Integer> wpmUpdates = new ArrayList<>();
	static ArrayList<String> allUserText = new ArrayList<>();
	static String deletedUserText = "";
	static boolean testEnded = false;

	/*
	static float currentTime = System.currentTimeMillis();
	static String recordDay = String.valueOf(Calendar.getInstance());
	static Border menuBorder = new CompoundBorder();
	 */

}
