package de.pmrd.hackcalculator.view.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class HistoryViewItem {

    private UUID id;
    private BigDecimal numberOfBuns;
    private BigDecimal hackPerBun;
    private BigDecimal hackTotal;
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

    public BigDecimal getHackPerBun() {
        return hackPerBun;
    }

    public void setHackPerBun(BigDecimal hackInGramsPerBun) {
        this.hackPerBun = hackInGramsPerBun;
    }

    public BigDecimal getHackTotal() {
        return hackTotal;
    }

    public void setHackTotal(BigDecimal hackInGramsTotal) {
        this.hackTotal = hackInGramsTotal;
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
        return numberOfPerson;
    }

    public void setNumberOfPersons(BigDecimal numberOfPerson) {
        this.numberOfPerson = numberOfPerson;
    }
}
