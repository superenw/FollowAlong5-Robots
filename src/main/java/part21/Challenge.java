package part21;

import mbot.*;

// Guide: GUIDE.md in this folder (the constructor, steps 2–4; the while loop, step 7)
//
// SECTION D — Challenge. A robot class with a constructor and two methods.
// The test in src/test/java/part21/ChallengeTest.java checks all three.
// Change only the lines marked YOUR CODE. The README explains each one.

public class Challenge {

    private Chassis base;
    private Ultrasonic eyes;
    private LineSensor floor;

    // Build the robot. Make the chassis FIRST. Then plug both sensors into it.
    public Challenge() {
        base = new Chassis();
        eyes = new Ultrasonic(base);
        floor = new LineSensor(base);
    }

    // Drive forward 5 cm at a time until the distance is less than 15 cm.
    // Return how many moves the robot made.
    public int stepsToWall() {
        int steps = 0;

        while (eyes.distance() >= 15) {
            base.straight(5);
            steps++;
        }

        return steps;
    }

    // Drive forward until the line sensor detects tape.
    // Then move another 30 cm into the parking box.
    public void park() {
        while (!floor.seesTape()) {
            base.straight(2);
        }

        base.straight(30);
    }
}
