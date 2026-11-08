package part24;

import mbot.*;

// This robot adds flashing lights to its turns.
public class FlashyBot extends MBot2 {

    // Creates a new FlashyBot.
    public FlashyBot() {

        // Builds the original MBot2 robot.
        super();
    }

    // Replaces the normal left-turning method.
    @Override
    public void turnLeft(double degrees) {

        // Prints the direction and amount of turning.
        System.out.println("Flash! Turning left " + degrees);

        // Turns the first light blue.
        turnLedOn(1, 0, 0, 255);

        // Uses the original method to turn left.
        super.turnLeft(degrees);

        // Turns the light off after turning.
        turnLedOff(1);
    }

    // Replaces the normal right-turning method.
    @Override
    public void turnRight(double degrees) {

        // Prints the direction and amount of turning.
        System.out.println("Flash! Turning right " + degrees);

        // Turns the first light green.
        turnLedOn(1, 0, 255, 0);

        // Uses the original method to turn right.
        super.turnRight(degrees);

        // Turns the light off after turning.
        turnLedOff(1);
    }

    // Gives FlashyBot its own mission.
    @Override
    public void run() {

        // Repeats the movement four times to make a square.
        for (int i = 0; i < 4; i++) {

            // Moves forward 40 centimeters.
            straight(40);

            // Turns left 90 degrees after moving.
            turnLeft(90);
        }
    }
}
