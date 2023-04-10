<%-- 
    Document   : estudianteInfo
    Created on : 28/03/2023, 02:23:47 PM
    Author     : DanielC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Información del Estudiante</title>
    </head>
    <body>
        <h1>Información del Estudiante</h1>
        <form action="./EstudianteServlet" method="POST">
            <table>
                <tr>
                    <td>Estudiante Id</td>
                    <td><input type="text" name="estudianteId" value="${student.estudianteId}" /></td>
                </tr>
                <tr>
                    <td>First Name</td>
                    <td><input type="text" name="firstName" value="${student.firstName}" /></td>
                </tr>
                <tr>
                    <td>Last Name</td>
                    <td><input type="text" name="lastName" value="${student.lastName}" /></td>
                </tr>
                <tr>
                    <td>Year Level</td>
                    <td><input type="text" name="yearLevel" value="${student.yearLevel}" /></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" name="action" value="Add" />
                        <input type="submit" name="action" value="Edit" />
                        <input type="submit" name="action" value="Delete" />
                        <input type="submit" name="action" value="Search" />
                    </td>
                </tr>
            </table>
        </form>
        <br>
        <table border="1">
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Year Level</th>
                <c:forEach items="${allStudents}" var="stud">
                <tr>
                    <td>${stud.estudianteId}</td>
                    <td>${stud.firstName}</td>
                    <td>${stud.lastName}</td>
                    <td>${stud.yearLevel}</td>
                </tr>
            </c:forEach> 
        </table>
        <br>
        <a href="/EstudianteJEE-war/estudianteInfo.jsp">Panel de Estudiante</a>        
        <a href="/EstudianteJEE-war/cursoInfo.jsp">Panel de Curso</a>
        <a href="/EstudianteJEE-war/matricular.jsp">Matricular Estudiante</a>
    </body>
</html>
