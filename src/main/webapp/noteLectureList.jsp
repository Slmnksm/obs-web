<%-- 
    Document   : list_note
    Created on : 24.Ağu.2016, 08:56:13
    Author     : S.KasımYurtaslan
--%>

<%@page import="tr.kasim.system.app.Application"%>
<%@page import="tr.kasim.system.model.Lecture"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Not Listesi</title>
    <link rel="stylesheet" type="text/css" href="css/index.css"></link>
</head>
<body><center>

    <p class="title">Not Listesi</p>
    <table>
        <tr>
            <td>Ders Kodu Giriniz:</td>
            <td><input type="text" name="no"/></td>
        </tr>
    </table>
    <tr>
    <br><br><br><br>
    <td>&nbsp;</td>
    <td><input type="submit" value="Tamam"/></td>
</tr>
<br><br><br><br>
<a href="index.jsp">Ana Sayfaya Dön</a><br>
</center>
</body>
</html>
