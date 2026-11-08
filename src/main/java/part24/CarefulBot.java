package part24;

import mbot.*;
// This robot extends MBot2 and adds safer driving.
public class CarefulBot extends MBot2 {
    // Creates a new CarefulBot.
    public CarefulBot() {
        // Builds the original MBot2 robot.
        super();
    }
    // Replaces the normal straight method.
    @Override
    public void straight(double cm) {
        // Checks if there is enough room to move safely.
        if (readUltrasonic() > cm + 20) {
            // Uses the original method to move forward.
            super.straight(cm);
            // Runs when the robot is too close to something.
        } else {
            // Turns the first light red.
            turnLedOn(1, 255, 0, 0);
            // Prints why the robot cannot move.
            System.out.println("CarefulBot: not driving " + cm + " cm, too close");
        }
    }
    // Replaces the robot's original run method.
    @Override
    public void run() {
        // Tries to move forward five times.
        for (int i = 0; i < 5; i++) {
            // Attempts to move forward 40 centimeters.
            straight(40);
        }
    }
}
