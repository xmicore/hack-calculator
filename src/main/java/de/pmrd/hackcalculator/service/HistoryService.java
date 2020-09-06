package de.pmrd.hackcalculator.service;

import de.pmrd.hackcalculator.history.HistoryItemRepository;
import de.pmrd.hackcalculator.service.model.HistoryBackendItem;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

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
        .map(this::setSavedToHistoryToNow)
        .map(this::calcHackTotal)
        .findFirst()
        .ifPresent(historyItemRepository::create);
  }

  private HistoryBackendItem setSavedToHistoryToNow(HistoryBackendItem item) {
    item.setSavedToHistory(LocalDate.now());
    return item;
  }

  private HistoryBackendItem calcHackTotal(HistoryBackendItem item) {
    item.setHackTotal(
        calculatorService.calculateHackTotal(
            item.getNumberOfPersons(), item.getNumberOfBuns(), item.getHackPerBun()));
    return item;
  }

  public void updateHistoryItem(HistoryBackendItem item) {
    historyItemRepository.findById(item.getId()).map(e -> item).stream()
        .map(this::calcHackPerBun)
        .map(this::setModifiedToNow)
        .findFirst()
        .ifPresent(historyItemRepository::update);
  }

  private HistoryBackendItem setModifiedToNow(HistoryBackendItem item) {
    item.setModified(LocalDate.now());
    return item;
  }

  private HistoryBackendItem calcHackPerBun(HistoryBackendItem item) {
    calculatorService
        .calculateHackPerBun(item.getNumberOfPersons(), item.getNumberOfBuns(), item.getHackTotal())
        .ifPresent(item::setHackPerBun);
    return item;
  }
}
