
package part23;

import mbot.*;

@MBotLab(world = "junctions")

// Runs the robot through the corridor.
public class Explore {
    // Starts the program.
    public static void main(String[] args) {
        // Creates a Scout named Pathfinder.
        Scout scout = new Scout("Pathfinder");
        // Repeats the driving process for three sections.
        for (int leg = 1; leg <= 3; leg++) {
            // Drives forward until an obstacle is close.
            int moves = scout.driveUntilBlocked();
            // Prints how many movements the robot made.
            System.out.println("Leg " + leg + ": " + moves + " moves");
            // Checks if the robot has more sections to complete.
            if (leg < 3) {
                // Finds an open direction and turns toward it.
                scout.turnTowardOpenSide();
            }
        }
        // Prints a message after completing the route.
        System.out.println(scout + " reached the goal");
    }
}
