package devweb.dao;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import devweb.entities.Article;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArticleDao {

    public DataSource getDatasource() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setServerName("localhost");
        dataSource.setPort(3306);
        dataSource.setDatabaseName("base");
        dataSource.setUser("root");
        dataSource.setPassword("root");

        return dataSource;
    }

    public List<Article> listArticles() {
        List<Article> articles = new ArrayList<>();
        try (Connection connection = getDatasource().getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM articles")) {
            while(resultSet.next()) {
                articles.add(new Article(
                        resultSet.getInt("idArticle"),
                        resultSet.getString("titre"),
                        resultSet.getString("image"),
                        resultSet.getString("texte")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return articles;
    }

    public void addArticle(Article article) {
        String query = "INSERT INTO articles(titre, image, texte) VALUES(?, ?, ?)";
        try (Connection connection = getDatasource().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, article.getTitre());
            statement.setString(2, article.getImage());
            statement.setString(3, article.getTexte());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delArticle(String titre) {
        String query = "DELETE * FROM articles WHERE titre=? ";
        try (Connection connection = getDatasource().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, titre);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
