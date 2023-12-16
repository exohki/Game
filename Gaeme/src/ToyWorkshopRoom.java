import java.util.Scanner;

public class ToyWorkshopRoom implements Room {
    private String description;

    public ToyWorkshopRoom(String description) {
        this.description = description;
    }

    @Override
    public void enter() {
        System.out.println("You enter Santa's Toy Workshop. " + description);
    }

    @Override
    public int interact() {
        System.out.println("You see busy elves working on toys.");
        System.out.println("What do you want to do?");
        System.out.println("1. Help the elves with toy making");
        System.out.println("2. Explore the toy workshop");

        int choice = getUserChoice();

        switch (choice) {
            case 1:
                System.out.println("You assist the elves in making toys. You earn 2 points.");
                return 2;
            case 2:
                System.out.println("You explore the toy workshop and find a hidden room.");
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
