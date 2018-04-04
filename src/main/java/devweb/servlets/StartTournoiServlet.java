package devweb.servlets;

import devweb.managers.MembreLibrary;
import devweb.services.TournoiService;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/start")
public class StartTournoiServlet extends GenericServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String type = req.getParameter("type");
        Integer nbplace = Integer.parseInt(req.getParameter("nbplace"));

        try {
            TournoiService.getInstance().startTournoi(nbplace,type);
            TournoiService.getInstance().initTournoi();
        } catch (IllegalArgumentException e) {
            req.getSession().setAttribute("addpointErrorMessage", e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

        resp.sendRedirect("tournoiadmin");

    }
}


