package de.pmrd.hackcalculator.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

  public double calculateHack(CalculateHackData data) {
    return data.getNumberOfPersons() * data.getBunsPerPerson() * data.getHackPerBun();
  }
}