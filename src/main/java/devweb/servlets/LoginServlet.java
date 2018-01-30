package devweb.servlets;



import devweb.managers.MembreLibrary;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;




@WebServlet("/login")
public class LoginServlet extends GenericServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setCharacterEncoding("UTF-8");

        PrintWriter out = resp.getWriter();

        String identifiantUtilisateurConnecte = (String) req.getSession().getAttribute("utilisateurConnecte");
        if(identifiantUtilisateurConnecte == null || "".equals(identifiantUtilisateurConnecte)) {
            out.println("<!DOCTYPE html>");
            out.println("<html class=\"registration\">");
            out.println("<!-- Titre de l'onglet -->");
            out.println("<head>");
            out.println("<meta charset='UTF-8'>");
            out.println("<meta content='text/html; charset=utf-8' http-equiv='Content-Type'>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"../css/login.css\">");
            out.println("<link rel=\"stylesheet\" href=\"css/w3style.css\">");
            out.println("<link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Lato\">");
            out.println("<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">");
            out.println("<link rel='stylesheet prefetch' href='http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/themes/smoothness/jquery-ui.css'>");

            out.println("<title>POK'HEIR - Login</title>");
            out.println("</head>");
            out.println("<!-- Formulaire de connexion avec pseudo et mot de passe -->");
            out.println("<body>");

            out.println("        <div class=\"w3-top\">");
            out.println("        <div class=\"w3-bar w3-show w3-card w3-animate-top w3-white\" id=\"myNavbar\">");
            out.println("            <a class=\"w3-bar-item w3-button w3-hover-black w3-hide-medium w3-hide-large w3-right\" href=\"javascript:void(0);\" onclick=\"toggleFunction()\" title=\"Toggle Navigation Menu\">");
            out.println("                <i class=\"fa fa-bars\"></i>");
            out.println("            </a>");
            out.println("            <a href=\"accueil#home\" class=\"w3-bar-item w3-button\">HOME</a>");
            out.println("            <a href=\"accueil#about\" class=\"w3-bar-item w3-button w3-hide-small\"><i class=\"fa fa-user\"></i> ABOUT</a>");
            out.println("            <a href=\"accueil#portfolio\" class=\"w3-bar-item w3-button w3-hide-small\"><i class=\"fa fa-book\"></i> INFOS</a>");
            out.println("            <a href=\"classement\" class=\"w3-bar-item w3-button w3-hide-small\"><i class=\"fa fa-line-chart\"></i> CLASSEMENT</a>");
            out.println("            <a href=\"tournois\" class=\"w3-bar-item w3-button w3-hide-small\"><i class=\"fa fa-star\"></i> TOURNOIS</a>");
            out.println("            <a href=\"accueil#contact\" class=\"w3-bar-item w3-button w3-hide-small\"><i class=\"fa fa-envelope\"></i> CONTACT</a>");
            out.println("            <a href=\"login\" class=\"w3-bar-item w3-button w3-right w3-hide-small\">CONNEXION</a>");
            out.println("            <a href=\"register\" class=\"w3-bar-item w3-button w3-right w3-hide-small\">S'ENREGISTRER</a>");
            out.println("                </div>");
            out.println("");
            out.println("        <!-- Navbar on small screens -->");
            out.println("        <div id=\"navDemo\" class=\"w3-bar-block w3-white w3-hide w3-hide-large w3-hide-medium\">");
            out.println("            <a href=\"accueil#about\" class=\"w3-bar-item w3-button\" onclick=\"toggleFunction()\">ABOUT</a>");
            out.println("            <a href=\"accueil#portfolio\" class=\"w3-bar-item w3-button\" onclick=\"toggleFunction()\">INFOS</a>");
            out.println("            <a href=\"classement\" class=\"w3-bar-item w3-button\" onclick=\"toggleFunction()\">CLASSEMENT</a>");
            out.println("            <a href=\"tournois\" class=\"w3-bar-item w3-button\" onclick=\"toggleFunction()\">TOURNOIS</a>");
            out.println("            <a href=\"accueil#contact\" class=\"w3-bar-item w3-button\" onclick=\"toggleFunction()\">CONTACT</a>");
            out.println("            <a href=\"login\" class=\"w3-bar-item w3-button\" onclick=\"toggleFunction()\">CONNEXION</a>");
            out.println("            <a href=\"register\" class=\"w3-bar-item w3-button\" onclick=\"toggleFunction()\">S'ENREGISTRER</a>");
            out.println("                </div>");
            out.println("    </div>");

            out.println("<div class=\"registration-box-container\">");
            out.println("<div class=\"registration-box\">");
            out.println("<div class=\"registration-box-heading\">");
            out.println("<img src=\"img/logo4.png\" width=\"300px\" ></img>");
            out.println("<div class=\"registration-box-content\">");
            out.println("<div class=\"login\">");
            out.println("<form method=\"post\">");
            out.println("<div class=\"pad-block\">");
            out.println("<div class=\"input-label\">Email:</div>");
            out.println("<input id=\"id_email\" type=\"text\" name=\"email\" required maxlength=\"75\">");
            out.println("</div>");
            out.println("<div class=\"pad-block\">");
            out.println("<div class=\"input-label\">Mot de Passe:</div>");
            out.println("<input type=\"password\" name=\"password\" required id=\"id_password\">");
            out.println("</div>");
            out.println("</br>");
            out.println("<div class=\"pad-block\">");
            out.println("<input class=\"w3-btn w3-amber w3-border-black w3-round-xxlarge\" type=\"submit\" value=\"Se Connecter\" /></div>");
            out.println("<div class=\"pad-block login-register-text\">");
            out.println("<div>Tu veux nous rejoindre?  <a href=\"register\">Inscrit toi !</a></div>");
            out.println("</div>");
            out.println("</form>");
            out.println("</div>");
            out.println("</div>");
            out.println("</div>");
            out.println("</div>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }else
        { resp.sendRedirect("compte");}


    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email=req.getParameter("email");
        String password1= MembreLibrary.getInstance().getMdp(email);
        String password2=req.getParameter("password");

        if (password1==null){
            password1="";
        }

        if (password1.equals(password2)) {
            req.getSession().setAttribute("utilisateurConnecte",email);
            resp.sendRedirect("accueil");
        } else{
            resp.sendRedirect("login");
        }

    }
}

