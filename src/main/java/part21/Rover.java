package part21;

import mbot.*;
// Guide: GUIDE.md in this folder, steps 2–8
//
// Part 21 — composition: a Rover HAS-A Chassis and HAS-AN Ultrasonic.
//
// SECTION A — FOLLOW ALONG: type the Rover class from the guide in this class.
//    Leave the "package part21;" line, the "import mbot.*;" line and the class line alone.
//    Type everything else yourself.
//
// SECTION B — COMMENTS: when you finish, put a // comment ABOVE every line of code,
//    saying in YOUR OWN WORDS what that line does.
//
// SECTION C — STRETCH B adds a LineSensor and two methods to this class.

// Creates the Rover class that is made from other objects
public class Rover {
    // Stores the name that belongs to this rover
    private String name;
    // Stores the Chassis object that controls the rover's wheels and movement
    private Chassis base;
    // Stores the Ultrasonic sensor the rover uses to check distance
    private Ultrasonic eyes;
    // Creates a Rover and builds the parts it needs
    public Rover(String name) {
        // Saves the name passed into the constructor as this rover's name
        this.name = name;
        // Creates a new chassis and stores it as this rover's base
        this.base = new Chassis();
        // Creates an ultrasonic sensor and connects it to the rover's chassis
        this.eyes = new Ultrasonic(base);
    }

    // Checks whether something is closer than the distance given in centimeters
    public boolean somethingAhead(double cm) {
        // Reads the ultrasonic sensor and returns true if the distance is less than cm
        return eyes.distance() < cm;
    }
    // Makes the rover drive forward until something is within 20 centimeters
    public void driveUntilBlocked() {
        // Keeps repeating while there is not something closer than 20 centimeters
        while (!somethingAhead(20)) {
            // Moves the chassis forward 5 centimeters each time through the loop
            base.straight(5);
        }
    }
    // Changes how a Rover object is displayed when it is printed
    public String toString() {
        // Returns the rover's name followed by a short description
        return name + " the rover";
    }
}