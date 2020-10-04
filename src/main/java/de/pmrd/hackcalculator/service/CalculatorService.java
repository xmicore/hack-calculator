package de.pmrd.hackcalculator.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;

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

    public Optional<BigDecimal> calculateHackPerBun(
            BigDecimal numberOfPersons, BigDecimal numberOfBuns, BigDecimal hackTotal) {
        Optional<BigDecimal> hackPerBun;
        try {
            hackPerBun =
                    Optional.of(
                            hackTotal.divide(numberOfBuns.multiply(numberOfPersons), RoundingMode.HALF_UP));
        } catch (ArithmeticException e) {
            hackPerBun = Optional.empty();
        }
        return hackPerBun;
    }
}
