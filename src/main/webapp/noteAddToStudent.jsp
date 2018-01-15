<%-- 
    Document   : noteKayit
    Created on : 24.Ağu.2016, 09:53:53
    Author     : S.KasımYurtaslan
--%>
<%@page import="tr.kasim.system.util.GeneralUtil"%>
<%@page import="tr.kasim.system.model.Lecture"%>
<%@page import="tr.kasim.system.app.Application"%>
<%@page import="tr.kasim.system.model.Student"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%

    Integer lectureId = GeneralUtil.toInt(request.getParameter("lectureId"));

    List<Lecture> lectures = null;
    Lecture lecture = new Lecture();
    if (lectureId == null) {
        lectures = Application.getApp().getMainService().getLectures();
    } else {
        lecture = (Lecture) Application.getApp().getMainService().getById(lectureId, Lecture.class);
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Öğrenciye Not Ekle</title>
    <link rel="stylesheet" type="text/css" href="css/index.css"></link>
</head>
<body>
<center>
    <p class="title">Öğrenciye Not Ekle</p>
    <form action="noteAddToStudent.jsp">
        <% if (lectures != null) {%>
        <table style="border: black 1px solid">
            <tr>
                <td>Ders Kodunu Seciniz : </td>
                <td>
                    <select name="lectureId">
                        <%
                            for (Lecture lec : lectures) {
                        %>
                        <option value="<%=(lec.getId())%>"><%=(lec.getName())%></option>
                        <%                        }
                        %>
                    </select> 

                </td>
            </tr>
        </table>
        <%} else {
        %>
        <p><%=(lecture.getName())%></p>


        <table style="border: black 1px solid">
            <tr>
                <td>Adi</td>
                <td>Soyadi</td>
                <td>Numarasi</td>
                <td>Not</td>
            </tr>
            <%
                for (Student student : lecture.getStudents()) {
            %>
            <tr>
                <td><%=(student.getName())%></td>
                <td><%=(student.getSurname())%></td>
                <td><%=(student.getStudentNumber())%></td>
                <td><input type="text" name="s_<%=(student.getId())%>" value="" size="3"/></td>
            </tr>
            <%}
            %>
        </table>


        <%
                }
            }%>
        <br><br><br><br>
        <input type="submit" value="Tamam"/>
    </form>
    <br/><br><br>
    <a href="index.jsp">Ana Sayfaya Dön</a><br>
</center>
</body>
</html>
