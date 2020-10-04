package de.pmrd.hackcalculator.view.model;

import java.math.BigDecimal;

public class CalculatorViewModel {

    private BigDecimal numberOfPersons;

    private BigDecimal hackPerBun;

    private BigDecimal numberOfBuns;

    public CalculatorViewModel() {
        numberOfPersons = BigDecimal.ZERO;
        hackPerBun = BigDecimal.ZERO;
        numberOfBuns = BigDecimal.ZERO;
    }

    public BigDecimal getNumberOfPersons() {
        return numberOfPersons;
    }

    public void setNumberOfPersons(BigDecimal numberOfPersons) {
        this.numberOfPersons = numberOfPersons;
    }

    public BigDecimal getHackPerBun() {
        return hackPerBun;
    }

    public void setHackPerBun(BigDecimal hackPerBun) {
        this.hackPerBun = hackPerBun;
    }

    public BigDecimal getNumberOfBuns() {
        return numberOfBuns;
    }

    public void setNumberOfBuns(BigDecimal bunsPerPerson) {
        this.numberOfBuns = bunsPerPerson;
    }
}
