package devweb.servlets;

import devweb.managers.MembreLibrary;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class ConnexionServlet extends GenericServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");

        String identifiantUtilisateurConnecte = (String) req.getSession().getAttribute("utilisateurConnecte");
        if(identifiantUtilisateurConnecte == null || "".equals(identifiantUtilisateurConnecte)) {
            WebContext context = new WebContext(req, resp, req.getServletContext());
            TemplateEngine templateEngine = createTemplateEngine(req.getServletContext());
            templateEngine.process("login", context, resp.getWriter());
        }else{
            resp.sendRedirect("compte");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email=req.getParameter("email");

        String password1= MembreLibrary.getInstance().getMdp(email);
        String password2= req.getParameter("password");

        if (password1==null){
            password1="";
        }

        if (password1.equals(password2)) {
            req.getSession().setAttribute("utilisateurConnecte",email);
            resp.sendRedirect("accueil2");
        } else{
            resp.sendRedirect("compte");
        }

    }
}

