package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Employe {
    public static int nbreInstancesPrime = 0;
    public static int primeNonRecevable=1;


    protected String nom;
    protected double mensualIncome;
    protected double mensualOccupationTime=100;
    protected double askForPrime=0;
    boolean primeJuste=false;

    //creation du constructeur Employes
    public Employe(String nom, double mensualIncome, double mensualOccupationTime) {
        this.nom = nom;
        this.mensualIncome = mensualIncome;
        //creation des conditions pour <10 et >100
        if (mensualOccupationTime > 100) {
            mensualOccupationTime = 100;
        } else if (mensualOccupationTime < 10) {
            mensualOccupationTime = 10;
        }
        this.mensualOccupationTime = mensualOccupationTime;
        System.out.println("Nous avons un nouvel employé: "+this.nom+ ". C'est un "+ this.getClass().getSimpleName());
    }


    //fonction de calcul du revenu annuel pour les employés
    protected double yearIncomeCalcul() {
        double yearIncome = this.mensualIncome * 12 * this.mensualOccupationTime ;
       // String newYearIncome = String.format("%.2f",yearIncome);
        return yearIncome;
    }

    //methode demandant une primee
    protected void demandePrime() {
        nbreInstancesPrime++;
        Scanner keyboard = new Scanner(System.in);
        int i=0;
        //introduction d'une condition boolean afin de maitriser le retour en boucle
        while (!primeJuste) {
            try {
                System.out.println("Montant de la prime demandée par " + this.nom + " ?");
                i++;
                this.askForPrime = keyboard.nextDouble();
                keyboard.nextLine();
                if(this.askForPrime>(yearIncomeCalcul()*2/100) && i<5){
                    System.out.println("Montant de la prime demandée par " + this.nom + " ?");
                    askForPrime = keyboard.nextDouble();
                    keyboard.nextLine();
                    i++;
                    if(this.askForPrime< (yearIncomeCalcul()*2/100)){
                        primeJuste=true;
                    }
                    if(this.askForPrime>(yearIncomeCalcul()*2/100)) {
                        primeJuste = false;
                    }
                    if(i>=5){
                        primeJuste=true;
                    }
                }
                else
                {
                    primeJuste=true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Vous devez introduire un nombre !");
                keyboard.nextLine();
                if(i>=5){
                    primeJuste=true;
                }
            }
        }
        if(i>=5){
            primeNonRecevable=0;
            this.askForPrime=0;
        }
    }

    public String toString() {
        if(nbreInstancesPrime!=0 && primeNonRecevable !=0) {
            String employeInformations = "Taux d'occupation : " + this.mensualOccupationTime +
                    "%. Salaire annuel : " + String.format("%.2f",this.yearIncomeCalcul()) + " francs. Prime :" + this.askForPrime;
            return employeInformations;
        }
        else{
            String employeInformations = "Taux d'occupation : " + this.mensualOccupationTime +
                    "%. Salaire annuel : " + String.format("%.2f",this.yearIncomeCalcul()) + " francs.";
            return employeInformations;
        }
    }
}

