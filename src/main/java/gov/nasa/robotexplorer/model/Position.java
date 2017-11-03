package gov.nasa.robotexplorer.model;

import gov.nasa.robotexplorer.domain.CardinalPoint;

public class Position {

    private Integer coordinateX;

    private Integer coordinateY;

    private CardinalPoint direction;

    public Position() {
    }

    public Position(Integer coordinateX, Integer coordinateY, CardinalPoint direction) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.direction = direction;
    }

    public Integer getCoordinateX() {
        return coordinateX;
    }

    public void setCoordinateX(Integer coordinateX) {
        this.coordinateX = coordinateX;
    }

    public Integer getCoordinateY() {
        return coordinateY;
    }

    public void setCoordinateY(Integer coordinateY) {
        this.coordinateY = coordinateY;
    }

    public CardinalPoint getDirection() {
        return direction;
    }

    public void setDirection(CardinalPoint direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        return "("+getCoordinateX()+ ", "
                +getCoordinateY()+", "
                +getDirection().getValue()+")";
    }
}
