package devweb.entities;

public class Membre {
        private String email;
        private String nom;
        private String prenom;
        private String classe;
        private String mdp;
        private Integer nbPoints;
        private Integer partiesJouees;
        private Integer inscrit;

    public Integer getNbPoints() {
        return nbPoints;
    }

    public void setNbPoints(Integer nbPoints) {
        this.nbPoints = nbPoints;
    }

    public Integer getPartiesJouees() {
        return partiesJouees;
    }

    public void setPartiesJouees(Integer partiesJouees) {
        this.partiesJouees = partiesJouees;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public Integer getInscrit() {
        return inscrit;
    }

    public void setInscrit(Integer inscrit) {
        this.inscrit = inscrit;
    }

    public Membre(String email, String nom, String prenom, String classe, String mdp, Integer nbPoints, Integer partiesJouees, Integer inscrit) {
        this.email = email;
        this.nom = nom;
        this.prenom = prenom;
        this.classe = classe;
        this.mdp = mdp;
        this.nbPoints = nbPoints;
        this.partiesJouees = partiesJouees;
        this.inscrit = inscrit;
    }
}
