/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.nebi.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tr.kasim.system.app.Application;
import tr.kasim.system.model.Student;

/**
 *
 * @author S.KasımYurtaslan
 */
@WebServlet(loadOnStartup = 1, urlPatterns = {"/init"})
public class InitServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        Application.getApp();
    }

    @Override
    public void destroy() {
        Application.getApp().destroy();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doProcess(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doProcess(req, resp);
    }

    protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = null;
        try {
            out = new PrintWriter(resp.getOutputStream());

            out.println("<html><body>");

            out.println("Benim web servisim<br>");
            out.println("<br>");
            out.println("<br>");
            out.println("Parametreler:<br>");

            Map<String, String[]> parameters = req.getParameterMap();
            for (String paramName : parameters.keySet()) {
                out.println(paramName + "-->" + parameters.get(paramName)[0] + "<br>");
            }

            List<Student> students = Application.getApp().getMainService().getStudents();

            for (Student student : students) {
                out.println(student.getName() + " " + student.getSurname() + "<br>");
            }

            out.println("<br>");
            out.println("Bitti");

            out.println("</body></html>");

        } catch (Exception ex) {
            Logger.getLogger(InitServlet.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (out != null) {
                out.flush();
                out.close();
            }
        }

    }
}
