/**
 * @version Wed June 3, 9PM
 *
 * Variables that are used often in other classes.
 * Includes variables for:
 * - Screen and panel size
 * - Fonts
 * - Padding and borders
 * - Other components, such as panels
 */
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import java.awt.*;

public class Global {

	// Screen size
	static Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
	static int X = screen.width - 200; // Subtract to make sure that the entire window is visible.
	static int Y = screen.height - 100;

	// Panel size
	static int centerPanelWidth = X / 2;
	static int sidePanelWidth = (X - centerPanelWidth) / 2;

	// Font
	static int typingAreaFontScale = 40;
	static Font typingAreaFont = new Font(Font.MONOSPACED, Font.PLAIN, Y / typingAreaFontScale);

	// Padding values determine the size of the gap between components and panel edges.
	static int textDisplayPaddingScale = 30;
	static int textDisplayPaddingValue = Y / textDisplayPaddingScale;
	static int sidePaddingValueScale = 15;
	static int sidePaddingValue = Y / sidePaddingValueScale;

	// Borders for side panels
	static Border sidePaddingBorder = BorderFactory.createEmptyBorder
			(sidePaddingValue, sidePaddingValue, sidePaddingValue, sidePaddingValue); // Top left bottom right
	static Border sideLineBorder = BorderFactory.createMatteBorder
			(100, 20, 100, 20, Color.BLACK); // Top left bottom right
	// Final border for side panels
	static Border sideBorder = new CompoundBorder(
			sideLineBorder, sidePaddingBorder);

	// Borders for center panel and its components
	static Border centerLineBorder = BorderFactory.createMatteBorder
			(20, 20, 20, 20, Color.BLACK);
	static Border textDisplayPaddingBorder = BorderFactory.createEmptyBorder
			(textDisplayPaddingValue, textDisplayPaddingValue, textDisplayPaddingValue, textDisplayPaddingValue);

	// Other components
	static int textDisplayCharacterLimit = centerPanelWidth / 22;
	static JPanel levelPanel;
	static JPanel timePanel;
	static JPanel centerPanel;
	static JLayeredPane textDisplay;
	static JTextArea generatedText;
	static JTextArea typingArea;

}
