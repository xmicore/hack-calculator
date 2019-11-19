package de.pmrd.hackcalculator.calculator;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

  double calculateHack(double numberOfPersons, double hackPerBun, double bunsPerPerson) {
    return numberOfPersons * bunsPerPerson * hackPerBun;
  }

}
