package com.sp.apps.AppBoutique;

import java.util.Scanner;

public class Program {
    static int maxSize = 3;
    static int[] codes = new int[maxSize];
    static String[] noms = new String[maxSize];
    static int[] quantites = new int[maxSize];
    static double[] prix = new double[maxSize];
    static Scanner sc = new Scanner(System.in);

    public static void printMenu() {
        System.out.println("------Gestion du stock------");
        System.out.println("1 - Ajouter un produit");
        System.out.println("2 - Modifier un produit");
        System.out.println("3 - Supprimer un produit");
        System.out.println("4 - Afficher la liste des produits");
        System.out.println("5 - Rechercher un produit");
        System.out.println("6 - Calculer la valeur totale du stock");
        System.out.println("0 - Quitter");
    }

    public static void afficherProduits() {
        System.out.println("------Liste des produits------");
        for (int i = 0; i < maxSize; i++) {
            if (codes[i] != 0) {
                System.out.println(codes[i] + "\t" + noms[i] + "\t" + quantites[i] + "\t" + prix[i]);
            }
        }
    }

    public static void ajouterProduit(int codeProduit, String nomProduit, int quantiteProduit, double prixProduit) {
        for (int i = 0; i < maxSize; i++) {
            if (codes[i] == 0) {
                codes[i] = codeProduit;
                noms[i] = nomProduit;
                quantites[i] = quantiteProduit;
                prix[i] = prixProduit;
                System.out.println("Produit ajouté avec succès !");
                return;
            }
        }
        System.out.println("Tableau plein, impossible d'ajouter un produit.");
    }

    public static void modifierProduit(int codeProduit) {
        for (int i = 0; i < maxSize; i++) {
            if (codes[i] == codeProduit) {
                int choix;
                do {
                    System.out.println("Menu de modification\n1 - Nom produit\n2 - Quantité produit\n3 - Prix produit\n4 - Quitter");
                    choix = sc.nextInt();
                    sc.nextLine();
                    switch (choix) {
                        case 1:
                            System.out.println("Nouveau nom du produit :");
                            noms[i] = sc.nextLine();
                            break;
                        case 2:
                            System.out.println("Nouvelle quantité :");
                            quantites[i] = sc.nextInt();
                            break;
                        case 3:
                            System.out.println("Nouveau prix :");
                            prix[i] = sc.nextDouble();
                            break;
                        case 4:
                            System.out.println("Modification terminée.");
                            break;
                        default:
                            System.out.println("Choix invalide !");
                    }
                } while (choix != 4);
                return;
            }
        }
        System.out.println("Produit introuvable !");
    }

    public static void supprimerProduit(int codeProduit) {
        for (int i = 0; i < maxSize; i++) {
            if (codes[i] == codeProduit) { // Produit trouvé
                codes[i] = 0;
                noms[i] = null;
                quantites[i] = 0;
                prix[i] = 0;
                System.out.println("Produit supprimé avec succès !");
                return;
            }
        }
        System.out.println("Produit introuvable !");
    }

    public static void rechercherProduit(String nomProduit) {
        boolean trouve = false;
        for (int i = 0; i < maxSize; i++) {
            if (noms[i] != null && noms[i].toLowerCase().contains(nomProduit.toLowerCase())) {
                System.out.println(codes[i] + "\t" + noms[i] + "\t" + quantites[i] + "\t" + prix[i]);
                trouve = true;
            }
        }
        if (!trouve) {
            System.out.println("Produit introuvable.");
        }
    }

    public static void calculerValeurStock() {
        double total = 0;
        for (int i = 0; i < maxSize; i++) {
            total += quantites[i] * prix[i];
        }
        System.out.println("Valeur totale du stock : " + total);
    }

    public static void main(String[] args) {
        int choix;
        do {
            printMenu();
            System.out.println("Choisissez une option :");
            choix = sc.nextInt();
            sc.nextLine();
            switch (choix) {
                case 1:
                    if (codes[maxSize - 1] != 0) {
                        System.out.println("Tableau plein, impossible d'ajouter un produit.");
                    } else {
                        System.out.println("Code produit :");
                        int codeProduit = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Nom produit :");
                        String nomProduit = sc.nextLine();
                        System.out.println("Quantité produit :");
                        int quantiteProduit = sc.nextInt();
                        System.out.println("Prix produit :");
                        double prixProduit = sc.nextDouble();
                        ajouterProduit(codeProduit, nomProduit, quantiteProduit, prixProduit);
                    }
                    break;
                case 2:
                    afficherProduits();
                    System.out.println("Entrez le code du produit à modifier :");
                    int codeProduitModif = sc.nextInt();
                    modifierProduit(codeProduitModif);
                    break;
                case 3:
                    afficherProduits();
                    System.out.println("Entrez le code du produit à supprimer :");
                    int codeProduitSupprimer = sc.nextInt();
                    supprimerProduit(codeProduitSupprimer);
                    break;
                case 4:
                    afficherProduits();
                    break;
                case 5:
                    System.out.println("Entrez le nom du produit à rechercher :");
                    String nomProduitRecherche = sc.nextLine();
                    rechercherProduit(nomProduitRecherche);
                    break;
                case 6:
                    calculerValeurStock();
                    break;
                case 0:
                    System.out.println("Session terminée.");
                    break;
                default:
                    System.out.println("Option invalide !");
            }
        } while (choix != 0);
    }
}
