import javax.swing.*;
import java.io.*;
import java.util.Arrays;
import java.util.ArrayList;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 * Methods to generate and display test results.
 */
public class TestResult {

    /** Display results */
    public static void endTest() throws IOException {

        // Stop user from typing.
        Global.typingArea.setEditable(false);

        // Calculate score
        int wpm = TestResult.calculateWPM();

        // Display results
        Global.textDisplay.add(resultsPanel(), 0);

        TypingTest.reset();

        // Save score
        FileWriter fileWriter = new FileWriter("scores.txt", true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(wpm + "\n");
        bufferedWriter.close();

        // Calculate average score
        FileReader fileReader = new FileReader("scores.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        ArrayList<Integer> scores = new ArrayList<>();
        String score;
        while ((score = bufferedReader.readLine()) != null) {
            scores.add(Integer.parseInt(score));
        }
        int average = 0;
        for (int x : scores) {
            average += x;
        }
        average /= scores.size();
        System.out.println(wpm + " " + scores.size());

        // Display score and average
        Global.timeDisplay.setText("WPM: " + wpm + " AVG: " + average);

    }

    /** Build results panel */
    public static JPanel resultsPanel() {
        JPanel resultsPanel = new JPanel();
        Global.resultsPanel = resultsPanel;

        // Format
        resultsPanel.setBounds(0, 0, Global.CENTER_PANEL_WIDTH, Global.Screen.HEIGHT / 2);

        // WPM line graph
        ChartPanel graphDisplay = createGraphDisplay();
        resultsPanel.add(graphDisplay);

        return resultsPanel;
    }

    /** Create line graph */
    public static ChartPanel createGraphDisplay() {
        DefaultCategoryDataset WPMStats = new DefaultCategoryDataset( );

        // Convert Global.wpmUpdates into data for graph.
        for (int i = 0; i < Global.wpmUpdates.size(); i++) {
            WPMStats.addValue(Global.wpmUpdates.get(i) , "", Integer.toString(i + 1));
        }

        JFreeChart wpmLineGraph = ChartFactory.createLineChart(
                "WPM during test",  // Title
                "Time",             // X axis label
                "WPM",              // Y axis label
                WPMStats,           // Data to be plotted
                PlotOrientation.VERTICAL,
                false, false, false // Legend, tooltips, URLs
        );

        return new ChartPanel(wpmLineGraph);
    }

    /** Calculate user WPM */
    public static int calculateWPM() {

        // Do not calculate WPM if user has not typed anything.
        if (Global.currentUserTextAsString == null) {
            return 0;
        }

        else {

            // Get all user-typed text (deleted text + current text)
            String allUserTextAsString = Global.deletedUserText + Global.currentUserTextAsString;
            String[] words = allUserTextAsString.split(" ");
            ArrayList<String> allUserText = new ArrayList<>(Arrays.asList(words));

            // Remove whitespace
            allUserText.removeIf(word -> word.equals(" "));
            for (int i = 0; i < allUserText.size(); i++) {
                allUserText.set(i, allUserText.get(i).strip());
            }

            // Compare user-typed text to generated text and find number of correctly typed words.
            int indexLimit = Math.min(allUserText.size(), Global.generatedText.size());
            int correctWords = 0;
            for (int i = 0; i < indexLimit; i++) {
                if (allUserText.get(i).equals(Global.generatedText.get(i))) {
                    correctWords++;
                }
            }

            // Calculate WPM
            return (int) ( (60.0 / (Global.testDuration - Global.secondsRemaining) * correctWords) );
        }
    }

    /** Store current WPM for line graph data */
    public static void storeWPM() {
        Global.wpmUpdates.add(calculateWPM());
    }
}
