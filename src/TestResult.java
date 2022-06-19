/**
 * Find how many words user typed correctly.
 */
import javax.swing.*;
import java.util.Arrays;
import java.util.ArrayList;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class TestResult {

    /** Store current WPM for line graph data */
    public static void storeWPM() {
        updateWPM();
        if (Global.testDuration - Global.secondsRemaining != 0) {
            Global.wpmUpdates.add((int) (60.0 / (Global.testDuration - Global.secondsRemaining) * Global.correctWords));
        }
    }

    // Display results: add resultsPanel to centerPanel
    public static void endTest() {
        updateWPM();
        Global.textDisplay.add(resultsPanel(), 0);
    }

    // Build results panel
    public static JPanel resultsPanel() {
        JPanel resultsPanel = new JPanel();
        Global.resultsPanel = resultsPanel;

        // Format
        resultsPanel.setBounds(0, 0, Global.centerPanelWidth, Global.Y/2);

        // Components
        ChartPanel graphDisplay = createGraphDisplay();
        resultsPanel.add(graphDisplay);

        return resultsPanel;
    }

    // Create line graph
    public static ChartPanel createGraphDisplay() {
        DefaultCategoryDataset WPMStats = new DefaultCategoryDataset( );

        for (int i = 0; i < Global.wpmUpdates.size(); i++) {
            WPMStats.addValue(Global.wpmUpdates.get(i) , "", Integer.toString(i));
        }

        JFreeChart wpmLineGraph = ChartFactory.createLineChart(
                "WPM during test", // Title
                "Time", // X axis label
                "WPM", // Y axis label
                WPMStats, // Data to be plotted
                PlotOrientation.VERTICAL,
                false, false, false // legend, tooltips, urls
        );

        return new ChartPanel(wpmLineGraph);
    }

    // Convert Global.wpmUpdates into data for graph
    private static DefaultCategoryDataset createWPMStats() {
        DefaultCategoryDataset WPMStats = new DefaultCategoryDataset( );
        String series = "series";

        for (int i = 0; i < Global.wpmUpdates.size(); i++) {
            WPMStats.addValue(Global.wpmUpdates.get(i) , series , Integer.toString(i));
        }

        return WPMStats;
    }

    // Calculate user WPM
    public static void updateWPM() {
        String[] splitText = Global.typingArea.getText().split(" ");
        if (!Global.typingArea.getText().equals("")) {
            ArrayList<String> userText = new ArrayList<>(Arrays.asList(splitText));

            int indexLimit = Math.min(userText.size(), Global.textCache.size());
            int score = 0;

            // Check how many words are correctly typed and add to WPM score for each correct word
            for (int i = 0; i < indexLimit; i++) {
                if (userText.get(i).equals(Global.textCache.get(i))) {
                    score++;
                }
            }

            // Calculate WPM
            Global.correctWords = score;
        }
    }
}
