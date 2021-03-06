package devweb.dao.impl;

import devweb.dao.MembreDao;
import devweb.entities.Membre;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MembreDaoImpl implements MembreDao {

    @Override
    public List<Membre> listMembres() {
        String query = "SELECT * FROM membre WHERE NOT email='admin@hei.yncrea.fr' ORDER BY nbPoints DESC;";
        List<Membre> listofMembres = new ArrayList<>();
        try (
                Connection connection = DataSourceProvider.getDataSource().getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
        ) {
            while (resultSet.next()) {
                listofMembres.add(
                        new Membre(resultSet.getString("email"), resultSet.getString("nom"),
                                resultSet.getString("prenom"), resultSet.getString("classe"),
                                resultSet.getString("mdp"), resultSet.getInt("nbPoints"),
                                resultSet.getInt("partiesJouees"), resultSet.getInt("inscrit")));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listofMembres;
    }

    @Override
    public List<Membre> listMembresInscrit() {
        String query = "SELECT * FROM membre WHERE NOT email='admin@hei.yncrea.fr' AND inscrit='1' ORDER BY nom ASC;";
        List<Membre> listofMembresInscrit = new ArrayList<>();
        try (
                Connection connection = DataSourceProvider.getDataSource().getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
        ) {
            while (resultSet.next()) {
                listofMembresInscrit.add(
                        new Membre(resultSet.getString("email"), resultSet.getString("nom"),
                                resultSet.getString("prenom"), resultSet.getString("classe"),
                                resultSet.getString("mdp"), resultSet.getInt("nbPoints"),
                                resultSet.getInt("partiesJouees"), resultSet.getInt("inscrit")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listofMembresInscrit;
    }

    @Override
    public Membre getMembre(String email) {
        String query = "SELECT * FROM membre WHERE email=?";
        try (Connection connection = DataSourceProvider.getDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, email);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Membre(
                            resultSet.getString("email"), resultSet.getString("nom"),
                            resultSet.getString("prenom"), resultSet.getString("classe"),
                            resultSet.getString("mdp"), resultSet.getInt("nbPoints"),
                            resultSet.getInt("partiesJouees"), resultSet.getInt("inscrit"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addMembre(String email, String nom, String prenom, String classe, String mdp) {
        String query = "INSERT INTO membre(email, nom, prenom, classe, mdp, nbPoints, partiesJouees, inscrit) VALUES(?,?,?,?,?,'0','0','0')";
        try (Connection connection = DataSourceProvider.getDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, email);
            statement.setString(2, nom);
            statement.setString(3, prenom);
            statement.setString(4, classe);
            statement.setString(5, mdp);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getMdp(String email) {
        String query = "SELECT mdp FROM membre WHERE email=?";
        try (Connection connection = DataSourceProvider.getDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, email);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new String(resultSet.getString("mdp"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteMembre(String email) {
        String query = "DELETE FROM membre WHERE email=?";
        try {
            Connection connection = DataSourceProvider.getDataSource().getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, email);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void modifMdp(String email, String mdp) {
        String query = "UPDATE membre SET mdp=? WHERE email=?";
        try {
            Connection connection = DataSourceProvider.getDataSource().getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, mdp);
            statement.setString(2, email);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addPoint(String email, Integer nbpoint) {
        String query = "UPDATE membre SET nbPoints=nbPoints+?, partiesJouees=partiesJouees+? WHERE email=?";
        try (
                Connection connection = DataSourceProvider.getDataSource().getConnection();
                PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, nbpoint);
                statement.setInt(2, 1);
                statement.setString(3, email);
                statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAllPoint() {
        String query = "UPDATE membre SET nbPoints='0', partiesJouees='0'";
        try {
            Connection connection = DataSourceProvider.getDataSource().getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void joinTournoi(String email) {
        String query = "UPDATE membre SET Inscrit='1' WHERE email=?";
        try {
            Connection connection = DataSourceProvider.getDataSource().getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, email);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void cancelJoin(String email) {
        String query = "UPDATE membre SET Inscrit='0' WHERE email=?";
        try {
            Connection connection = DataSourceProvider.getDataSource().getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, email);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public int nbinscrit(){
        Integer nombre = 10;
        try (Connection connection = DataSourceProvider.getDataSource().getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("Select count(inscrit) From membre WHERE inscrit='1'")) {
            resultSet.next();
            nombre=resultSet.getInt(1);
            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nombre;
    }
}
