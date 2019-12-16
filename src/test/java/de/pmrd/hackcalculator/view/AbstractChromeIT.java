package de.pmrd.hackcalculator.view;

import com.vaadin.testbench.IPAddress;
import com.vaadin.testbench.ScreenshotOnFailureRule;
import com.vaadin.testbench.TestBenchTestCase;
import org.junit.Before;
import org.junit.Rule;
import org.junit.runner.RunWith;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public abstract class AbstractChromeIT extends TestBenchTestCase {

  @Rule
  public ScreenshotOnFailureRule rule = new ScreenshotOnFailureRule(this, true);

  @LocalServerPort
  private int port;

  @Before
  public void setUp() {
    setDriver(new ChromeDriver());
    getDriver().get("http://" + IPAddress.findSiteLocalAddress() + ":" + port);
  }

}
