package devweb.servlets;

import devweb.entities.Membre;
import devweb.managers.MembreLibrary;
import devweb.services.TournoiService;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/tournoiadmin")
public class TournoiAdminServlet extends GenericServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setCharacterEncoding("UTF-8");

        WebContext context = new WebContext(req, resp, req.getServletContext());

        List<Membre> listOfMembresInscrit = MembreLibrary.getInstance().listMembresInscrit();
        context.setVariable("membresList",listOfMembresInscrit);

        Integer nbInscrit = MembreLibrary.getInstance().nbinscrit();
        context.setVariable("membresInscrit",nbInscrit);

        TemplateEngine templateEngine = createTemplateEngine(req.getServletContext());
        templateEngine.process("tournoiAdmin", context, resp.getWriter());
    }

}
