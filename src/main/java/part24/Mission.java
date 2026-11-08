
package part24;

import mbot.*;

@MBotLab(world = "wall-ahead")

// This class runs a mission using different robots.
public class Mission {
    // Runs a mission for any robot that is an MBot2.
    public static void mission(MBot2 bot) {
        // Prints when the mission begins.
        System.out.println("Mission start");
        // Runs the selected robot's own mission.
        bot.run();
        // Prints when the mission ends.
        System.out.println("Mission done");
    }
    // Starts the program.
    public static void main(String[] args) {
        // Selects which robot to use.
        int pick = 1;
        // Creates a variable that can hold any MBot2 robot.
        MBot2 bot;
        // Checks if CarefulBot was selected.
        if (pick == 1) {
            // Creates a CarefulBot.
            bot = new CarefulBot();
            // Checks if FlashyBot was selected.
        } else if (pick == 2) {
            // Creates a FlashyBot.
            bot = new FlashyBot();
            // Selects a regular MBot2 otherwise.
        } else {
            // Creates a normal MBot2.
            bot = new MBot2();
        }
        // Starts the mission for the selected robot.
        mission(bot);
    }
}
