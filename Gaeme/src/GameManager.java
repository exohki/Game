class GameManager {
    private static GameManager instance;
    private Room currentRoom;

    private GameManager() {

        this.currentRoom = new ChristmasRoom("You find a cozy fireplace and a decorated Christmas tree.");
    }

    public static synchronized GameManager getInstance() {
        if (instance == null) {
            instance = new GameManager();
        }
        return instance;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }
}
