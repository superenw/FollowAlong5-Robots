
package part23;

import mbot.*;

// Guide: GUIDE.md in this folder, steps 1–4
//
// SECTION C — Stretch A and Stretch B

@MBotLab(world = "color-zones")
public class Stretch {

    /* STRETCH A — MY GUESSES:
       1. super() -
       2. eye.color() -
       3. turnLedOn(1, 255, 0, 0) -
       4. straight(5) -
       5. showColor() -
    */

    public static void main(String[] args) {

        // Create a new Painter robot.
        Painter p = new Painter();
        // Check if the robot is a Painter.
        System.out.println(p instanceof Painter);
        // Check if the robot is an MBot2.
        System.out.println(p instanceof MBot2);
        // Check if the robot is a Chassis.
        System.out.println(p instanceof Chassis);
        // Drive through the colored areas until red.
        p.driveToRed();
        /* STRETCH B — MY ANSWER:
           Why do Scout and Painter have different
           sensor fields?
           Write your answer here.
        */
    }
}

// This class creates a robot that detects colors.
class Painter extends MBot2 {
    // Stores the robot's color sensor.
    private ColorSensor eye;
    // Creates the Painter robot.
    Painter() {
        // Builds the MBot2 part first.
        super();
        // Connects the color sensor to the robot.
        eye = new ColorSensor(this);
    }
    // Changes the robot's light based on the color.
    void showColor() {
        // Reads the color underneath the robot.
        String c = eye.color();
        // Checks if the color is red.
        if (c.equals("red")) {
            turnLedOn(1, 255, 0, 0);
            // Checks if the color is green.
        } else if (c.equals("green")) {
            turnLedOn(1, 0, 255, 0);
            // Checks if the color is blue.
        } else if (c.equals("blue")) {
            turnLedOn(1, 0, 0, 255);
            // Checks if the color is yellow.
        } else if (c.equals("yellow")) {
            turnLedOn(1, 255, 200, 0);
            // Turns off the light for other colors.
        } else {
            turnLedOff(1);
        }
    }

    // Drives forward until the robot detects red.
    void driveToRed() {
        // Remembers the previous color.
        String last = "";
        // Keeps moving while the color is not red.
        while (!eye.color().equals("red")) {
            // Reads the current color.
            String c = eye.color();
            // Checks if the color has changed.
            if (!c.equals(last)) {
                // Prints the new color.
                System.out.println("Now on " + c);
                // Saves the color for the next check.
                last = c;
            }
            // Updates the robot's light.
            showColor();
            // Moves forward 5 centimeters.
            straight(5);
        }
        // Updates the light when red is found.
        showColor();
        // Prints when the robot stops.
        System.out.println("Stopped on red");
    }
}
