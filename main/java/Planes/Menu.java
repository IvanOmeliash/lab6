package Planes;

import Planes.Command.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {

    private final Map<Integer, Command> commandMap = new HashMap<>();

    public Menu(PlaneService planeService) {
        commandMap.put(1, new AddPlaneCommand(planeService));
        commandMap.put(2, new ShowPlanesCommand(planeService));
        commandMap.put(3, new DeletePlaneCommand(planeService));
        commandMap.put(4, new TotalCapacityCommand(planeService));
        commandMap.put(5, new TotalPayloadCommand(planeService));
        commandMap.put(6, new SortCommand(planeService));
        commandMap.put(7, new FindCommand(planeService));
    }

    public void menu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu:");
            System.out.println("0. Exit");
            for (var element : commandMap.entrySet()) {
                System.out.println(element.getKey() + ". " + element.getValue().getDescription());
            }

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            if (choice == 0) {
                System.out.println("Exiting...");
                scanner.close();
                return;
            }

            Command command = commandMap.get(choice);
            if (command != null) {
                command.execute();
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
