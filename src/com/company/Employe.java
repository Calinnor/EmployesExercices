package com.company;

import java.util.Scanner;

public class Employe {

    protected String nom;
    protected double mensualIncome;
    protected double mensualOccupationTime;
    protected double askForPrime;

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
    }

    //affichage nouvel employé de la classe mere
    protected void newEmployesType() {
        System.out.print("Nous avons un nouvel employé : ");
    }


    //fonction de calcul du revenu annuel pour les employés
    protected double yearIncomeCalcul() {
        double yearIncome = this.mensualIncome * 12 * this.mensualOccupationTime ;

        //String.format("%.2f", yearIncome);
        //est censé formater yearIncome a deux chiffres apres la virgule...ne marche pas
        return yearIncome;
    }

    //methode demandant une prime
    void demandePrime() {
        double maxAskForPrime = yearIncomeCalcul()*2/100;
        System.out.println("Montant de la prime demandée par " + this.nom + " ?");
        Scanner keyboard = new Scanner(System.in);
        this.askForPrime = keyboard.nextDouble();
        int i = 1;
        while (this.askForPrime>maxAskForPrime && i < 5){
            System.out.println("Trop cher");
            i++;
            System.out.println("Montant de la prime demandée par " + this.nom +" ?");
            this.askForPrime = keyboard.nextDouble();

            if(i==5 && this.askForPrime > maxAskForPrime) {
                this.askForPrime = 0;
            }
        }
        System.out.println("prime ="+this.askForPrime);
    }



    //Test partie 2 : Montant de la prime souhaitée par Serge Legrand ?
    // 10000000 Trop cher! Montant de la prime souhaitée par Serge Legrand ?


    //Définissez ensuite dans la classe Employe une méthode void demandePrime() réalisant les traitements suivants :
    // — demander la saisie (au clavier) d’un montant de prime souhaitée par l’employé (un double);
    // — redemander ce montant tant que la donnée saisie est trop grande
    // (l’employé ne peut demander plus de 2% de son salaire annuel)
    // ou que la donnée saisie est non numérique (lancement d’une InputMismatchException par nextDouble()).


    //Les dialogues relatifs à l’interaction devront être strictement analogues
    // à ceux donnés dans les exemples de déroulement fournis plus bas.
    // L’utilisateur n’aura droit qu’à 5 tentatives de saisie. Si après 5 tentatives
    // le montant de la prime n’a pu être saisi (parce qu’il a été à chaque fois ou
    // trop élevé ou différent d’une valeur numérique), la prime de l’employé reste à zero.
    // Sinon la prime de l’employé vaudra le montant saisi.
    //Indication : si une lecture échoue, pour faire en sorte que la prochaine lecture se passe bien il faudra «purger» le Scanner des données erronées en lui appliquant la méthode nextLine(). Vous devrez déclarer le Scanner comme variable locale de la méthode void demandePrime().


    public String toString() {
        String employeInformations ="Taux d'occupation : " + this.mensualOccupationTime +
                "%. Salaire annuel : " + this.yearIncomeCalcul() + " francs. " ;
        return employeInformations;
    }
}

