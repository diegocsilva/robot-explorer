package gov.nasa.robotexplorer.service;

import gov.nasa.robotexplorer.domain.BoundaryMap;
import gov.nasa.robotexplorer.exception.PositionDoesNotValidException;
import gov.nasa.robotexplorer.model.Position;
import gov.nasa.robotexplorer.properties.MessagesProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class PositionService {

    private MessagesProperties messagesProperties;

    public void validPosition(Position position) throws PositionDoesNotValidException {
        if (position.getCoordinateY() < BoundaryMap.SOUTH_LIMIT.getLimiteCoordinate()
                        || position.getCoordinateY() > BoundaryMap.NORTH_LIMIT.getLimiteCoordinate()
                        || position.getCoordinateX() < BoundaryMap.WEST_LIMIT.getLimiteCoordinate()
                        || position.getCoordinateX() > BoundaryMap.EAST_LIMIT.getLimiteCoordinate()){
            throw new PositionDoesNotValidException(messagesProperties.getMessage("error.position_not_valid"));
        }
    }

    @Autowired
    public void setMessagesProperties(MessagesProperties messagesProperties) {
        this.messagesProperties = messagesProperties;
    }
}

