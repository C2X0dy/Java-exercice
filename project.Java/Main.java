import java.util.Scanner; // Importation de la classe Scanner pour lire les entrées utilisateur

public class Main { // Déclaration de la classe principale
    public static void main(String[] args) { // Méthode principale, point d'entrée du programme
        try (Scanner scanner = new Scanner(System.in)) { // Création d'un objet Scanner pour lire l'entrée utilisateur, avec fermeture automatique
            String identifiant, motDePasse; // Déclaration des variables pour stocker l'identifiant et le mot de passe

            // Affichage du message de bienvenue
            System.out.println("******************************************");
            System.out.println("BIENVENU DANS L’APPLICATION ETAB v1.1");
            System.out.println("******************************************");

            // Demande de l'identifiant et du mot de passe
            System.out.print("Identifiant : ");
            identifiant = scanner.nextLine(); // Lecture de l'identifiant saisi par l'utilisateur
            System.out.print("Mot de passe : ");
            motDePasse = scanner.nextLine(); // Lecture du mot de passe saisi par l'utilisateur

            // Vérification des identifiants
            if (identifiant.equals("Divine") && motDePasse.equals("Divine45")) { // Si les identifiants sont corrects
                afficherMenu(scanner); // Appel de la méthode pour afficher le menu
            } else { // Sinon
                System.out.println("Veuillez entrer un identifiant valide !"); // Message d'erreur
            }
        } // Le Scanner est automatiquement fermé ici grâce au bloc try-with-resources
    }

    // Méthode pour afficher le menu principal
    public static void afficherMenu(Scanner scanner) {
        int choix; // Déclaration de la variable pour stocker le choix de l'utilisateur
        do {
            // Affichage des options du menu
            System.out.println("\nMENU PRINCIPAL :");
            System.out.println("1: Gestion des élèves");
            System.out.println("2: Gestion des professeurs");
            System.out.println("3: Gestion des utilisateurs");
            System.out.println("0: Quitter");
            System.out.print("Votre choix : ");
            
            choix = scanner.nextInt(); // Lecture du choix de l'utilisateur (nombre entier)
            scanner.nextLine();  // Consommer le retour à la ligne pour éviter les erreurs de lecture

            // Gestion des choix avec un switch expression (simplifié)
            switch (choix) {
                case 1 -> Eleves.menuEleves(scanner); // Si l'utilisateur choisit 1, appel du menu de gestion des élèves
                case 2 -> Professeurs.menuProfesseurs(scanner); // Si l'utilisateur choisit 2, appel du menu de gestion des professeurs
                case 3 -> GUtilisateurs.menuUtilisateurs(scanner); // Si l'utilisateur choisit 3, appel du menu de gestion des utilisateurs
                case 0 -> System.out.println("Merci et a bientot!"); // Si l'utilisateur choisit 0, affichage du message d'au revoir
                default -> System.out.println("Choix invalide, veuillez réessayer."); // Si l'utilisateur saisit un nombre invalide, affichage d'un message d'erreur
            }
        } while (choix != 0); // Répétition du menu tant que l'utilisateur ne choisit pas de quitter (0)
    }
}
