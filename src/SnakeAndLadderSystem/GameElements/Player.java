package SnakeAndLadderSystem.GameElements;

public class Player {
    private String id;
    private String name;
    private int currentPosition;

    public Player(String id, String name) {
        this.id = id;
        this.name = name;
        this.currentPosition = 0;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", currentPosition=" + currentPosition +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }
}
