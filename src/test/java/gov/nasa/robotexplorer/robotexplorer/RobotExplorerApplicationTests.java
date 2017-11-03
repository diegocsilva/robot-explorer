package gov.nasa.robotexplorer.robotexplorer;

import gov.nasa.robotexplorer.RobotExplorerApplication;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.test.context.junit4.SpringRunner;


import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RobotExplorerApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Rule
	public OutputCapture outputCapture = new OutputCapture();

	private static final String SPRING_STARTUP = "root of context hierarchy";

	@Test
	public void shouldInitApplication() throws Exception {
		RobotExplorerApplication.main(new String[0]);
		assertThat(getOutput()).contains(SPRING_STARTUP);
	}

	private String getOutput() {
		return this.outputCapture.toString();
	}

}
