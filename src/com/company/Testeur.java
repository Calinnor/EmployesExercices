package com.company;

public class Testeur extends Employe{
    private int correctedWarnings;

    //constructeur testeur
    public Testeur(String nom, double mensualIncome, double mensualOccupationTime, int correctedWarnings) {

        //données classe mere employés
        super(nom, mensualIncome, mensualOccupationTime);

        //specialisation testeur
        this.correctedWarnings = correctedWarnings;
    }

    //affichage type testeur
    public void newEmployeType(){
        super.newEmployesType();
        System.out.println(this.nom+" ,c'est un testeur.");
    }

    public static final double FACTEUR_GAINS_ERREURS=10;

    //methode de calcul du revenu annuel testeur
    public double yearIncomeCalcul() {
        double testeurYearIncome = super.yearIncomeCalcul()/100 + FACTEUR_GAINS_ERREURS * this.correctedWarnings;
        return testeurYearIncome;
    }

    public String toString(){
        String testeurInformations=this.nom+"\n"+ super.toString()+"\nA corrigé "+this.correctedWarnings+ " erreurs.\n";
        return testeurInformations;
    }
}

