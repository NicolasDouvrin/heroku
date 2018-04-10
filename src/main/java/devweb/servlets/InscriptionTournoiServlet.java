package devweb.servlets;

import devweb.managers.MembreLibrary;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/jointournoi")
public class InscriptionTournoiServlet extends GenericServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");

        HttpServletRequest httpRequest = (HttpServletRequest) req;
        String identifiant = (String) httpRequest.getSession().getAttribute("utilisateurConnecte");

        try {
            MembreLibrary.getInstance().joinTournoi(identifiant);
            resp.sendRedirect("/compte");
        } catch (IllegalArgumentException e) {
            req.getSession().setAttribute("ModifMdpErrorMessage", e.getMessage());
        }

    }
}
