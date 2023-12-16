public class CandyCaneForestRoomFactory extends RoomFactory {
    @Override
    public Room createRoom() {
        return new CandyCaneForestRoom("The trees are made of candy canes!");
    }
}