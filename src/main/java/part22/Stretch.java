
package part22;

import mbot.*;

// Guide: GUIDE.md in this folder, steps 7–9
//
// SECTION C — Stretch A and Stretch B

@MBotLab(world = "line-track")
public class Stretch {

    public static void main(String[] args) {

        /* MY GUESS:
           Write your prediction for each number:
           6:
           12:
           3:
           0:

           Also identify which probes see tape.
        */

        // Store the four sensor readings.
        int[] readings = {6, 12, 3, 0};
        // Check each reading.
        for (int s : readings) {
            // Check if the tape is on the left.
            if (s == 4 || s == 8 || s == 12) {
                System.out.println(s + ": turn left");
                // Check if the tape is on the right.
            } else if (s == 1 || s == 2 || s == 3) {
                System.out.println(s + ": turn right");
                // Check if the rover lost the tape.
            } else if (s == 0) {
                System.out.println(s + ": lost it");
                // Otherwise, keep going straight.
            } else {
                System.out.println(s + ": straight");
            }
        }

        // Create a Lapper with a rover named Loop.
        Lapper lapper = new Lapper(new Rover("Loop"));

        // Make the rover complete two laps.
        lapper.laps(2);

        // MY ANSWER:
        // Why does Lapper receive a Rover instead
        // of creating one in its constructor?
    }
}

// This class manages the rover's laps.
class Lapper {
    // Store the rover used for the laps.
    private Rover rover;
    // Keep track of completed laps.
    private int done;
    // Receive the rover from another class.
    public Lapper(Rover rover) {
        this.rover = rover;
        this.done = 0;
    }
    // Make the rover complete the requested laps.
    public void laps(int n) {
        // Repeat until all laps are completed.
        for (int i = 0; i < n; i++) {
            // Follow the tape for one lap.
            rover.followLine(725);
            // Count the completed lap.
            done++;
            // Display the lap number.
            System.out.println("Lap " + done + " done");
        }
    }
}
