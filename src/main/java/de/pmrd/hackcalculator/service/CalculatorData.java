package de.pmrd.hackcalculator.service;

public class CalculatorData {

    private double numberOfPersons;
    private double hackPerBun;
    private double bunsPerPerson;

    private CalculatorData(double numberOfPersons, double hackPerBun, double bunsPerPerson) {
        this.numberOfPersons = numberOfPersons;
        this.hackPerBun = hackPerBun;
        this.bunsPerPerson = bunsPerPerson;
    }

    double getNumberOfPersons() {
        return numberOfPersons;
    }

    double getHackPerBun() {
        return hackPerBun;
    }

    double getBunsPerPerson() {
        return bunsPerPerson;
    }

    public static class Builder {

        private double numberOfPersons = 0;
        private double hackPerBun = 0;
        private double bunsPerPerson = 0;

        public Builder setNumberOfPersons(double numberOfPersons) {
            this.numberOfPersons = numberOfPersons;
            return this;
        }

        public Builder setHackPerBun(double hackPerBun) {
            this.hackPerBun = hackPerBun;
            return this;
        }

        public Builder setBunsPerPerson(double bunsPerPerson) {
            this.bunsPerPerson = bunsPerPerson;
            return this;
        }

        public CalculatorData build() {
            return new CalculatorData(numberOfPersons, hackPerBun, bunsPerPerson);
        }
    }

}
