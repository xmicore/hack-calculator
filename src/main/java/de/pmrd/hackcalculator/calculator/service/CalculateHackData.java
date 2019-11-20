package de.pmrd.hackcalculator.calculator.service;

public class CalculateHackData {

    private double numberOfPersons;
    private double hackPerBun;
    private double bunsPerPerson;

    private CalculateHackData(double numberOfPersons, double hackPerBun, double bunsPerPerson) {
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

        public CalculateHackData build() {
            return new CalculateHackData(numberOfPersons, hackPerBun, bunsPerPerson);
        }
    }

}
