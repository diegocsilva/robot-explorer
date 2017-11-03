package gov.nasa.robotexplorer.model;

public class Robot {

    private Position position;

    public Robot(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
