<%-- 
    Document   : ogrenciList
    Created on : 18.Ağu.2016, 09:35:47
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
       <title>Ders Listesi</title>
    <link rel="stylesheet" type="text/css" href="css/index.css"></link>
</head>
<body><center>
    <p class="title">Ders Listesi</p>

    <table >
        <tr>
            <th>Adi</th>
            <th>Kodu</th>
            <th>Kapasitesi</th>
        </tr>
        <%
            List<Lecture> lectures = Application.getApp().getMainService().getLectures();
            for (Lecture lecture : lectures) {
        %>
        <tr>
            <td><%=(lecture.getName())%></td>
            <td><%=(lecture.getCode())%></td>
            <td><%=(lecture.getCapacity())%></td>
        </tr>
        <%}
        %>
    </table>
    <br/><br><br>
    <a href="index.jsp">Ana Sayfaya Dön</a><br>
</center>
</body>
</html>
