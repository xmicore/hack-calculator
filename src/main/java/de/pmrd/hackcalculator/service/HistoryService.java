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

  private Map<UUID, HistoryBackendItem> historyItems;

  public HistoryService() {
    historyItems = new HashMap<>();
    init();
  }

  public Collection<HistoryBackendItem> getHistoryItems() {
    return historyItems.values();
  }

  public Optional<HistoryBackendItem> getHistoryItem(String uuidAsString) {
    final UUID uuid = UUID.fromString(uuidAsString);
    return Optional.ofNullable(historyItems.get(uuid));
  }

  public HistoryBackendItem getHistoryItem(UUID uuid) {
    return historyItems.get(uuid);
  }

  public void saveHistoryItem(HistoryBackendItem item) {
    final HistoryBackendItem historyBackendItem = historyItems.get(item.getId());
    // Save new one if not present in the map, otherwise update.
    if (historyBackendItem == null) {
      final BigDecimal hackTotal = item.getHackPerBun().multiply(item.getNumberOfBuns());
      item.setHackTotal(hackTotal);
    } else {
      historyItems.remove(item.getId());
      item.setModified(LocalDate.now());
    }
    historyItems.put(item.getId(), item);
  }

  private void init() {
    HistoryBackendItem history1 = new HistoryBackendItem();
    history1.setSavedToHistory(LocalDate.of(2019, 10, 2));
    history1.setModified(LocalDate.of(2019, 10, 4));
    history1.setHackPerBun(new BigDecimal(70));
    history1.setNumberOfBuns(new BigDecimal(8));
    history1.setNumberOfPersons(new BigDecimal(4));
    history1.setHackTotal(new BigDecimal(700));

    HistoryBackendItem history2 = new HistoryBackendItem();
    history2.setSavedToHistory(LocalDate.now());
    history2.setHackPerBun(new BigDecimal(80));
    history2.setNumberOfBuns(new BigDecimal(10));
    history2.setNumberOfPersons(new BigDecimal(5));
    history2.setHackTotal(new BigDecimal(800));

    historyItems.put(history1.getId(), history1);
    historyItems.put(history2.getId(), history2);
  }
}
