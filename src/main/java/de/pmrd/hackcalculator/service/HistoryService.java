package de.pmrd.hackcalculator.service;

import de.pmrd.hackcalculator.history.HistoryItemRepository;
import de.pmrd.hackcalculator.service.model.HistoryBackendItem;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@Service
@SessionScope
public class HistoryService {

  private final CalculatorService calculatorService;
  private final HistoryItemRepository historyItemRepository;

  public HistoryService(
      CalculatorService calculatorService, HistoryItemRepository historyItemRepository) {
    this.calculatorService = calculatorService;
    this.historyItemRepository = historyItemRepository;
    init();
  }

  public Collection<HistoryBackendItem> getHistoryItems() {
    return historyItemRepository.findAll();
  }

  public Optional<HistoryBackendItem> getHistoryItem(String id) {
    return historyItemRepository.findById(id);
  }

  public Optional<HistoryBackendItem> getHistoryItem(UUID id) {
    return historyItemRepository.findById(id.toString());
  }

  public void createHistoryItem(HistoryBackendItem item) {
    Optional.ofNullable(item).stream()
        .peek(e -> e.setSavedToHistory(LocalDate.now()))
        .peek(this::calcHackTotal)
        .findFirst()
        .ifPresent(historyItemRepository::create);
  }

  private void calcHackTotal(HistoryBackendItem item) {
    item.setHackTotal(
        calculatorService.calculateHackTotal(
            item.getNumberOfPersons(), item.getNumberOfBuns(), item.getHackPerBun()));
  }



  public void updateHistoryItem(HistoryBackendItem item) {
    historyItemRepository.findById(item.getId()).map(e -> item).stream()
        .peek(this::calcHackPerBun)
        .peek(e -> e.setModified(LocalDate.now()))
        .findFirst()
        .ifPresent(historyItemRepository::update);
  }

  private void calcHackPerBun(HistoryBackendItem item) {
    item.setHackPerBun(
            calculatorService.calculateHackPerBun(
                    item.getNumberOfPersons(), item.getNumberOfBuns(), item.getHackTotal()));
  }

  private void init() {
    HistoryBackendItem history1 = new HistoryBackendItem();
    history1.setModified(LocalDate.of(2019, 10, 4));
    history1.setHackPerBun(new BigDecimal(70));
    history1.setNumberOfBuns(new BigDecimal(2));
    history1.setNumberOfPersons(new BigDecimal(4));
    createHistoryItem(history1);

    HistoryBackendItem history2 = new HistoryBackendItem();
    history2.setHackPerBun(new BigDecimal(80));
    history2.setNumberOfBuns(new BigDecimal(3));
    history2.setNumberOfPersons(new BigDecimal(5));
    createHistoryItem(history2);
  }
}
