package gov.nasa.robotexplorer.robotexplorer.domain;

import gov.nasa.robotexplorer.RobotExplorerApplication;
import gov.nasa.robotexplorer.domain.BoundaryMap;
import gov.nasa.robotexplorer.properties.InitialProperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RobotExplorerApplication.class)
public class BoundaryMapTest {

    @Test
    public void validGetLimiteCoordinateSouth() {
        Integer limite = BoundaryMap.SOUTH_LIMIT.getLimiteCoordinate();
        Integer limiteProperties = InitialProperties.SOUTH_LIMIT;
        assertEquals(limiteProperties, limite);
    }

    @Test
    public void validGetLimiteCoordinateNorth() {
        Integer limite = BoundaryMap.NORTH_LIMIT.getLimiteCoordinate();
        Integer limiteProperties = InitialProperties.NORTH_LIMIT;
        assertEquals(limiteProperties, limite);
    }

    @Test
    public void validGetLimiteCoordinateEast() {
        Integer limite = BoundaryMap.EAST_LIMIT.getLimiteCoordinate();
        Integer limiteProperties = InitialProperties.EAST_LIMIT;
        assertEquals(limiteProperties, limite);
    }

    @Test
    public void validGetLimiteCoordinateWest() {
        Integer limite = BoundaryMap.WEST_LIMIT.getLimiteCoordinate();
        Integer limiteProperties = InitialProperties.WEST_LIMIT;
        assertEquals(limiteProperties, limite);
    }

}
