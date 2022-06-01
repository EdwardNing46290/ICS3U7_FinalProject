/**
 * Contains variables that are used across several classes.
 */
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import java.awt.*;

public class Global {

	// Fullscreen
	static Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
	static int X = screen.width - 200; // Subtract a bit to make sure
	static int Y = screen.height - 100; // that the entire window is visible.

	// Padding values determine the size of the gap between buttons and the edges of the panel.
	static int centerPaddingValue = 80;
	static int sidePaddingValue = 80;

	// Panel size
	static int centerPanelWidth = X/2;
	static int sidePanelWidth = (X - centerPanelWidth) / 2;

	// Borders for side panels
	static Border sidePaddingBorder = BorderFactory.createEmptyBorder
			(sidePaddingValue, sidePaddingValue, sidePaddingValue, sidePaddingValue); // Top left bottom right
	static Border sideLineBorder = BorderFactory.createMatteBorder
			(100, 20, 100, 20, Color.BLACK);
	// A compound border combines two borders
	static Border sideBorder = new CompoundBorder(
			sideLineBorder, sidePaddingBorder);

	// Borders for center panel
	static Border centerPaddingBorder = BorderFactory.createEmptyBorder
			(centerPaddingValue, centerPaddingValue, centerPaddingValue, centerPaddingValue); // Top left bottom right
	static Border centerLineBorder = BorderFactory.createMatteBorder
			(20, 20, 20, 20, Color.BLACK); // Top left bottom right
	// A compound border combines two borders
	static Border centerBorder = new CompoundBorder(
			centerLineBorder, centerPaddingBorder);

}