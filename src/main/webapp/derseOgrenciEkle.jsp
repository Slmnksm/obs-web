<%-- 
    Document   : derseÖğrenciEkle
    Created on : 24.Ağu.2016, 11:27:48
    Author     : S.KasımYurtaslan
--%>

<%@page import="tr.kasim.system.model.Student"%>
<%@page import="tr.kasim.system.app.Application"%>
<%@page import="java.util.List"%>
<%@page import="tr.kasim.system.model.Lecture"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Derse Öğrenci Ekleme</title>
    <link rel="stylesheet" type="text/css" href="css/index.css"></link>
</head>
<body><center>
    <p class="title">Derse Öğrenci Ekleme</p>
    <form method="post" action1="ogrservlet" value="addStudentToLecture">
        <table>
            <tr>
                <td>Ders Kodu Giriniz:</td>
                 <td><input type="text" name="kod"/></td>
            </tr>
            
            <tr>
                <td>Öğrenci No Giriniz:</td>
                 <td><input type="text" name="no"/></td>
            </tr>
           
        </table>
        
        <br><br><br><br>
        <td>&nbsp;</td>
        <td><input type="submit" value="Tamam"/></td>
        
        <br/><br><br>
        <a href="index.jsp">Ana Sayfaya Dön</a><br>
    </form>
</center>
</body>
</html>
