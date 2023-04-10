<%-- 
    Document   : matricular
    Created on : 9/04/2023, 02:49:27 PM
    Author     : ducar
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Matricular estudiante</title>
    </head>
    <body>
        <h1>Matricular estudiante</h1>
        <form action="MatriculaServlet" method="POST">
            <table>
                <tr>
                    <td><label for="codCurso">COD Curso</label></td>                    
                    <td>
                        <select name="codCurso" id="codCurso">
                            <c:forEach items="${allCurs}" var="curs">
                                <option value="${curs.codCurso}">
                                    COD: ${curs.codCurso} - ${curs.nombreCurso}</span>
                                </option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td><label for="estID">ID Estudiante</label></td>                    
                    <td>
                        <select name="estID" id="estID">
                            <c:forEach items="${allStuds}" var="stud">
                                <option value="${stud.estudianteId}">
                                    ID: ${stud.estudianteId} - ${stud.firstName} ${stud.lastName}
                                </option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" name="action" value="Add" />
                        <input type="submit" name="action" value="Delete" />
                        <input type="submit" name="action" value="Search" />
                    </td>                    
                </tr>
            </table>
        </form>
        <br>
        <table border="1">
            <th>COD Curso</th>
            <th>ID Estudiante</th>
            <th>Fecha M</th>
            <c:forEach items="${allMatri}" var="matri">
                <tr>
                    <td>${matri.matriculaPK.codigoCurso}</td>
                    <td>${matri.matriculaPK.estudianteId}</td>
                    <td>${matri.matFecha}</td>
                </tr>
            </c:forEach> 
        </table>
        <br>
        <a href="/EstudianteJEE-war/estudianteInfo.jsp">Panel de Estudiante</a>        
        <a href="/EstudianteJEE-war/cursoInfo.jsp">Panel de Curso</a>
        <a href="/EstudianteJEE-war/matricular.jsp">Matricular Estudiante</a>
    </body>
</html>
