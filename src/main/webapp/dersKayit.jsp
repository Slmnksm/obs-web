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
      <title>Ders Kayit</title>
      <link rel="stylesheet" type="text/css" href="css/index.css"></link>
</head>
<body><center>
    <p class="title">Ders Kayıt</p>
    <form method="post" action="drservlet">
        <input type="hidden" name="action" value="addLecture"/>
        <table>
            <tr>
                <td>Ad:</td>
                <td><input type="text" name="ad"/></td>
            </tr>
            <tr>
                <td>Kod:</td>
                <td><input type="text" name="kod"/></td>
            </tr>
            <tr>
                <td>Kapasite:</td>
                <td><input type="text" name="kapasite"/></td>
            </tr>
            <td>&nbsp;</td>
            <td><input type="submit" value="Tamam"/></td>
            </tr>
        </table>
        <br><br><br><br>
        <a href="index.jsp">Ana Sayfaya Dön</a><br>
    </form>
</center>
</body>
</html>
