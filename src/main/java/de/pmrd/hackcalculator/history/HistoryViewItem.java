package de.pmrd.hackcalculator.history;

import java.math.BigDecimal;
import java.time.LocalDate;

class HistoryViewItem {
  private BigDecimal numberOfBuns;
  private BigDecimal hackInGramsPerBuns;
  private BigDecimal hackInGramsTotal;
  private LocalDate dateSavedToHistory;

  public HistoryViewItem() {
    numberOfBuns = new BigDecimal(0);
    hackInGramsPerBuns = new BigDecimal(0);
    hackInGramsTotal = new BigDecimal(0);
    dateSavedToHistory = LocalDate.now();
  }

  BigDecimal getNumberOfBuns() {
    return numberOfBuns;
  }

  void setNumberOfBuns(BigDecimal numberOfBroetchen) {
    this.numberOfBuns = numberOfBroetchen;
  }

  BigDecimal getHackInGramsPerBuns() {
    return hackInGramsPerBuns;
  }

  void setHackInGramsPerBuns(BigDecimal hackInGramsPerBuns) {
    this.hackInGramsPerBuns = hackInGramsPerBuns;
  }

  BigDecimal getHackInGramsTotal() {
    return hackInGramsTotal;
  }

  void setHackInGramsTotal(BigDecimal hackInGramsTotal) {
    this.hackInGramsTotal = hackInGramsTotal;
  }

  LocalDate getDateSavedToHistory() {
    return dateSavedToHistory;
  }

  void setDateSavedToHistory(LocalDate dateSavedToHistory) {
    this.dateSavedToHistory = dateSavedToHistory;
  }
}
