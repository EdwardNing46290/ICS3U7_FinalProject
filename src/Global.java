import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.Calendar;

public class Global {

	// Screen size
	static Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
	static int X = screen.width - 200; // Subtract to make sure that the entire window is visible.
	static int Y = screen.height - 100;

	// Panel size
	static int centerPanelWidth = X / 2;
	static int sidePanelWidth = (X - centerPanelWidth) / 2;

	// Font
	static int typingAreaFontScale = 28;
	static Font typingAreaFont = new Font(Font.MONOSPACED, Font.PLAIN, Y / typingAreaFontScale);
	static int timeDisplayFontScale = 5;
	static Font timeDisplayFont = new Font(Font.MONOSPACED, Font.PLAIN, Y / timeDisplayFontScale);

	// Padding values determine the size of the gap between components and panel edges.
	static int sidePaddingValueScale = 15;
	static int sidePaddingValue = Y / sidePaddingValueScale;

	static int centerPaddingValueScale = 15;
	static int centerPaddingValue = Y / centerPaddingValueScale;

	static int generatedTextPaddingScale = 30;
	static int generatedTextPaddingValue = Y / generatedTextPaddingScale;
	
	static int displayPaddingScale = 20;
	static int displayPaddingValue = Y / displayPaddingScale;

	// Borders
	static Border sidePaddingBorder = BorderFactory.createEmptyBorder
			(sidePaddingValue, sidePaddingValue, sidePaddingValue, sidePaddingValue); // top left bottom right
	static Border levelPanelLineBorder = BorderFactory.createMatteBorder(Y/10, Y/50, Y/10, 0, Color.BLACK);
	static Border timePanelLineBorder = BorderFactory.createMatteBorder(Y/10, 0, Y/10, Y/50, Color.BLACK);
	static Border levelPanelBorder = new CompoundBorder(levelPanelLineBorder, sidePaddingBorder);
	static Border timePanelBorder = new CompoundBorder(timePanelLineBorder, sidePaddingBorder);

	static Border centerPaddingBorder = BorderFactory.createEmptyBorder
			(centerPaddingValue, centerPaddingValue, centerPaddingValue, centerPaddingValue);
	static Border centerLineBorder = BorderFactory.createMatteBorder(0, 0, 20, 0, Color.BLACK);
	static Border centerBorder = new CompoundBorder(centerLineBorder, centerPaddingBorder);

	static Border generatedTextPaddingBorder = BorderFactory.createEmptyBorder
			(generatedTextPaddingValue, generatedTextPaddingValue, generatedTextPaddingValue, generatedTextPaddingValue);
	static Border generatedTextLineBorder = BorderFactory.createMatteBorder(20, 20, 20, 20, new Color(45, 31, 19, 255));
	static Border generatedTextBorder = new CompoundBorder(generatedTextLineBorder, generatedTextPaddingBorder);
	
	static Border displayBorder = BorderFactory.createEmptyBorder
			(displayPaddingValue, displayPaddingValue, displayPaddingValue, displayPaddingValue);
	static Border textDisplayPaddingBorder = BorderFactory.createMatteBorder(20, 20, 20, 20, Color.RED);
	
	static Border sideBorder = new CompoundBorder(sidePaddingBorder, sidePaddingBorder);

	// Components
	static JFrame frame;
	static JPanel levelPanel;
	static JPanel timePanel;
	static JPanel centerPanel;
	static JLayeredPane textDisplay;
	static JTextArea generatedText;
	static JTextArea typingArea;
	static JTextField timeDisplay;

	// Text generation
	static int testLevel = 2; // 1 = easy, 2 = medium, 3 = hard
	static ArrayList<String> easyBank = new ArrayList<>();
	static ArrayList<String> mediumBank = new ArrayList<>();
	static ArrayList<String> hardBank = new ArrayList<>();
	static ArrayList<String> currentBank = new ArrayList<>();
	static ArrayList<String> textCache = new ArrayList<>();
	static int textDisplayCharacterLimit = centerPanelWidth / typingAreaFontScale;

	// Timer
	static int testDuration = 30;
	static int secondsRemaining = 30;
	static float currentTime = System.currentTimeMillis();
	static String recordDay = String.valueOf(Calendar.getInstance());
	static boolean testActive = false;
	
	static Border menuBorder = new CompoundBorder();

	// Test results
	static String userTextAsString;
	static ArrayList<String> userText=  new ArrayList<>();
}
