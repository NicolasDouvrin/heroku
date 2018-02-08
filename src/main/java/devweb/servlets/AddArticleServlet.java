package devweb.servlets;

import devweb.entities.Article;
import devweb.services.ArticleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addarticle")
public class AddArticleServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String titre = req.getParameter("titre");
        String image = req.getParameter("image");
        String texte = req.getParameter("texte");

        Article article = new Article(null,titre, image, texte);
        try {
            ArticleService.getInstance().addArticle(article);
            resp.sendRedirect("accueil2#portfolio");
        } catch (IllegalArgumentException e) {
            req.getSession().setAttribute("addArticleErrorMessage", e.getMessage());
            resp.sendRedirect("error");
        }

    }
}

