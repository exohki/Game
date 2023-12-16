import java.util.Scanner;

public class CandyCaneForestRoom implements Room {
    private String description;

    public CandyCaneForestRoom(String description) {
        this.description = description;
    }

    @Override
    public void enter() {
        System.out.println("You find yourself in the magical Candy Cane Forest. " + description);
    }

    @Override
    public int interact() {
        System.out.println("The air is filled with the sweet aroma of candy canes.");
        System.out.println("What do you want to do?");
        System.out.println("1. Taste a candy cane");
        System.out.println("2. Follow the candy cane path");

        int choice = getUserChoice();

        switch (choice) {
            case 1:
                System.out.println("You taste a delicious candy cane. It brings you joy! You earn 1 point.");
                return 1;
            case 2:
                System.out.println("You follow the candy cane path and discover a hidden treasure.");
                return 2;
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