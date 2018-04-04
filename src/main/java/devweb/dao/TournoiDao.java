package devweb.dao;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import devweb.dao.impl.DataSourceProvider;
import devweb.entities.Tournoi;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TournoiDao {

    public DataSource getDatasource() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setServerName("nr84dudlpkazpylz.chr7pe7iynqr.eu-west-1.rds.amazonaws.com");
        dataSource.setPort(3306);
        dataSource.setDatabaseName("d2ecpo8shdq7pdmr");
        dataSource.setUser("wzw4zb6dvsoypc74");
        dataSource.setPassword("su9d7layctq9uwzf");

        return dataSource;
    }

    public void startTournoi(Integer nbPlace, String type) {
        String query = "INSERT INTO tournoi(nbInscrits, nbPlaces, type) VALUES(0, ?, ?)";
        try (Connection connection = getDatasource().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, nbPlace);
            statement.setString(2, type);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void initTournoi(){
        String query = "UPDATE tournoi SET tournoi.nbInscrits=(select count(membre.email) from membre where membre.inscrit=1);";
        try (Connection connection = getDatasource().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public int nbinscrit(){
        Integer nombre = 10;
        try (Connection connection = getDatasource().getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("Select nbInscrits From tournoi ORDER BY idTournoi DESC LIMIT 1")) {
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
