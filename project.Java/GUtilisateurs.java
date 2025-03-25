import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe permettant la gestion des utilisateurs :
 * - Ajouter un utilisateur
 * - Supprimer un utilisateur
 * - Modifier un utilisateur
 * - Lister les utilisateurs
 */
public class GUtilisateurs {
    // Liste des utilisateurs stockés en mémoire
    private static final ArrayList<Utilisateur> utilisateurs = new ArrayList<>();

    /**
     * Affiche le menu de gestion des utilisateurs et gère les choix de l'utilisateur
     */
    public static void menuUtilisateurs(Scanner scanner) {
        int choix;
        do {
            System.out.println("\nGESTION DES UTILISATEURS :");
            System.out.println("1: Ajouter un utilisateur");
            System.out.println("2: Supprimer un utilisateur");
            System.out.println("3: Modifier un utilisateur");
            System.out.println("4: Liste des utilisateurs");
            System.out.println("5: Retour");
            System.out.println("0: Quitter");
            System.out.print("Choissisez : ");
            
            // Vérification de la saisie utilisateur
            while (!scanner.hasNextInt()) {
                System.out.println("Veuillez entrer un nombre valide.");
                scanner.next();
            }
            choix = scanner.nextInt();
            scanner.nextLine(); // Consommer la nouvelle ligne

            switch (choix) {
                case 1:
                    ajouterUtilisateur(scanner);
                    break;
                case 2:
                    supprimerUtilisateur(scanner);
                    break;
                case 3:
                    modifierUtilisateur(scanner);
                    break;
                case 4:
                    listerUtilisateurs();
                    break;
                case 5:
                    return;  // Retour au menu principal
                case 0:
                    System.exit(0);  // Quitter l'application
                default:
                    System.out.println("Choix invalide !");
            }
        } while (choix != 0);
    }

    /**
     * Ajoute un utilisateur à la liste
     */
    public static void ajouterUtilisateur(Scanner scanner) {
        System.out.print("Identifiant : ");
        String identifiant = scanner.nextLine().trim();
        System.out.print("Mot de passe : ");
        String motDePasse = scanner.nextLine().trim();
        System.out.print("Rôle (admin/user) : ");
        String role = scanner.nextLine().trim();

        utilisateurs.add(new Utilisateur(identifiant, motDePasse, role));
        System.out.println("Utilisateur ajouté avec succès !");
    }

    /**
     * Supprime un utilisateur de la liste
     */
    public static void supprimerUtilisateur(Scanner scanner) {
        listerUtilisateurs();
        System.out.print("Numero de l'utilisateur que vous voulez supprimer : ");
        
        // Vérification de la saisie
        while (!scanner.hasNextInt()) {
            System.out.println("Veuillez entrer un bon numero .");
            scanner.next();
        }
        int index = scanner.nextInt();
        scanner.nextLine();

        if (index >= 0 && index < utilisateurs.size()) {
            utilisateurs.remove(index);
            System.out.println("Utilisateur a ete supprimé avec succès a bientot !");
        } else {
            System.out.println("invalide !");
        }
    }

    /**
     * Modifie les informations d'un utilisateur existant
     */
    public static void modifierUtilisateur(Scanner scanner) {
        listerUtilisateurs();
        System.out.print("Numéro de l'utilisateur que vous voulez modifier : ");
        
        // Vérification de la saisie
        while (!scanner.hasNextInt()) {
            System.out.println("Veuillez entrer un numéro valide.");
            scanner.next();
        }
        int index = scanner.nextInt();
        scanner.nextLine();

        if (index >= 0 && index < utilisateurs.size()) {
            System.out.print("Nouvel identifiant : ");
            String nouvelIdentifiant = scanner.nextLine().trim();
            System.out.print("Nouveau mot de passe : ");
            String nouveauMotDePasse = scanner.nextLine().trim();
            System.out.print("Nouveau rôle (admin/user) : ");
            String nouveauRole = scanner.nextLine().trim();

            Utilisateur utilisateur = utilisateurs.get(index);
            utilisateur.setIdentifiant(nouvelIdentifiant);
            utilisateur.setMotDePasse(nouveauMotDePasse);
            utilisateur.setRole(nouveauRole);

            System.out.println("Utilisateur modifié avec succès !");
        } else {
            System.out.println(" invalide !");
        }
    }

    /**
     * Affiche la liste des utilisateurs
     */
    public static void listerUtilisateurs() {
        if (utilisateurs.isEmpty()) {
            System.out.println("Aucun utilisateur enregistré.");
        } else {
            System.out.println("Liste des utilisateurs :");
            for (int i = 0; i < utilisateurs.size(); i++) {
                System.out.println(i + ": " + utilisateurs.get(i));
            }
        }
    }
}
