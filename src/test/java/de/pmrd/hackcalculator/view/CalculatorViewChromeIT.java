package de.pmrd.hackcalculator.view;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import com.vaadin.flow.component.html.testbench.LabelElement;
import com.vaadin.flow.component.textfield.testbench.NumberFieldElement;
import com.vaadin.testbench.IPAddress;
import com.vaadin.testbench.ScreenshotOnFailureRule;
import com.vaadin.testbench.TestBenchTestCase;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalculatorViewChromeIT extends TestBenchTestCase {

  @Rule public ScreenshotOnFailureRule rule = new ScreenshotOnFailureRule(this, true);

  @Before
  public void setUp() {
    setDriver(new ChromeDriver());
    getDriver().get("http://" + IPAddress.findSiteLocalAddress() + ":8080");
  }

  @Test
  public void calculateHack() {
    $(NumberFieldElement.class).id("numberOfPersons").setValue("10.0");
    $(NumberFieldElement.class).id("hackPerBun").setValue("100.0");
    $(NumberFieldElement.class).id("bunsPerPerson").setValue("1.0");
    assertThat(
        $(LabelElement.class).id("result").getText(),
        is("Sie benötigen 1.000g feinstes Thüringer Hack!"));
  }
}
