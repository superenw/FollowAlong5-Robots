package part21;

import mbot.*;

// Guide: GUIDE.md in this folder, steps 4–9
//
// SECTION A — FOLLOW ALONG: type the main method from the guide in this class.
//    It makes a Rover and drives it until it is close to the wall.
//    Leave the package, import, @MBotLab and class lines alone. Type everything else.
//
// SECTION B — COMMENTS: put a // comment ABOVE every line of code, in YOUR OWN WORDS.

@MBotLab(world = "wall-ahead")
public class FollowAlong {
    // Starts the program
    public static void main(String[] args) {
        // Creates a Rover named Scout, which also creates its chassis and ultrasonic sensor
        Rover scout = new Rover("Scout");
        // Prints the rover's name and says it is ready
        System.out.println(scout + " is ready");
        // Tells the rover to keep driving until something is closer than 20 centimeters
        scout.driveUntilBlocked();
        // Prints a message after the rover stops near the wall
        System.out.println(scout + " stopped. Something is less than 20 cm ahead.");
    }
}