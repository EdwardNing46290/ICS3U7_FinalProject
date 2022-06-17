/**
 * Set time on timer.
 */

public class Timer {

    public static void setTime(int seconds) {
        try {
            Global.textDisplay.remove(Global.resultsPanel);
            Global.typingArea.setEditable(true);
        } catch (Exception e) {}

        // Stop timer countdown if it's counting down
        if (Global.testActive && !Threads.checkTestStartedThread.isAlive()) {
            Threads.checkTestStartedThread.interrupt();
            Global.testActive = false;
            Threads.startCheckTestStartedThread();
        }

        // Start checking if user started the test
        Global.testActive = false;

        // Reset user-typed text
        Global.typingArea.setText("");

        // Set number on timer and update timer variables
        Global.secondsRemaining = seconds;
        Global.testDuration = seconds;
        Global.timeDisplay.setText(Integer.toString(seconds));
        float startTime = Global.currentTime;
        float endTime = Global.currentTime + seconds;
    }
}
