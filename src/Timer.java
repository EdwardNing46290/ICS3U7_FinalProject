/**
 * Shows user time remaining before the typing test ends.
 */

public class Timer {
    public static void setTime(int seconds) {

        // Stop timer countdown, if it started
        if (Global.testActive && !Threads.checkTestStartedThread.isAlive()) {
            Threads.checkTestStartedThread.interrupt();
            Global.testActive = false;
            Threads.startCheckTestStarted();
        }

        // Start checking if user started the test
        Global.testActive = false;

        // Reset user text
        Global.typingArea.setText("");

        // Set timer and timer variables
        Global.secondsRemaining = seconds;
        Global.testDuration = seconds;
        Global.timeDisplay.setText(Integer.toString(seconds));
        float startTime = Global.currentTime;
        float endTime = Global.currentTime + seconds;
    }
}
