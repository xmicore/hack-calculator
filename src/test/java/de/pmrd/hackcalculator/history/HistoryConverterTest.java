package de.pmrd.hackcalculator.history;

import java.math.BigDecimal;
import java.time.LocalDate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.convert.ConversionService;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HistoryConverterTest {

  @Autowired private ConversionService conversionService;

  @Test
  public void convert_fromBackendModelToViewModel_mapsCorrectly() {
    LocalDate now = LocalDate.now();
    HistoryBackendModel backendModel = new HistoryBackendModel();
    backendModel.setHackInGramsTotal(new BigDecimal(800));
    backendModel.setHackInGramsPerBun(new BigDecimal(70.51));
    backendModel.setNumberOfBuns(new BigDecimal(9));
    backendModel.setDateSavedToHistory(now);
    backendModel.setUser("JohnDoe");

    HistoryViewItem viewModel = conversionService.convert(backendModel, HistoryViewItem.class);

    assertEquals(new BigDecimal(800), viewModel.getHackInGramsTotal());
    assertEquals(new BigDecimal(70.51), viewModel.getHackInGramsPerBuns());
    assertEquals(new BigDecimal(9), viewModel.getNumberOfBuns());
    assertEquals(now, viewModel.getDateSavedToHistory());
  }
}
