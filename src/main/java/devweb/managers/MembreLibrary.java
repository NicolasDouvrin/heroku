package devweb.managers;

import devweb.dao.MembreDao;
import devweb.dao.TournoiDao;
import devweb.dao.impl.MembreDaoImpl;
import devweb.entities.Membre;

import java.util.List;

public class MembreLibrary {

    public List<Membre> listMembres() {
        return membreDao.listMembres();
    }

    public List<Membre> listMembresInscrit() {
        return membreDao.listMembresInscrit();
    }

    private static class MembreLibraryHolder {
        private final static MembreLibrary instance = new MembreLibrary();
    }

    public static MembreLibrary getInstance() {

        return MembreLibraryHolder.instance;
    }

    private MembreDao membreDao = new MembreDaoImpl();

    public void addMembre(String email,String nom,String prenom,String classe,String mdp) {
        if (email == null || "".equals(email)) {
            throw new IllegalArgumentException("L'email ne doit pas être vide.");
        }
        membreDao.addMembre(email,nom,prenom,classe,mdp);
    }

    public String getMdp(String email) {
        if (email == null || "".equals(email)) {
            throw new IllegalArgumentException("L'email ne doit pas être vide.");
        }
        return membreDao.getMdp(email);
    }

    public void deleteMembre(String email) {

        membreDao.deleteMembre(email);
    }

    public void modifMdp(String email,String mdp){

        membreDao.modifMdp(email,mdp);
    }

    public void addPoint(String email, Integer nbpoint){

        membreDao.addPoint(email,nbpoint);
    };

    public void deleteAllPoint(){

        membreDao.deleteAllPoint();
    };

    public void joinTournoi(String email){
        membreDao.joinTournoi(email);
    }

    public void cancelJoin(String email){
        membreDao.cancelJoin(email);
    }

    public int nbinscrit(){ return membreDao.nbinscrit(); }

}
