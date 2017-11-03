package gov.nasa.robotexplorer.controller;

import gov.nasa.robotexplorer.model.Robot;
import gov.nasa.robotexplorer.service.RobotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/robot")
public class RobotController {

    @Autowired
    private RobotService service;

    @RequestMapping(value="/executeRoute/{route}", method= RequestMethod.POST)
    public ResponseEntity<?> executeRoute(@PathVariable String route){
        Robot robot = service.executeTheRoute(route);
        return ResponseEntity.ok(robot.getPosition().toString());
    }
}
