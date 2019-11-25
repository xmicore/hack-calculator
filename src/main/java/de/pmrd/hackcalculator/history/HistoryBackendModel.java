package de.pmrd.hackcalculator.history;

import java.math.BigDecimal;
import java.time.LocalDate;

public class HistoryBackendModel {

  private BigDecimal numberOfBuns;
  private BigDecimal hackInGramsPerBun;
  private BigDecimal hackInGramsTotal;
  private LocalDate dateSavedToHistory;
  private String user;

  public HistoryBackendModel() {
    numberOfBuns = new BigDecimal(0);
    hackInGramsPerBun = new BigDecimal(0);
    hackInGramsTotal = new BigDecimal(0);
    dateSavedToHistory = LocalDate.now();
    user = "";
  }

  public BigDecimal getNumberOfBuns() {
    return numberOfBuns;
  }

  public void setNumberOfBuns(BigDecimal numberOfBroetchen) {
    this.numberOfBuns = numberOfBroetchen;
  }

  public BigDecimal getHackInGramsPerBun() {
    return hackInGramsPerBun;
  }

  public void setHackInGramsPerBun(BigDecimal hackInGramsPerBun) {
    this.hackInGramsPerBun = hackInGramsPerBun;
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

  public String getUser() {
    return user;
  }

  public void setUser(String user) {
    this.user = user;
  }
}
