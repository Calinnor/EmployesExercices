package com.company;

public class Programmeur extends Employe{

    private int completedProjects;

    public Programmeur(String nom, double mensualIncome, double mensualOccupationTime, int completedProjects) {
        super(nom, mensualIncome, mensualOccupationTime);
        this.completedProjects = completedProjects;
    }

    public static final int FACTEUR_GAINS_PROJETS=200;

    public double yearIncomeCalcul() {
        double programmeurYearIncome = super.yearIncomeCalcul()/100 + FACTEUR_GAINS_PROJETS * this.completedProjects;
        //System.out.format("%.2f", programmeurYearIncome);
        return programmeurYearIncome;
    }

    /*public double yearIncomeCalculWithPrime(){
        double programmeurYearIncomeWithPrime = super.yearIncomeCalculWithPrime()/100 + FACTEUR_GAINS_PROJETS * this.completedProjects+this.askForPrime;
        //System.out.format("%.2f", programmeurYearIncomeWithPrime);
        return programmeurYearIncomeWithPrime;
    }*/

    public String toString(){
        String programmeurInformations=this.nom+"\n"+ super.toString()+"\nA mené à bien "+this.completedProjects+ " projets.\n";
        return programmeurInformations;
    }
}