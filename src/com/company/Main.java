package com.company;
/*
/*******************************************
 * Completez le programme a partir d'ici.
 *******************************************/
/*"Nous avons un nouvel employé : "
        "Montant de la prime souhaitée par "
        "  A voyagé "
        " jours et apporté "
        "  A corrigé "
        "  A mené à bien "

/*******************************************
 * Ne rien modifier apres cette ligne.
 ********************************************/

import java.util.ArrayList;
import java.util.List;

class Employes {

    public static void main(String[] args) {

        List<Employe> staff = new ArrayList<Employe>();

        // TEST PARTIE 1:

        System.out.println("Test partie 1 : ");
        staff.add(new Manager("Serge Legrand", 7456, 30, 4, 25 ));
        staff.add(new Programmeur("Paul Lepetit" , 6456, 3, 75 ));
        staff.add(new Testeur("Pierre Lelong", 5456, 124, 50 ));

        System.out.println("Affichage des employés : ");
        for (Employe modele : staff) {
            System.out.println(modele);
        }
        // FIN TEST PARTIE 1
        // TEST PARTIE 2
        System.out.println("Test partie 2 : ");

        staff.get(0).demandePrime();

        System.out.println("Affichage après demande de prime : ");
        System.out.println(staff.get(0));

        // FIN TEST PARTIE 2
    }
}

