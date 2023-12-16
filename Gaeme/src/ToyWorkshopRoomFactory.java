public class ToyWorkshopRoomFactory extends RoomFactory {
    @Override
    public Room createRoom() {
        return new ToyWorkshopRoom("You hear the sound of toys being crafted.");
    }
}