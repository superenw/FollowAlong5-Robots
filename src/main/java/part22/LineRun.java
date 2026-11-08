
package part22;

import mbot.*;

// Guide: GUIDE.md in this folder, steps 7–9
//
// SECTION A — FOLLOW ALONG: Makes a Rover follow
// the tape track until it completes one lap.
//
// SECTION B — COMMENTS: Explain what each line does.

@MBotLab(world = "line-track")
// This class runs the rover on the tape track.
public class LineRun {
    // This main method starts the program.
    public static void main(String[] args) {
        // Make a new rover and give it the name Tracker.
        Rover rover = new Rover("Tracker");
        // Make Tracker follow the tape for 400 steps.
        Rover rover = new Rover("Tracker");
        rover.followLine(400);
        // Print a message when the rover is halfway around.
        System.out.println("Halfway round");
        // Make Tracker follow the tape for another 325 steps.
        rover.followLine(325);
        // Print a message when the rover finishes its lap.
        System.out.println(rover + " finished a lap");
    }
}
