public class Help {
    public static void showHelpMenu() {
        System.out.println("Help Menu:");
        System.out.println("1. Overview of the game");
        System.out.println("2. Game instructions");
    }

    public static void processHelpChoice(int choice) {
        switch (choice) {
            case 1:
                System.out.println("Overview: This is a Christmas-themed adventure game.");

                break;
            case 2:
                System.out.println("Game Instructions: Explore different Christmas-themed rooms and interact with them to earn points.");

                break;
            default:
                System.out.println("Invalid choice.");
        }
    }
}
