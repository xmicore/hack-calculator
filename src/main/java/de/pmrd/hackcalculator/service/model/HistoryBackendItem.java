package de.pmrd.hackcalculator.service.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class HistoryBackendItem {

  private UUID id;
  private BigDecimal numberOfBuns;
  private BigDecimal hackPerBun;
  private BigDecimal hackTotal;
  private BigDecimal numberOfPersons;
  private LocalDate savedToHistory;
  private LocalDate modified;

  public HistoryBackendItem() {
    id = UUID.randomUUID();
    savedToHistory = LocalDate.now();
  }

  public HistoryBackendItem(
      UUID id,
      BigDecimal numberOfBuns,
      BigDecimal hackPerBun,
      BigDecimal hackTotal,
      BigDecimal numberOfPersons,
      LocalDate savedToHistory,
      LocalDate modified) {
    this.id = id;
    this.numberOfBuns = numberOfBuns;
    this.hackPerBun = hackPerBun;
    this.hackTotal = hackTotal;
    this.numberOfPersons = numberOfPersons;
    this.savedToHistory = savedToHistory;
    this.modified = modified;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public BigDecimal getNumberOfBuns() {
    return numberOfBuns;
  }

  public void setNumberOfBuns(BigDecimal numberOfBuns) {
    this.numberOfBuns = numberOfBuns;
  }

  public BigDecimal getHackPerBun() {
    return hackPerBun;
  }

  public void setHackPerBun(BigDecimal hackPerBun) {
    this.hackPerBun = hackPerBun;
  }

  public BigDecimal getHackTotal() {
    return hackTotal;
  }

  public void setHackTotal(BigDecimal hackTotal) {
    this.hackTotal = hackTotal;
  }

  public LocalDate getSavedToHistory() {
    return savedToHistory;
  }

  public void setSavedToHistory(LocalDate savedToHistory) {
    this.savedToHistory = savedToHistory;
  }

  public LocalDate getModified() {
    return modified;
  }

  public void setModified(LocalDate modified) {
    this.modified = modified;
  }

  public BigDecimal getNumberOfPersons() {
    return numberOfPersons;
  }

  public void setNumberOfPersons(BigDecimal numberOfPerson) {
    this.numberOfPersons = numberOfPerson;
  }

}
