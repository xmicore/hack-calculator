package de.pmrd.hackcalculator.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

  public BigDecimal calculateHackTotal(
      BigDecimal numberOfPersons, BigDecimal numberOfBuns, BigDecimal hackPerBun) {
    return numberOfPersons
        .multiply(numberOfBuns)
        .multiply(hackPerBun)
        .setScale(2, RoundingMode.HALF_UP);
  }

  public BigDecimal calculateBuns(BigDecimal numberOfPersons, BigDecimal numberOfBuns) {
    return numberOfPersons.multiply(numberOfBuns).setScale(2, RoundingMode.HALF_UP);
  }

  public BigDecimal calculateHackPerBun(
      BigDecimal numberOfPersons, BigDecimal numberOfBuns, BigDecimal hackTotal) {
    return hackTotal.divide(numberOfBuns.multiply(numberOfPersons), RoundingMode.HALF_UP);
  }
}
