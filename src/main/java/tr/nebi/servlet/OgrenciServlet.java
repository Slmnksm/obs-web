/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.nebi.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tr.kasim.system.app.Application;
import tr.kasim.system.util.GeneralUtil;
import tr.kasim.system.login.LoginType;
import tr.kasim.system.model.Lecture;
import tr.kasim.system.model.Student;
import tr.kasim.system.model.User;


/**
 *
 * @author S.KasımYurtaslan
 */
@WebServlet(urlPatterns = {"/ogrservlet"})
public class OgrenciServlet extends HttpServlet {

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
            String action1 = req.getParameter("action1");

            if ("addStudent".equals(action)) {
                addStudent(req, resp);
            }
            if ("addStudentToLecture".equals(action1)) {
                addStudentToLecture(req, resp);
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

    public void addStudent(HttpServletRequest req, HttpServletResponse resp) throws Exception, IOException {
        String ad = req.getParameter("ad");
        String soyad = req.getParameter("soyad");
        String no = req.getParameter("no");
        String adres = req.getParameter("adres");
        String tel = req.getParameter("tel");

        Student student = new Student(null, ad, soyad, adres, tel, no);
        student.setUser(new User());
        student.getUser().setUsername(no);
        student.getUser().setPassword("1");
        student.getUser().setType(LoginType.Student.getType());

        Application.getApp().getMainService().saveStudent(student);

        resp.sendRedirect("./ogrenciList.jsp");
    }

    public void addStudentToLecture(HttpServletRequest req, HttpServletResponse resp) throws Exception, IOException{

        Student student = new Student();
        String number = req.getParameter("no");
        student.setStudentNumber(number);
        
        Lecture lecture = new Lecture();
        String code = req.getParameter("kod");
        lecture.setCode(code);
        
        if (student.getLectures() == null) {
            student.setLectures(new ArrayList());
        }
         
        student.getLectures().add(lecture);
        Application.getApp().getMainService().saveStudent(student);
    }

}
