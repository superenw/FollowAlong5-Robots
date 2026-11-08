
package part22;

import mbot.*;

// Guide: GUIDE.md in this folder, steps 3–6
//
// SECTION A — FOLLOW ALONG
// SECTION B — COMMENTS

@MBotLab(world = "obstacles")
// This class controls the rover during the obstacle course.
public class ObstacleRun {
    // This method starts the program.
    public static void main(String[] args) {
        // Create a new rover named Dash.
        Rover rover = new Rover("Dash");
        // Tell Dash to move around the obstacles and reach the goal.
        rover.reachGoal();
        // Print a message when Dash reaches the goal.
        System.out.println(rover + " reached the goal");
    }
}
