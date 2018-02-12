package devweb.servlets;

import com.mysql.jdbc.PreparedStatement;
import devweb.entities.Article;
import devweb.services.ArticleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet("/addarticle")
@MultipartConfig
public class AddArticleServlet extends HttpServlet{



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String titre = req.getParameter("titre");
        String file = req.getParameter("image");
        String texte = req.getParameter("texte");


        Article article = new Article(null,titre, file, texte);
        try {
            ArticleService.getInstance().addArticle(article);
            resp.sendRedirect("accueil2#portfolio");
        } catch (IllegalArgumentException e) {
            req.getSession().setAttribute("addArticleErrorMessage", e.getMessage());
            resp.sendRedirect("error");
        }



    }
}

