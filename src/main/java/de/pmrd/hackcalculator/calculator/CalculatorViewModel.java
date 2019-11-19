package de.pmrd.hackcalculator.calculator;

public class CalculatorViewModel {

  private double numberOfPersons;

  private double hackPerBun;

  private double bunsPerPerson;

  public CalculatorViewModel() {}

  public double getNumberOfPersons() {
    return numberOfPersons;
  }

  public void setNumberOfPersons(double numberOfPersons) {
    this.numberOfPersons = numberOfPersons;
  }

  public double getHackPerBun() {
    return hackPerBun;
  }

  public void setHackPerBun(double hackPerBun) {
    this.hackPerBun = hackPerBun;
  }

  public double getBunsPerPerson() {
    return bunsPerPerson;
  }

  public void setBunsPerPerson(double bunsPerPerson) {
    this.bunsPerPerson = bunsPerPerson;
  }
}
