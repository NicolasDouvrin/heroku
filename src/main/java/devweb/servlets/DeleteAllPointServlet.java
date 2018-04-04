package devweb.servlets;

import devweb.managers.MembreLibrary;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/delpoint")
public class DeleteAllPointServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        try {
            MembreLibrary.getInstance().deleteAllPoint();
        } catch (IllegalArgumentException e) {
            req.getSession().setAttribute("delpointErrorMessage", e.getMessage());
        }
        resp.sendRedirect("/tournoiadmin");
    }

}