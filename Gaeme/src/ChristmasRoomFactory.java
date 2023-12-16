public class ChristmasRoomFactory extends RoomFactory {
    @Override
    public Room createRoom() {
        return new ChristmasRoom("This room is filled with holiday spirit.");
    }
}