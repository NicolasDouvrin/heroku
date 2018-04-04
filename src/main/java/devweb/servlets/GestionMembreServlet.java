package devweb.servlets;

import devweb.managers.MembreLibrary;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deletemembre")
public class GestionMembreServlet extends GenericServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");

        String identifiant = req.getParameter("emailsupp");
        System.out.println(identifiant);

        try {
            MembreLibrary.getInstance().deleteMembre(identifiant);
        } catch (IllegalArgumentException e) {
            req.getSession().setAttribute("deleteMembreErrorMessage", e.getMessage());
        }
        resp.sendRedirect("compteadmin");

    }
}