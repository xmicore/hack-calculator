package de.pmrd.hackcalculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

  public double calculateHack(double numberOfPersons, double hackPerBun, double bunsPerPerson) {
    return numberOfPersons * bunsPerPerson * hackPerBun;
  }

}
