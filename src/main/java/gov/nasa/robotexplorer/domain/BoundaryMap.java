package gov.nasa.robotexplorer.domain;

import gov.nasa.robotexplorer.properties.InitialRobotProperties;

public enum  BoundaryMap {
    SOUTH_LIMIT(InitialRobotProperties.SOUTH_LIMIT , Axis.AXIS_Y),
    NORTH_LIMIT(InitialRobotProperties.NORTH_LIMIT, Axis.AXIS_Y),
    WEST_LIMIT(InitialRobotProperties.WEST_LIMIT, Axis.AXIS_X),
    EAST_LIMIT(InitialRobotProperties.EAST_LIMIT, Axis.AXIS_X);

    private Integer limiteCoordinate;
    private Axis axis;

    BoundaryMap(Integer limiteCoordinate, Axis axis) {
        this.limiteCoordinate = limiteCoordinate;
        this.axis = axis;
    }

    public Integer getLimiteCoordinate() {
        return limiteCoordinate;
    }

    public Axis getAxis() {
        return axis;
    }
}
