package devweb.entities;

public class Table {

    private Integer idTable;
    private String nomJoueur;
    private String prenomJoueur;

    public Table(Integer idTable, String nomJoueur, String prenomJoueur) {
        this.idTable = idTable;
        this.nomJoueur = nomJoueur;
        this.prenomJoueur = prenomJoueur;
    }

    public Integer getIdTable() {
        return idTable;
    }

    public void setIdTable(Integer idTable) {
        this.idTable = idTable;
    }

    public String getNomJoueur() {
        return nomJoueur;
    }

    public void setNomJoueur(String nomJoueur) {
        this.nomJoueur = nomJoueur;
    }

    public String getPrenomJoueur() {
        return prenomJoueur;
    }

    public void setPrenomJoueur(String prenomJoueur) {
        this.prenomJoueur = prenomJoueur;
    }
}
