
package part22;

import mbot.*;
// This class creates a robot with sensors and movement skills.
public class Rover {
    // Stores the robot's name.
    private String name;
    // Controls the robot's wheels and movement.
    private Chassis base;
    // Detects how far away objects are.
    private Ultrasonic eyes;
    // Detects tape underneath the robot.
    private LineSensor floor;
    // Remembers if the tape was last seen on the left.
    private boolean lineWasLeft;
    // Builds a new rover using the name provided.
    public Rover(String name) {
        // Saves the name of the rover.
        this.name = name;
        // Creates the main body of the robot.
        this.base = new Chassis();
        // Connects the distance sensor to the robot.
        this.eyes = new Ultrasonic(base);
        // Connects the line sensor to the robot.
        this.floor = new LineSensor(base);
    }

    // Moves forward until something gets too close.
    public int driveUntilBlocked(double cm) {
        // Counts how many movements the robot makes.
        int moves = 0;
        // Keeps moving while the path is clear.
        while (eyes.distance() > cm) {
            // Moves the robot forward 5 centimeters.
            base.straight(5);
            // Adds one to the movement counter.
            moves++;
        }
        // Gives back the total number of movements.
        return moves;
    }
    // Moves the rover to the left around an obstacle.
    public void goAroundLeft(double sideways) {
        // Turns the robot left 90 degrees.
        base.turnLeft(90);
        // Moves forward the requested distance.
        base.straight(sideways);
        // Turns right to face the original direction.
        base.turnRight(90);
    }

    // Uses different movements to reach the goal.
    public void reachGoal() {
        // Moves toward the first obstacle and counts moves.
        int first = driveUntilBlocked(15);
        // Prints how many moves were made.
        System.out.println("Blocked after " + first + " moves. Going round.");
        // Moves left to get around the obstacle.
        goAroundLeft(60);
        // Drives forward until the next obstacle.
        int second = driveUntilBlocked(15);
        // Prints when the robot reaches the far wall.
        System.out.println("Blocked after " + second + " moves. That is the far wall.");
        // Turns right toward the goal.
        base.turnRight(90);
        // Moves forward 50 centimeters into the goal.
        base.straight(50);
    }

    // Makes the robot follow a line using its sensor.
    public void followLine(int steps) {
        // Repeats the movement for the requested steps.
        for (int i = 0; i < steps; i++) {
            // Reads the number from the line sensor.
            int s = floor.status();
            // Checks if the tape is on the left side.
            if (s == 4 || s == 8 || s == 12) {
                // Turns left to follow the tape.
                base.turnLeft(4);
                // Remembers that the tape was on the left.
                lineWasLeft = true;
                // Checks if the tape is on the right side.
            } else if (s == 1 || s == 2 || s == 3) {
                // Turns right to follow the tape.
                base.turnRight(4);
                // Remembers that the tape was on the right.
                lineWasLeft = false;
                // Checks if the sensor cannot find any tape.
            } else if (s == 0) {
                // Checks which side the tape was last seen on.
                if (lineWasLeft) {
                    // Turns left to search for the tape again.
                    base.turnLeft(4);
                    // Searches right if the tape was not last seen on the left.
                } else {
                    // Turns right to look for the missing tape.
                    base.turnRight(4);
                }
                // Moves forward when no correction is needed.
            } else {
                // Drives straight forward 1 centimeter.
                base.straight(1);
            }
        }
    }
    // Changes the rover object into readable text.
    public String toString() {
        // Returns the name with a short description.
        return name + " the rover";
    }
}
