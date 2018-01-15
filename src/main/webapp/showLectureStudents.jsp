<%-- 
    Document   : lectureStudents
    Created on : 24.Ağu.2016, 10:46:47
    Author     : S.KasımYurtaslan
--%>

<%@page import="tr.kasim.system.model.Student"%>
<%@page import="tr.kasim.system.app.Application"%>
<%@page import="java.util.List"%>
<%@page import="tr.kasim.system.model.Lecture"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    Lecture lecture = new Lecture();


%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Dersi Alan Öğrencileri Göster</title>
    <link rel="stylesheet" type="text/css" href="css/index.css"></link>
</head>
<body><center>
    <p class="title">Dersi Alan Öğrenciler</p>
    <table>
        <tr>
            <td>Ders Kodu Giriniz:</td>
            <td><input type="text" name="kod"/></td>
            
        </tr>
    </table>

    <tr>
    <br><br><br><br>
    <td><input type="submit" value="Tamam"/></td>
</tr>  
<br/><br><br>
<a href="index.jsp">Ana Sayfaya Dön</a><br>
</center>

</body>
</html>
