package gov.nasa.robotexplorer.robotexplorer.service;

import gov.nasa.robotexplorer.domain.CardinalPoint;
import gov.nasa.robotexplorer.exception.PositionDoesNotValidException;
import gov.nasa.robotexplorer.model.Position;
import gov.nasa.robotexplorer.properties.InitialProperties;
import gov.nasa.robotexplorer.properties.MessagesProperties;
import gov.nasa.robotexplorer.service.PositionService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Locale;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest(InitialProperties.class)
public class PositionServiceTest {

    @Mock
    private MessagesProperties messagesProperties;

    @InjectMocks
    private PositionService positionService;

    @Before
    public void setUp() throws Exception {
        when(messagesProperties.getMessage("error.position_not_valid"))
                .thenReturn("position_not_valid");

        InitialProperties.setCoordinateX(0);
        InitialProperties.setCoordinateY(0);
        InitialProperties.setAxisRangeX(5);
        InitialProperties.setAxisRangeY(5);
        InitialProperties.setSouthLimit(0);
        InitialProperties.setNorthLimit(5);
        InitialProperties.setWestLimit(0);
        InitialProperties.setEastLimit(5);
        InitialProperties.setDIRECTION(CardinalPoint.NORTH);
        InitialProperties.setLocale(new Locale("pt_BR"));
    }

    @Test
    public void whenPositionValid_ThenVoidReturn() {
        Position position = new Position(0, 0, CardinalPoint.SOUTH);
        positionService.validPosition(position);
        assertTrue(true);
    }

    @Test(expected = PositionDoesNotValidException.class)
    public void whenSouthPositionOutOfLimit_ThenReturnPositionException() {
        Position position = new Position(0, -1, CardinalPoint.SOUTH);

        positionService.validPosition(position);
    }

    @Test(expected = PositionDoesNotValidException.class)
    public void whenNorthPositionOutOfLimit_ThenReturnPositionException() {
        Position position = new Position(0, 6, CardinalPoint.SOUTH);

        positionService.validPosition(position);
    }

    @Test(expected = PositionDoesNotValidException.class)
    public void whenWestPositionOutOfLimit_ThenReturnPositionException() {
        Position position = new Position(-1, 0, CardinalPoint.SOUTH);

        positionService.validPosition(position);
    }

    @Test(expected = PositionDoesNotValidException.class)
    public void whenEastPositionOutOfLimit_ThenReturnPositionException() {
        Position position = new Position(6, 0, CardinalPoint.SOUTH);

        positionService.validPosition(position);
    }

    @Test(expected = PositionDoesNotValidException.class)
    public void when2PositionsOutsideTheLimit_ThenReturnPositionException() {
        Position position = new Position(6, 6, CardinalPoint.SOUTH);

        positionService.validPosition(position);
    }
}