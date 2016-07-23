/**
 * Created by Thiloshon on 25-Apr-16.
 * This Class is the model class of Module
 */
public class Room implements java.io.Serializable {
    private String roomID;
    private String roomSize;



    public Room(String roomID, String roomSize) {
        this.roomID = roomID;
        this.roomSize = roomSize;

    }

    @Override
    public String toString() {
        return "Room{" +
                "roomID='" + roomID + '\'' +
                ", roomSize='" + roomSize + '\'' +
                '}';
    }

    public String getRoomID() {
        return roomID;
    }

}
