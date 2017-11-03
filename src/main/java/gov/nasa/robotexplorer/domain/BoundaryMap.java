package gov.nasa.robotexplorer.domain;

import gov.nasa.robotexplorer.properties.InitialProperties;

public enum  BoundaryMap {
    SOUTH_LIMIT(InitialProperties.SOUTH_LIMIT , Axis.AXIS_Y),
    NORTH_LIMIT(InitialProperties.NORTH_LIMIT, Axis.AXIS_Y),
    WEST_LIMIT(InitialProperties.WEST_LIMIT, Axis.AXIS_X),
    EAST_LIMIT(InitialProperties.EAST_LIMIT, Axis.AXIS_X);

    private Integer limiteCoordinate;
    private Axis axis;

    BoundaryMap(Integer limiteCoordinate, Axis axis) {
        this.limiteCoordinate = limiteCoordinate;
        this.axis = axis;
    }

    public Integer getLimiteCoordinate() {
        return limiteCoordinate;
    }

}
