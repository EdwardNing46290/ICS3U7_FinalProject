/**
 * Contains variables that are used across several classes.
 * @version Wed June 3, 9PM
 */
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import java.awt.*;

public class Global {

	// Screen size
	static Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
	static int X = screen.width - 200; // Subtract a bit to make sure
	static int Y = screen.height - 100; // that the entire window is visible.

	// Fonts
	static int typingAreaFontScale = 40;
	static Font typingAreaFont = new Font(Font.MONOSPACED, Font.PLAIN, Y / typingAreaFontScale);

	// Padding values determine the size of the gap between buttons and the edges of the panel.
	static int centerPaddingValueScale = 30;
	static int centerPaddingValue = Y / centerPaddingValueScale;
	static int sidePaddingValueScale = 15;
	static int sidePaddingValue = Y / sidePaddingValueScale;

	// Panel sizes
	static int centerPanelWidth = X / 2;
	static int sidePanelWidth = (X - centerPanelWidth) / 2;

	// Borders for side panels
	static Border sidePaddingBorder = BorderFactory.createEmptyBorder
			(sidePaddingValue, sidePaddingValue, sidePaddingValue, sidePaddingValue); // Top left bottom right
	static Border sideLineBorder = BorderFactory.createMatteBorder
			(100, 20, 100, 20, Color.BLACK); // Top left bottom right

	// Borders for center panel
	static Border centerPaddingBorder = BorderFactory.createEmptyBorder
			(centerPaddingValue, centerPaddingValue, centerPaddingValue, centerPaddingValue);
	static Border centerLineBorder = BorderFactory.createMatteBorder
			(20, 20, 20, 20, Color.BLACK);

	// A compound border combines two borders
	// Final border for side panels
	static Border sideBorder = new CompoundBorder(
			sideLineBorder, sidePaddingBorder);
	// Final border for center panel
	static Border centerBorder = new CompoundBorder(
			centerLineBorder, centerPaddingBorder);

	// Other components
	static int textDisplayCharacterLimit = centerPanelWidth / 22;
	static JPanel levelPanel;
	static JPanel timePanel;
	static JPanel centerPanel;
	static JLayeredPane textDisplay;
	static JTextArea generatedText;
	static JTextArea typingArea;

}
