/**
 * Set time on timer.
 */
public class Timer {

    public static void setTime(int seconds) {

        // Reset test if the test hasn't finished.
        if (Global.testActive) {
            Global.testActive = false;
            TypingTest.reset();
        }

        // If typing test ended, remove the WPM line graph, allow user to type again, and generate new text.
        if (Global.testEnded) {
            Global.textDisplay.remove(Global.resultsPanel);
            Global.typingArea.setEditable(true);
            Global.testEnded = false;
            TextGenerator.setDifficulty(Global.testLevel, true, true);
        }

        // If the test hasn't finished, stop timer countdown.
        if (Global.testActive && !Threads.checkTestStartedThread.isAlive()) {

            // Stop the thread that runs the timer.
            Threads.checkTestStartedThread.interrupt();

            // Set to false so that timer does not keep counting down after thread is started.
            Global.testActive = false;

            // Restart thread.
            Threads.startCheckTestStartedThread();
        }

        // Set number on timer and update timer variables
        Global.secondsRemaining = seconds;
        Global.testDuration = seconds;
        Global.timeDisplay.setText(Integer.toString(seconds));
    }
}
