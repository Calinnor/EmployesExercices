package com.company;

public class Manager extends Employe{
    private int travelDays;
    private int numberOfNewCustomersBringing;

    public Manager(String nom, double mensualIncome, double mensualOccupationTime, int travelDays, int numberOfNewCustomersBringing) {
        super(nom, mensualIncome, mensualOccupationTime);
        this.travelDays = travelDays;
        this.numberOfNewCustomersBringing = numberOfNewCustomersBringing;

    }

    public static final double FACTEUR_GAIN_CLIENT = 500;

    public static final double FACTEUR_GAIN_VOYAGE = 100;

    public double yearIncomeCalcul() {
        double managerYearIncome = super.yearIncomeCalcul() / 100 + FACTEUR_GAIN_CLIENT * this.numberOfNewCustomersBringing +
                FACTEUR_GAIN_VOYAGE * this.travelDays + this.askForPrime;
        return managerYearIncome;
    }

    public String toString() {
        String managerInformations = this.nom+"\n"+super.toString() +"\nA voyagé " + this.travelDays + " jours et a apporté " +
                this.numberOfNewCustomersBringing + " nouveaux clients.\n";
        return managerInformations;
    }
}
