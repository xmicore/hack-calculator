package de.pmrd.hackcalculator.view.model;

import com.vaadin.flow.component.checkbox.Checkbox;

public class CalculatorViewModel {

  private double numberOfPersons;

  private double hackPerBun;

  private double bunsPerPerson;

  private boolean onions;

  private boolean mustard;

  private boolean pickles;

  private boolean toothpick;

  public CalculatorViewModel() {
  }

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

  public boolean isOnions() {
    return onions;
  }

  public void setOnions(boolean onions) {
    this.onions = onions;
  }

  public boolean isMustard() {
    return mustard;
  }

  public void setMustard(boolean mustard) {
    this.mustard = mustard;
  }

  public boolean isPickles() {
    return pickles;
  }

  public void setPickles(boolean pickles) {
    this.pickles = pickles;
  }

  public boolean isToothpick() {
    return toothpick;
  }

  public void setToothpick(boolean toothpick) {
    this.toothpick = toothpick;
  }
}
