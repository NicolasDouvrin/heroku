package devweb.dao;

import devweb.entities.Membre;

import java.util.List;

public interface MembreDao {

    public List<Membre> listMembres();

    public Membre getMembre(String email);

    public void addMembre(String email, String nom, String prenom, String classe, String mdp);

    public String getMdp(String email);

    Membre deleteMembre();
}
