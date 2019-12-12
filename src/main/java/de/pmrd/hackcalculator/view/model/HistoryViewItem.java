package de.pmrd.hackcalculator.view.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class HistoryViewItem {

  private UUID id;
  private BigDecimal numberOfBuns;
  private BigDecimal hackInGramsPerBun;
  private BigDecimal hackInGramsTotal;
  private BigDecimal numberOfPerson;
  private LocalDate savedToHistory;
  private LocalDate modified;

  public HistoryViewItem() {
    savedToHistory = LocalDate.now();
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

  public BigDecimal getHackInGramsPerBun() {
    return hackInGramsPerBun;
  }

  public void setHackPerBun(BigDecimal hackInGramsPerBun) {
    this.hackInGramsPerBun = hackInGramsPerBun;
  }

  public BigDecimal getHackInGramsTotal() {
    return hackInGramsTotal;
  }

  public void setHackInGramsTotal(BigDecimal hackInGramsTotal) {
    this.hackInGramsTotal = hackInGramsTotal;
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

  public BigDecimal getNumberOfPerson() {
    return numberOfPerson;
  }

  public void setNumberOfPersons(BigDecimal numberOfPerson) {
    this.numberOfPerson = numberOfPerson;
  }
}
