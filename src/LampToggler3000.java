import java.util.ArrayList;
import java.util.Scanner;

public class LampToggler3000 {

    static ArrayList<Lamp> lamps;

    public static void main(String[] args) {
        LampToggler3000 application = new LampToggler3000();
        application.start();
    }

    public void start() {
        System.out.println("Welcome to LampToggler3000");
        System.out.println("The lamp toggle application to end all your lamp toggle application needs!");

        lamps = new ArrayList<>();

        printHelp();

        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            String input = scanner.nextLine();
            String command = input.substring(0, 1);
            String lampname = "";
            if (input.contains(" ")) {
                lampname = input.substring(input.indexOf(" ") + 1);
            }
            switch (command) {
                case "q" -> running = false;
                case "l" -> listLamps();
                case "a" -> addLamp(lampname);
                case "r" -> removeLamp(lampname);
                case "t" -> toggleLamp(lampname);
                case "?" -> getLampStatus(lampname);
                default -> {
                    System.out.println("Unknown command: " + command);
                    printHelp();
                }
            }
        }
    }

    public void printHelp() {
        System.out.println("Commands available are:");
        System.out.println("""
                a 'lampname' \t - add a new lamp to the application
                r 'lampname' \t - remove an existing lamp
                t 'lampname' \t - toggle an existing lamp (turn on or off)
                ? 'lampname' \t - ask about the status for an existing lamp
                l \t - list all lamps with their names and status
                q \t - quits the application (but why would you??)
                """);
    }

    public void listLamps() {
        System.out.println("These lamps are currently in the system: ");
        // List lamps and their status
        if (lamps.size() > 0) {
            for (Lamp lamp : lamps) {
                System.out.println(lamp);
            }
        } else {
            System.out.println("There are no lamps yet");
        }
    }

    public void addLamp(String lampName) {
        // create new lamp with the name lampName
        Lamp tmp = new Lamp(lampName);

        // add the new lamp to the list of lamps
        lamps.add(tmp);

    }

    public void removeLamp(String lampName) {
        // Find the lamp with the given name in the list of lamps
        Lamp tmp = getLampFromName(lampName);

        // Remove that lamp from the list of lamps (if it exists)
        if (tmp != null) lamps.remove(tmp);

        // Output error-message if lamp doesn't exist
        if (tmp == null) System.out.println("There is no lamp with that name");
    }

    public void toggleLamp(String lampName) {
        // Find the lamp with the given name in the list of lamps
        Lamp tmp = getLampFromName(lampName);

        // Toggle the status of that lamp
        if (tmp != null) tmp.pushButton();

        // Output error-message if lamp doesn't exist
        if (tmp == null) System.out.println("There is no lamp with that name");
    }

    public void getLampStatus(String lampName) {
        // Find the lamp with the given name in the list of lamps
        Lamp tmp = getLampFromName(lampName);

        // Get the status of that lamp, and print it
        if (tmp != null) {
            if (tmp.isLampOn()) {
                System.out.println("Lamp is on");
            } else {
                System.out.println("Lamp is off");
            }
        }

        // Output error-message if lamp doesn't exist
        if (tmp == null) System.out.println("There is no lamp with that name");
    }

    public static Lamp getLampFromName(String lampName){
        for (Lamp lamp: lamps) {
            if (lamp.getName().equals(lampName)) return lamp;
        }
        return null;
    }
}
