package devweb.servlets;

import devweb.managers.MembreLibrary;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delcompte")
public class DeleteMembreServlet extends GenericServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");

        String email = req.getParameter("UtilisateurConnecte");

        try {
            MembreLibrary.getInstance().deleteMembre(email);
        } catch (IllegalArgumentException e) {
            req.getSession().setAttribute("deleteMembreErrorMessage", e.getMessage());
        }

        resp.sendRedirect("accueil");
    }
}
