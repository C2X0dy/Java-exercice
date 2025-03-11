import java.util.ArrayList;
import java.util.Scanner;

public class Professeurs {
    public static ArrayList<String> professeurs = new ArrayList<>();

    public static void menuProfesseurs(Scanner scanner) {
        int choix;
        do {
            System.out.println("\nGESTION DES PROFESSEURS :");
            System.out.println("1: Ajouter un professeur");
            System.out.println("2: Supprimer un professeur");
            System.out.println("3: Modifier un professeur");
            System.out.println("4: Lister les professeurs");
            System.out.println("5: Obtenir le dernier professeur ajouté");
            System.out.println("6: Retour");
            System.out.println("0: Quitter");
            System.out.print("Votre choix : ");
            choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    ajouterProfesseur(scanner);
                    break;
                case 2:
                    supprimerProfesseur(scanner);
                    break;
                case 3:
                    modifierProfesseur(scanner);
                    break;
                case 4:
                    listerProfesseurs();
                    break;
                case 5:
                    obtenirDernierProfesseur();
                    break;
                case 6:
                    return;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Choix invalide !");
            }
        } while (choix != 0);
    }

    public static void ajouterProfesseur(Scanner scanner) {
        System.out.print("Nom du professeur : ");
        String nom = scanner.nextLine();
        professeurs.add(nom);
        System.out.println("Professeur ajouté !");
    }

    public static void supprimerProfesseur(Scanner scanner) {
        listerProfesseurs();
        System.out.print("Numéro du professeur à supprimer : ");
        int index = scanner.nextInt();
        scanner.nextLine();
        if (index >= 0 && index < professeurs.size()) {
            professeurs.remove(index);
            System.out.println("Professeur supprimé !");
        } else {
            System.out.println("Index invalide !");
        }
    }

    public static void modifierProfesseur(Scanner scanner) {
        listerProfesseurs();
        System.out.print("Numéro du professeur à modifier : ");
        int index = scanner.nextInt();
        scanner.nextLine();
        if (index >= 0 && index < professeurs.size()) {
            System.out.print("Nouveau nom : ");
            String nouveauNom = scanner.nextLine();
            professeurs.set(index, nouveauNom);
            System.out.println("Professeur modifié !");
        } else {
            System.out.println("Index invalide !");
        }
    }

    public static void listerProfesseurs() {
        if (professeurs.isEmpty()) {
            System.out.println("Aucun professeur enregistré.");
        } else {
            for (int i = 0; i < professeurs.size(); i++) {
                System.out.println(i + ": " + professeurs.get(i));
            }
        }
    }

    public static void obtenirDernierProfesseur() {
        if (!professeurs.isEmpty()) {
            System.out.println("Dernier professeur ajouté : " + professeurs.get(professeurs.size() - 1));
        } else {
            System.out.println("Aucun professeur ajouté.");
        }
    }
}
