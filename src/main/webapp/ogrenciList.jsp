<%-- 
    Document   : ogrenciList
    Created on : 18.Ağu.2016, 09:35:47
    Author     : S.KasımYurtaslan
--%>

<%@page import="tr.kasim.system.app.Application"%>
<%@page import="tr.kasim.system.model.Student"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/index.css"></link>
      <title>Öğrenci Listesi</title>
    
</head>
<body><center>
    <p class="title">Ogrenci Listesi</p>

    <table style="border: black 1px solid">
        <tr>
            <td>Adi</td>
            <td>Soyadi</td>
            <td>Numarasi</td>
        </tr>
        <%
            List<Student> students = Application.getApp().getMainService().getStudents();
            for (Student student : students) {
        %>
        <tr>
            <td><%=(student.getName())%></td>
            <td><%=(student.getSurname())%></td>
            <td><%=(student.getStudentNumber())%></td>
        </tr>
        <%}
        %>
    </table>
    <br/><br><br>
        <a href="index.jsp">Ana Sayfaya Dön</a><br>
</center>
</body>
</html>
