package gov.nasa.robotexplorer.robotexplorer.factory;

import gov.nasa.robotexplorer.factory.PositionFactory;
import gov.nasa.robotexplorer.model.Position;
import gov.nasa.robotexplorer.properties.InitialProperties;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PositionFactoryTest {

    @Test
    public void validValuesNewPositionDefault() {
        Position position = new PositionFactory().create();

        assertEquals(position.getDirection(), InitialProperties.DIRECTION);
        assertEquals(position.getCoordinateX(), InitialProperties.COORDINATE_X);
        assertEquals(position.getCoordinateY(), InitialProperties.COORDINATE_Y);
    }
}
