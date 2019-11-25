package de.pmrd.hackcalculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

  public double calculateHack(CalculatorData data) {
    return data.getNumberOfPersons() * data.getBunsPerPerson() * data.getHackPerBun();
  }
}