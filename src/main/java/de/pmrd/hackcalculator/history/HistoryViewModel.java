package de.pmrd.hackcalculator.history;

import java.math.BigDecimal;
import java.time.LocalDate;

public class HistoryViewModel {
  private BigDecimal numberOfBroetchen;
  private BigDecimal hackInGramsPerBroetchen;
  private BigDecimal hackInGramsTotal;
  private LocalDate dateSavedToHistory;

  public BigDecimal getNumberOfBroetchen() {
    return numberOfBroetchen;
  }

  public void setNumberOfBroetchen(BigDecimal numberOfBroetchen) {
    this.numberOfBroetchen = numberOfBroetchen;
  }

  public BigDecimal getHackInGramsPerBroetchen() {
    return hackInGramsPerBroetchen;
  }

  public void setHackInGramsPerBroetchen(BigDecimal hackInGramsPerBroetchen) {
    this.hackInGramsPerBroetchen = hackInGramsPerBroetchen;
  }

  public BigDecimal getHackInGramsTotal() {
    return hackInGramsTotal;
  }

  public void setHackInGramsTotal(BigDecimal hackInGramsTotal) {
    this.hackInGramsTotal = hackInGramsTotal;
  }

  public LocalDate getDateSavedToHistory() {
    return dateSavedToHistory;
  }

  public void setDateSavedToHistory(LocalDate dateSavedToHistory) {
    this.dateSavedToHistory = dateSavedToHistory;
  }
}
