package gov.nasa.robotexplorer.domain;

import gov.nasa.robotexplorer.exception.CardinalPointsDoesNotValidException;

public enum CardinalPoint {
    NORTH("N", 1, 1, Axis.AXIS_Y),
    WEST("W", 2, -1, Axis.AXIS_X),
    SOUTH("S", 3, -1, Axis.AXIS_Y),
    EAST("E", 4, 1, Axis.AXIS_X);

    private String value;
    private Integer order;
    private Integer valueDeslocationInAxis;
    private Axis axisWhereMove;

    CardinalPoint(String value, Integer order,
                  Integer valueDeslocationInAxis, Axis axisWhereMove) {
        this.value = value;
        this.order = order;
        this.valueDeslocationInAxis = valueDeslocationInAxis;
        this.axisWhereMove = axisWhereMove;
    }

    CardinalPoint(String value) {
        CardinalPoint cardinalPoint = getByValue(value);
        this.value = cardinalPoint.value;
        this.order = cardinalPoint.order;
    }

    public static CardinalPoint getByOrder(Integer order) {
        switch (order) {
            case 1:
                return NORTH;
            case 2:
                return WEST;
            case 3:
                return SOUTH;
            case 4:
                return EAST;
            default:
                return null;
        }
    }

    public static CardinalPoint getByValue(String value) throws CardinalPointsDoesNotValidException {
        switch (value) {
            case "N" :
                return NORTH;
            case "S" :
                return SOUTH;
            case "W" :
                return WEST;
            case "E" :
                return EAST;
            default:
                throw new CardinalPointsDoesNotValidException();
        }
    }

    public String getValue() {
        return value;
    }

    public CardinalPoint getTurnLeft() {
        if (order+1 > 4){
            return getByOrder(1);
        }
        return getByOrder(order+1);
    }

    public CardinalPoint getTurnRight() {
        if (order-1 < 1){
            return getByOrder(4);
        }
        return getByOrder(order-1);
    }

    public Integer getValueDeslocationInAxis() {
        return valueDeslocationInAxis;
    }

    public Axis getAxisWhereMove() {
        return axisWhereMove;
    }
}
