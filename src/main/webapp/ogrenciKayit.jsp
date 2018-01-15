<%-- 
    Document   : a
    Created on : 18.Ağu.2016, 09:00:46
    Author     : S.KasımYurtaslan
--%>

<%@page import="java.util.List"%>
<%@page import="tr.kasim.system.app.Application"%>
<%@page import="tr.kasim.system.model.Lecture"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     <title>Öğrenci Kayit</title>
    <link rel="stylesheet" type="text/css" href="css/index.css"></link>
</head>
<body><center>
     <p class="title">Yeni Öğrenci Kayıt</p>
    
    <form method="post" action="ogrservlet">
        <input type="hidden" name="action" value="addStudent"/>
        <table>
            <tr>
                <td>Ad:</td>
                <td><input type="text" name="ad"/></td>
            </tr>
            <tr>
                <td>soyad:</td>
                <td><input type="text" name="soyad"/></td>
            </tr>
            <tr>
                <td>no:</td>
                <td><input type="text" name="no"/></td>
            </tr>
            <tr>
                <td>tel:</td>
                <td><input type="text" name="tel"/></td>
            </tr>
            <tr>
                <td>adres:</td>
                <td><input type="text" name="adres"/></td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td><input type="submit" value="Tamam"/></td>
            </tr>
        </table>
        <br/><br><br>
        <a href="index.jsp">Ana Sayfaya Dön</a><br>
        </center>
    </form>

</body>
</html>
