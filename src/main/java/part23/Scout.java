
package part23;

import mbot.*;

// Scout is a type of MBot2 and can use its methods.
public class Scout extends MBot2 {
    // Stores the robot's name.
    private String name;
    // Stores the sensor that checks different directions.
    private Scanner scanner;
    // Creates a Scout with a name.
    public Scout(String name) {
        // Builds the MBot2 part of the robot first.
        super();
        // Saves the name given to the robot.
        this.name = name;
        // Connects the scanner to this robot.
        this.scanner = new Scanner(this);
    }
    // Drives until the robot gets close to something.
    public int driveUntilBlocked() {
        // Counts how many times the robot moves.
        int moves = 0;
        // Keeps driving while objects are over 25 cm away.
        while (readUltrasonic() > 25) {
            // Moves forward 5 centimeters.
            straight(5);
            // Adds one to the movement counter.
            moves++;
        }
        // Returns the total number of movements.
        return moves;
    }
    // Finds which direction has the most open space.
    public int openestIndex() {
        // Gets seven distance readings from the scanner.
        double[] d = scanner.scan();
        // Starts by treating the first reading as the best.
        int best = 0;
        // Checks the remaining readings.
        for (int i = 1; i < d.length; i++) {
            // Checks if this distance is greater than the best.
            if (d[i] > d[best]) {
                // Saves the position of the larger reading.
                best = i;
            }
        }
        // Returns the position of the greatest distance.
        return best;
    }
    // Turns toward the direction with the most space.
    public void turnTowardOpenSide() {
        // Finds the index of the most open direction.
        int i = openestIndex();
        // Checks if the open direction is on the left.
        if (Scanner.ANGLES[i] > 0) {
            // Turns the robot left 90 degrees.
            turnLeft(90);
            // Otherwise, turn toward the right.
        } else {
            // Turns the robot right 90 degrees.
            turnRight(90);
        }
    }
    // Makes the robot's name readable when printed.
    public String toString() {
        // Returns the robot's name and description.
        return name + " the scout";
    }
}
