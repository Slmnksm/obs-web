<%-- 
    Document   : studentLectures
    Created on : 24.Ağu.2016, 10:41:22
    Author     : S.KasımYurtaslan
--%>

<%@page import="tr.kasim.system.model.Lecture"%>
<%@page import="tr.kasim.system.app.Application"%>
<%@page import="tr.kasim.system.model.Student"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Öğrencinin Derslerini Göster</title>
    <link rel="stylesheet" type="text/css" href="css/index.css"></link>
</head>
<body><center>
    <p class="title">Öğrencinin Aldığı Dersler</p>
    <table>
        <tr>
            <td>Öğrenci Numarasi Giriniz:</td>
            <td><input type="text" name="no"/></td>
        </tr>
        
        <tr>
        <th>Adi</th>
        <th>Kodu</th>
        <th>Kapasitesi</th>
        </tr>
        <%
            Student student = new Student();
            List<Lecture> lectures = Application.getApp().getMainService().getLectures();

            if ("no" == student.getStudentNumber()) {
                for (Lecture lecture : lectures) {
        %>
        <tr>
            <td><%=(lecture.getName())%></td>
            <td><%=(lecture.getCode())%></td>
            <td><%=(lecture.getCapacity())%></td>
        </tr>
        <%}
            }
        %>

    </table>
    <tr>
    <br><br><br><br>
    <td>&nbsp;</td>
    <td><input type="submit" value="Tamam"/></td>
</tr>
<br/><br><br>
<a href="index.jsp">Ana Sayfaya Dön</a><br>
</center>
</body>
</html>
