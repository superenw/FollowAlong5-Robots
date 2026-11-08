package part21;

import mbot.*;

@MBotLab(world = "parking")
public class Stretch {

    public static void main(String[] args) {

        /* MY GUESS:
           Write what you think the first three
           print statements will display.
        */

        // Create a rover named Ada
        Rover ada = new Rover("Ada");
        // Print information about Ada
        System.out.println(ada);
        // Check if something is closer than 500 cm
        System.out.println(ada.somethingAhead(500));
        // Check if something is closer than 5 cm
        System.out.println(ada.somethingAhead(5));
        // Drive until the rover finds tape
        ada.driveToTape();
        // Print when the rover finds tape
        System.out.println("Found the tape");
        // Move forward another 30 cm
        ada.forward(30);
        // Print that Ada is parked
        System.out.println(ada + " is parked");
    }
}