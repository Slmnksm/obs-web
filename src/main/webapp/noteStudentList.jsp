<%-- 
    Document   : noteStudentList
    Created on : 24.Ağu.2016, 11:34:06
    Author     : S.KasımYurtaslan
--%>

<%@page import="tr.kasim.system.app.Application"%>
<%@page import="java.util.List"%>
<%@page import="tr.kasim.system.model.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Öğrencinin Notlarini Listele</title>
    <link rel="stylesheet" type="text/css" href="css/index.css"></link>
</head>
<body><center>
    <p class="title">Derse Öğrenci Ekleme</p>
    <table>
        <tr>
            <td>Öğrenci No Giriniz:</td>
            <td><input type="text" name="no"/></td>

        </tr>

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
