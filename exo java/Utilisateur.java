public class Utilisateur {
    private String identifiant;
    private String motDePasse;
    private String role;

    public Utilisateur(String identifiant, String motDePasse, String role) {
        this.identifiant = identifiant;
        this.motDePasse = motDePasse;
        this.role = role;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Identifiant: " + identifiant + ", Rôle: " + role;
    }
}
