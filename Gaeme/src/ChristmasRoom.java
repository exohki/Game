import java.util.Scanner;

public class ChristmasRoom implements Room {
    private String description;

    public ChristmasRoom(String description) {
        this.description = description;
    }

    @Override
    public void enter() {
        System.out.println("You find yourself in a Christmas-themed room. " + description);
    }

    @Override
    public int interact() {
        System.out.println("It's a festive atmosphere!");
        System.out.println("What do you want to do?");
        System.out.println("1. Admire the decorations");
        System.out.println("2. Listen to Christmas music");

        int choice = getUserChoice();

        switch (choice) {
            case 1:
                System.out.println("You take a moment to admire the beautiful decorations. You earn 1 point.");
                return 1;
            case 2:
                System.out.println("You enjoy listening to the cheerful Christmas music. You earn 1 point.");
                return 1;
            default:
                System.out.println("Invalid choice. No points earned.");
                return 0;
        }
    }

    private int getUserChoice() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your choice: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            System.out.print("Enter your choice: ");
            scanner.next();
        }
        return scanner.nextInt();
    }
}