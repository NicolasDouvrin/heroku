package devweb.entities;

public class Tournoi {

    private Integer idTournoi;
    private Integer nbInscrits;
    private Integer nbPlces;
    private String type;

    public Tournoi(Integer idTournoi, Integer nbInscrits, Integer nbPlces, String type) {
        this.idTournoi = idTournoi;
        this.nbInscrits = nbInscrits;
        this.nbPlces = nbPlces;
        this.type = type;
    }

    public Integer getIdTournoi() {
        return idTournoi;
    }

    public void setIdTournoi(Integer idTournoi) {
        this.idTournoi = idTournoi;
    }

    public Integer getNbInscrits() {
        return nbInscrits;
    }

    public void setNbInscrits(Integer nbInscrits) {
        this.nbInscrits = nbInscrits;
    }

    public Integer getNbPlces() {
        return nbPlces;
    }

    public void setNbPlces(Integer nbPlces) {
        this.nbPlces = nbPlces;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
