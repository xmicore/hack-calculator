package de.pmrd.hackcalculator.history.jpa.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@NamedQueries(
    @NamedQuery(
        name = HistoryItemJpaEntity.FIND_ALL,
        query = "SELECT i FROM HistoryItemJpaEntity i"))
public class HistoryItemJpaEntity {

  public static final String FIND_ALL = "HistoryItem.findAll";

  @Id private UUID id;
  private BigDecimal numberOfBuns;
  private BigDecimal hackPerBun;
  private BigDecimal hackTotal;
  private BigDecimal numberOfPersons;
  private LocalDate savedToHistory;
  private LocalDate modified;
  private String user;

  public HistoryItemJpaEntity() {}

  public HistoryItemJpaEntity(
      UUID id,
      BigDecimal numberOfBuns,
      BigDecimal hackPerBun,
      BigDecimal hackTotal,
      BigDecimal numberOfPersons,
      LocalDate savedToHistory,
      LocalDate modified,
      String user) {
    this.id = id;
    this.numberOfBuns = numberOfBuns;
    this.hackPerBun = hackPerBun;
    this.hackTotal = hackTotal;
    this.numberOfPersons = numberOfPersons;
    this.savedToHistory = savedToHistory;
    this.modified = modified;
    this.user = user;
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

  public BigDecimal getNumberOfPersons() {
    return numberOfPersons;
  }

  public void setNumberOfPersons(BigDecimal numberOfPersons) {
    this.numberOfPersons = numberOfPersons;
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

  public String getUser() {
    return user;
  }

  public void setUser(String user) {
    this.user = user;
  }
}
