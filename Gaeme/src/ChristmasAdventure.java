import java.util.Scanner;

import java.util.Scanner;

public class ChristmasAdventure {
    private GameManager gameManager;
    private int pointsEarned;

    public ChristmasAdventure(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    public void start() {
        System.out.println("Welcome to the Christmas Adventure!");

        showHelpMenu();


        gameManager.getCurrentRoom().enter();
        int pointsEarned = gameManager.getCurrentRoom().interact();


        System.out.println("You earned " + pointsEarned + " points.");


        if (pointsEarned >= 5) {
            System.out.println("Congratulations! You've earned enough points to win a special present.");
            gameManager.getCurrentRoom().interact();
            System.out.println("You've completed the Christmas Adventure. You win!");
        } else {

            Room nextRoom = chooseNextRoom();
            gameManager.setCurrentRoom(nextRoom);


            System.out.println("\n--- Next Part of the Adventure ---\n");


            gameManager.getCurrentRoom().enter();
            int additionalPoints = gameManager.getCurrentRoom().interact();


            System.out.println("You earned an additional " + additionalPoints + " points.");


            if (pointsEarned + additionalPoints >= 5) {
                System.out.println("Congratulations! You've earned enough points to win a special present.");
                gameManager.getCurrentRoom().interact();
                System.out.println("You've completed the Christmas Adventure. You win!");
            } else {

                Room thirdRoom = chooseNextRoom();
                gameManager.setCurrentRoom(thirdRoom);


                System.out.println("\n--- Final Part of the Adventure ---\n");


                System.out.println("--- Score ---");
                System.out.println("Total Points: " + (pointsEarned + additionalPoints));

                System.out.println("Do you want to explore the last room? (yes/no)");
                Scanner scanner = new Scanner(System.in);
                String exploreChoice = scanner.nextLine().toLowerCase();

                if (exploreChoice.equals("yes")) {
                    gameManager.getCurrentRoom().enter();
                    gameManager.getCurrentRoom().interact();
                }

                if (pointsEarned + additionalPoints >= 5) {
                    System.out.println("Congratulations! You've earned enough points to win a special present.");
                    gameManager.getCurrentRoom().interact(); // Open the present
                    System.out.println("You've completed the Christmas Adventure. You win!");
                } else {
                    System.out.println("You do not have enough points for a present this time. Try again next time!");
                    System.out.println("Thank you for playing the Christmas Adventure!");
                }
            }
        }
    }


    private void continueGame() {

        Room nextRoom = chooseNextRoom();
        gameManager.setCurrentRoom(nextRoom);


        System.out.println("\n--- Next Part of the Adventure ---\n");


        gameManager.getCurrentRoom().enter();
        int additionalPoints = gameManager.getCurrentRoom().interact();


        System.out.println("You earned an additional " + additionalPoints + " points.");


        if (pointsEarned + additionalPoints >= 5) {
            System.out.println("Congratulations! You've earned enough points to win a special present.");
            gameManager.getCurrentRoom().interact();
            System.out.println("You've completed the Christmas Adventure. You win!");
        } else {

            Room thirdRoom = chooseNextRoom();
            gameManager.setCurrentRoom(thirdRoom);


            System.out.println("\n--- Final Part of the Adventure ---\n");
            start();
        }
    }

    private Room chooseNextRoom() {
        System.out.println("\n--- Choose Your Next Adventure ---");
        System.out.println("1. Toy Workshop");
        System.out.println("2. Candy Cane Forest");

        int choice = getUserChoice();

        switch (choice) {
            case 1:
                return new ToyWorkshopRoom("You hear the sound of toys being crafted.");
            case 2:
                return new CandyCaneForestRoom("The trees are made of candy canes!");
            default:
                System.out.println("Invalid choice. Exiting the Christmas Adventure.");
                System.exit(0);
                return null;
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

    private void showHelpMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n--- Help Menu ---");
        System.out.println("1. Overview of the game");
        System.out.println("2. Instructions to the game");
        System.out.println("3. How to view your score and inventory");

        System.out.print("Enter your choice (or type 'start' to begin the game): ");
        String choice = scanner.nextLine();

        switch (choice.toLowerCase()) {
            case "1":

                System.out.println("This is a text-based Christmas Adventure game. Explore different rooms,");
                System.out.println("interact with the environment, and earn points to win special presents!");
                break;
            case "2":

                System.out.println("Instructions: Choose your actions wisely to earn points. The goal is to");
                System.out.println("collect at least 5 points to win a special present.");
                break;
            case "3":

                System.out.println("To view your score and inventory, simply type 'score' during the game.");
                break;
            case "start":

                break;
            default:
                System.out.println("Invalid choice. Starting the game...");
        }
    }


    public static void main(String[] args) {
        GameManager gameManager = GameManager.getInstance();
        ChristmasAdventure adventure = new ChristmasAdventure(gameManager);
        adventure.start();
    }
}
