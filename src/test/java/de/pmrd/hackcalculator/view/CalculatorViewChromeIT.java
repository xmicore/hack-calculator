package de.pmrd.hackcalculator.view;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import com.vaadin.flow.component.html.testbench.LabelElement;
import com.vaadin.flow.component.textfield.testbench.NumberFieldElement;
import org.junit.Ignore;
import org.junit.Test;

public class CalculatorViewChromeIT extends AbstractChromeIT {

  @Ignore
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
