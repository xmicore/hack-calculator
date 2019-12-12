package de.pmrd.hackcalculator.service;

import de.pmrd.hackcalculator.service.model.HistoryBackendItem;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Service
@SessionScope
public class HistoryService {

  private final CalculatorService calculatorService;
  private Map<UUID, HistoryBackendItem> historyItems;

  public HistoryService(CalculatorService calculatorService) {
    this.calculatorService = calculatorService;
    historyItems = new HashMap<>();
    init();
  }

  public Collection<HistoryBackendItem> getHistoryItems() {
    historyItems
        .values()
        .forEach(
            e ->
                e.setHackTotal(
                    calculatorService.calculateHackTotal(
                        e.getNumberOfPersons(), e.getNumberOfBuns(), e.getHackPerBun())));
    return historyItems.values();
  }

  public Optional<HistoryBackendItem> getHistoryItem(String uuidAsString) {
    final UUID uuid = UUID.fromString(uuidAsString);
    return Optional.ofNullable(historyItems.get(uuid));
  }

  public HistoryBackendItem getHistoryItem(UUID uuid) {
    return historyItems.get(uuid);
  }

  public void createHistoryItem(HistoryBackendItem item) {
    item.setModified(LocalDate.now());
    historyItems.put(item.getId(), item);
  }

  public void updateHistoryItem(HistoryBackendItem item) {
    final HistoryBackendItem historyBackendItem = historyItems.get(item.getId());
    if (historyBackendItem == null || historyItems.get(item.getId()) == null) {
      throw new IllegalArgumentException("Item to update not found.");
    } else {
      item.setHackPerBun(
          calculatorService.calculateHackPerBun(
              item.getNumberOfPersons(), item.getNumberOfBuns(), item.getHackTotal()));
      item.setModified(LocalDate.now());
      historyItems.remove(item.getId());
      historyItems.put(item.getId(), item);
    }
  }

  private void init() {
    HistoryBackendItem history1 = new HistoryBackendItem();
    history1.setSavedToHistory(LocalDate.of(2019, 10, 2));
    history1.setModified(LocalDate.of(2019, 10, 4));
    history1.setHackPerBun(new BigDecimal(70));
    history1.setNumberOfBuns(new BigDecimal(2));
    history1.setNumberOfPersons(new BigDecimal(4));

    HistoryBackendItem history2 = new HistoryBackendItem();
    history2.setSavedToHistory(LocalDate.now());
    history2.setHackPerBun(new BigDecimal(80));
    history2.setNumberOfBuns(new BigDecimal(3));
    history2.setNumberOfPersons(new BigDecimal(5));

    historyItems.put(history1.getId(), history1);
    historyItems.put(history2.getId(), history2);
  }
}
