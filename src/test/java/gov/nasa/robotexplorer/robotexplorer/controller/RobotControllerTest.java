package gov.nasa.robotexplorer.robotexplorer.controller;

import gov.nasa.robotexplorer.RobotExplorerApplication;
import gov.nasa.robotexplorer.controller.RobotController;
import gov.nasa.robotexplorer.handler.RestExceptionHandler;
import gov.nasa.robotexplorer.properties.InitialProperties;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RobotExplorerApplication.class)
@WebAppConfiguration
@TestPropertySource(locations="classpath:application.yml")
public class RobotControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private RobotController robotController;

    @Autowired
    private Environment env;

    private Map<String, String> messagesError = new HashMap<>();

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(robotController).setControllerAdvice(new RestExceptionHandler()).build();
        messagesError.put("position_not_valid", env.getProperty("robot.exception.message.position_not_valid"));
        messagesError.put("action_not_valid", env.getProperty("robot.exception.message.action_not_valid"));
        messagesError.put("defaul_error_message", env.getProperty("robot.exception.message.defaul_error_message"));
    }

    @Test
    public void whenMMMM_ThenReturnStatusOkAndPosition04N() throws Exception {
        mockMvc.perform(post("/robot/executeRoute/MMMM"))
                .andExpect(status().isOk())
                .andExpect(content().string("(0, 4, N)"));
    }

    @Test
    public void whenMMMMRMMMMRMMMMRMMMMR_ThenReturnStatusOkAndPosition00N() throws Exception {
        mockMvc.perform(post("/robot/executeRoute/MMMMRMMMMRMMMMRMMMMR"))
                .andExpect(status().isOk())
                .andExpect(content().string("(0, 0, N)"));
    }

    @Test
    public void whenLLLL_ThenReturnStatusOkAndPosition00N() throws Exception {
        mockMvc.perform(post("/robot/executeRoute/LLLL"))
                .andExpect(status().isOk())
                .andExpect(content().string("(0, 0, N)"));
    }

    @Test
    public void whenMoveNorth4xAndSouth2x_ThenReturnStatusOkAndPosition02S() throws Exception {
        mockMvc.perform(post("/robot/executeRoute/MMMMRRMM"))
                .andExpect(status().isOk())
                .andExpect(content().string("(0, 2, S)"));
    }

    @Test
    public void whenMoveEast4xAndNorth4x_ThenReturnStatusOkAndPosition44N() throws Exception {
        mockMvc.perform(post("/robot/executeRoute/RMMMMLMMMM"))
                .andExpect(status().isOk())
                .andExpect(content().string("(4, 4, N)"));
    }

    @Test
    public void whenMoveEast4xAndNorth4xAndWest_ThenReturnStatusOkAndPosition40W() throws Exception {
        mockMvc.perform(post("/robot/executeRoute/RMMMMLMMMMLMMMM"))
                .andExpect(status().isOk())
                .andExpect(content().string("(0, 4, W)"));
    }

    @Test
    public void whenMoveWest1x_ThenReturnStatusBadRequestAndMessageErrorPosition() throws Exception {
        mockMvc.perform(post("/robot/executeRoute/LM"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string(InitialProperties.messagePositionNotValid));
    }

    @Test
    public void whenMoveNorth6x_ThenReturnStatusBadRequestAndMessageErrorPosition() throws Exception {
        mockMvc.perform(post("/robot/executeRoute/MMMMMM"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string(InitialProperties.messagePositionNotValid));
    }

    @Test
    public void whenMoveEast6x_ThenReturnStatusBadRequestAndMessageErrorPosition() throws Exception {
        mockMvc.perform(post("/robot/executeRoute/RMMMMMM"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string(InitialProperties.messagePositionNotValid));
    }

    @Test
    public void whenMoveSouth1x_ThenReturnStatusBadRequestAndMessageErrorPosition() throws Exception {
        mockMvc.perform(post("/robot/executeRoute/LLM"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string(InitialProperties.messagePositionNotValid));
    }

    @Test
    public void whenCommandNotValid_ThenReturnStatusBadRequestAndMessageErrorCommand() throws Exception {
        mockMvc.perform(post("/robot/executeRoute/PP"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string(InitialProperties.messageActionNotValid));
    }
}
