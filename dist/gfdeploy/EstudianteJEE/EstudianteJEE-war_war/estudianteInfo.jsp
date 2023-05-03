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
    <body style="margin: 0; padding: 0; width: 100vw; height: 100vh; box-sizing: border-box; display: flex; align-items: center; justify-content: center; flex-direction: column; background: buttonface">
        <article style="display: flex; gap: 20px; padding: 20px 40px; border-radius: 12px">
            <div style="background: white; padding: 20px 40px; border-radius: 12px; box-shadow: 2px 2px 2px black">
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
                        <tr style="display: grid;">
                            <td colspan="2" style="display: grid; grid-auto-flow: column; gap:10px; margin-top: 20px">
                                <input type="submit" name="action" value="Add" style="padding: 10px; border-radius: 8px; border: 1px solid black"/>
                                <input type="submit" name="action" value="Edit" style="padding: 10px; border-radius: 8px; border: 1px solid black"/>
                                <input type="submit" name="action" value="Delete" style="padding: 10px; border-radius: 8px; border: 1px solid black"/>
                                <input type="submit" name="action" value="Search" style="padding: 10px; border-radius: 8px; border: 1px solid black"/>
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
            <div style="display: flex; align-items: center; justify-content: center; background: white; padding: 20px 40px; border-radius: 12px; box-shadow: 2px 2px 2px black">
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
            </div>
        </article>     
        <br>
        <div style="display: grid; gap: 10px; grid-auto-flow: column">
            <a href="/EstudianteJEE-war/estudianteInfo.jsp" style="padding: 20px; background: white; border-radius: 12px; text-decoration: none; text-align: center; box-shadow: 2px 2px 2px black">Panel de Estudiante</a>        
            <a href="/EstudianteJEE-war/cursoInfo.jsp" style="padding: 20px; background: white; border-radius: 12px; text-decoration: none; text-align: center; box-shadow: 2px 2px 2px black">Panel de Curso</a>
            <a href="/EstudianteJEE-war/matricular.jsp" style="padding: 20px; background: white; border-radius: 12px; text-decoration: none; text-align: center; box-shadow: 2px 2px 2px black">Matricular Estudiante</a>
        </div>
    </body>
</html>
