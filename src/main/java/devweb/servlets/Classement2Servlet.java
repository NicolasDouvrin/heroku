package devweb.servlets;

import devweb.entities.Membre;
import devweb.managers.MembreLibrary;
import devweb.services.ArticleService;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/classement2")
public class Classement2Servlet extends GenericServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setCharacterEncoding("UTF-8");

        WebContext context = new WebContext(req, resp, req.getServletContext());

        List<Membre> listOfMembres = MembreLibrary.getInstance().listMembres();
        context.setVariable("membresList",listOfMembres);

        TemplateEngine templateEngine = createTemplateEngine(req.getServletContext());
        templateEngine.process("classement2", context, resp.getWriter());
    }
}
