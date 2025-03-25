import java.util.ArrayList;
import java.util.Scanner;

public class Eleves {
    public static ArrayList<String> eleves = new ArrayList<>();

    public static void menuEleves(Scanner scanner) {
        int choix;
        do {
            System.out.println("\nGESTION DES ÉLÈVES :");
            System.out.println("1: Ajouter un élève");
            System.out.println("2: Supprimer un élève");
            System.out.println("3: Modifier un élève");
            System.out.println("4: Lister les élèves");
            System.out.println("5: Obtenir le dernier élève ajouté");
            System.out.println("6: Retour");
            System.out.println("0: Quitter");
            System.out.print("Votre choix : ");
            choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    ajouterEleve(scanner);
                    break;
                case 2:
                    supprimerEleve(scanner);
                    break;
                case 3:
                    modifierEleve(scanner);
                    break;
                case 4:
                    listerEleves();
                    break;
                case 5:
                    obtenirDernierEleve();
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

    public static void ajouterEleve(Scanner scanner) {
        System.out.print("Nom de l eleve : ");
        String nom = scanner.nextLine();
        eleves.add(nom);
        System.out.println("Eleve ajoute !");
    }

    public static void supprimerEleve(Scanner scanner) {
        listerEleves();
        System.out.print("Numéro de l'eleve a supprimer : ");
        int index = scanner.nextInt();
        scanner.nextLine();
        if (index >= 0 && index < eleves.size()) {
            eleves.remove(index);
            System.out.println("Eleve supprime  !");
        } else {
            System.out.println(" invalide !");
        }
    }

    public static void modifierEleve(Scanner scanner) {
        listerEleves();
        System.out.print("Numéro de l'élève à modifier : ");
        int index = scanner.nextInt();
        scanner.nextLine();
        if (index >= 0 && index < eleves.size()) {
            System.out.print("Nouveau nom : ");
            String nouveauNom = scanner.nextLine();
            eleves.set(index, nouveauNom);
            System.out.println("Élève modifié !");
        } else {
            System.out.println("Index invalide !");
        }
    }

    public static void listerEleves() {
        if (eleves.isEmpty()) {
            System.out.println("Aucun élève enregistré.");
        } else {
            for (int i = 0; i < eleves.size(); i++) {
                System.out.println(i + ": " + eleves.get(i));
            }
        }
    }

    public static void obtenirDernierEleve() {
        if (!eleves.isEmpty()) {
            System.out.println("Dernier élève ajouté : " + eleves.get(eleves.size() - 1));
        } else {
            System.out.println("Aucun élève ajouté.");
        }
    }
}
