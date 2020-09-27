package de.pmrd.hackcalculator.presenter.converter;

import static org.junit.Assert.assertEquals;

import de.pmrd.hackcalculator.service.model.HistoryBackendItem;
import de.pmrd.hackcalculator.view.model.HistoryViewItem;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.convert.ConversionService;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HistoryConverterTest {

  @Autowired private ConversionService conversionService;

  @Test
  public void convert_fromBackendModelToViewModel_mapsCorrectly() {
    LocalDate now = LocalDate.now();
    LocalDate tomorrow = now.plusDays(1);
    HistoryBackendItem backendModel = new HistoryBackendItem();
    backendModel.setHackTotal(new BigDecimal(800));
    backendModel.setHackPerBun(new BigDecimal(70.55));
    backendModel.setNumberOfBuns(new BigDecimal(9));
    backendModel.setSavedToHistory(now);
    backendModel.setModified(tomorrow);
    backendModel.setNumberOfPersons(new BigDecimal(3));

    HistoryViewItem viewModel = conversionService.convert(backendModel, HistoryViewItem.class);

    assertEquals(
        new BigDecimal(800.00).setScale(2, RoundingMode.HALF_UP), viewModel.getHackTotal());
    assertEquals(
        new BigDecimal(70.55).setScale(2, RoundingMode.HALF_UP), viewModel.getHackPerBun());
    assertEquals(
        new BigDecimal(9.0).setScale(1, RoundingMode.HALF_UP), viewModel.getNumberOfBuns());
    assertEquals(
        new BigDecimal(3).setScale(1, RoundingMode.HALF_UP), viewModel.getNumberOfPersons());
    assertEquals(now, viewModel.getSavedToHistory());
    assertEquals(tomorrow, viewModel.getModified());
  }
}
