package de.pmrd.hackcalculator.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class CalculatorService {

    public BigDecimal calculateHack(BigDecimal numberOfPersons, BigDecimal numberOfBuns, BigDecimal hackPerBun) {
        return numberOfPersons.multiply(numberOfBuns).multiply(hackPerBun).setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal calculateBuns(BigDecimal numberOfPersons, BigDecimal numberOfBuns) {
        return numberOfPersons.multiply(numberOfBuns).setScale(2, RoundingMode.HALF_UP);
    }

}

