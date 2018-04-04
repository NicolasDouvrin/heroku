package devweb.servlets;

import devweb.managers.MembreLibrary;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/addpoint")
public class AddPointServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String idemail = req.getParameter("emailjoueur");
        Integer nbpoint = Integer.parseInt(req.getParameter("nb-point"));

        try {
            MembreLibrary.getInstance().addPoint(idemail,nbpoint);
        } catch (IllegalArgumentException e) {
            req.getSession().setAttribute("addpointErrorMessage", e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

        resp.sendRedirect("tournoiadmin");

    }
}
