package com.company;

public class Programmeur extends Employe{

    private int completedProjects;

    public Programmeur(String nom, double mensualIncome, double mensualOccupationTime, int completedProjects) {
        super(nom, mensualIncome, mensualOccupationTime);
        this.completedProjects = completedProjects;
    }

    public void newEmployesType(){
        super.newEmployesType();
        System.out.println(this.nom+" ,c'est un programmeur.");
    }

    public static final int FACTEUR_GAINS_PROJETS=200;

    public double yearIncomeCalcul() {
        double programmeurYearIncome = super.yearIncomeCalcul()/100 + FACTEUR_GAINS_PROJETS * this.completedProjects;
        return programmeurYearIncome;
    }

    public String toString(){
        String programmeurInformations=this.nom+"\n"+ super.toString()+"\nA mené à bien "+this.completedProjects+ " projets.\n";
        return programmeurInformations;
    }
}