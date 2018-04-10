package devweb.dao;

import devweb.entities.Membre;

import java.util.List;

public interface MembreDao {

    public List<Membre> listMembres();

    public List<Membre> listMembresInscrit();

    public Membre getMembre(String email);

    public void addMembre(String email, String nom, String prenom, String classe, String mdp);

    public String getMdp(String email);

    public void deleteMembre(String email);

    public void modifMdp(String email, String mdp);

    public void addPoint(String email, Integer nbpoint);

    public void deleteAllPoint();

    public void joinTournoi(String email);

    public void cancelJoin(String email);

    public int nbinscrit();
}
