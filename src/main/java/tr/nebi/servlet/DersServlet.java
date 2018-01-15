/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.nebi.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tr.kasim.system.app.Application;
import tr.kasim.system.model.Lecture;

/**
 *
 * @author S.KasımYurtaslan
 */
@WebServlet(urlPatterns = {"/drservlet"})
public class DersServlet extends HttpServlet {

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

            String action = req.getParameter("action");

            if ("addLecture".equals(action)) {
                addLecture(req, resp);
            }

        } catch (Exception ex) {
            Logger.getLogger(OgrenciServlet.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (out != null) {
                out.flush();
                out.close();
            }
        }
    }

    public void addLecture(HttpServletRequest req, HttpServletResponse resp) throws Exception, IOException {

        String ad = req.getParameter("ad");
        String kod = req.getParameter("kod");
        String kapasite = req.getParameter("kapasite");

        Lecture lecture = new Lecture(null,ad,kod,kapasite);
        
        Application.getApp().getMainService().addLecture(lecture);
        resp.sendRedirect("./dersList.jsp");
    }

}
