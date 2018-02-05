package devweb.servlets;

import devweb.entities.Article;
import devweb.services.ArticleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

    @WebServlet("/delarticle")
    public class DeleteArticleServlet extends HttpServlet {

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String titre = req.getParameter("titre");

            try {
                ArticleService.getInstance().delArticle(titre);
            } catch (IllegalArgumentException e) {
                req.getSession().setAttribute("delArticleErrorMessage", e.getMessage());
            }
            resp.sendRedirect("accueil#portfolio");
        }

}
