package com.company;

import java.util.Scanner;

public class Employe {
    public static int nbreInstances = 0;


    protected String nom;
    protected double mensualIncome;
    protected double mensualOccupationTime=100;
    protected double askForPrime=0;

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
        //String.format("%.2f", yearIncome);
        //est censé formater yearIncome a deux chiffres apres la virgule...ne marche pas
        return yearIncome;

    }

    //methode demandant une prime
    protected void demandePrime() {
        System.out.println("Montant de la prime demandée par " + this.nom + " ?");
        Scanner keyboard = new Scanner(System.in);
        this.askForPrime = keyboard.nextDouble();
        keyboard.nextLine();
        int i = 1;
        while (this.askForPrime>(yearIncomeCalcul()*2/100) && i < 5){
            System.out.println("Trop cher");
            i++;
            System.out.println("Montant de la prime demandée par " + this.nom +" ?");
            this.askForPrime = keyboard.nextDouble();
            keyboard.nextLine();

            if(i==5 && this.askForPrime >(yearIncomeCalcul()*2/100)) {
                this.askForPrime = 0;
            }
        }
    }

    // ou que la donnée saisie est non numérique (lancement d’une InputMismatchException par nextDouble()).


    //Les dialogues relatifs à l’interaction devront être strictement analogues
    // à ceux donnés dans les exemples de déroulement fournis plus bas.
    // L’utilisateur n’aura droit qu’à 5 tentatives de saisie. Si après 5 tentatives
    // le montant de la prime n’a pu être saisi (parce qu’il a été à chaque fois ou
    // trop élevé ou différent d’une valeur numérique), la prime de l’employé reste à zero.
    // Sinon la prime de l’employé vaudra le montant saisi.
    //Indication : si une lecture échoue, pour faire en sorte que la prochaine lecture se passe bien il faudra «purger» le Scanner des données erronées en lui appliquant la méthode nextLine(). Vous devrez déclarer le Scanner comme variable locale de la méthode void demandePrime().


    public String toString() {
        nbreInstances++;
        if(nbreInstances>3) {
            String employeInformations = "Taux d'occupation : " + this.mensualOccupationTime +
                    "%. Salaire annuel : " + this.yearIncomeCalcul() + " francs. Prime :" + this.askForPrime;
            return employeInformations;
        }
        else{
            String employeInformations = "Taux d'occupation : " + this.mensualOccupationTime +
                    "%. Salaire annuel : " + this.yearIncomeCalcul() + " francs.";
            return employeInformations;
        }
    }
}

