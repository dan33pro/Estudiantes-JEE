<%-- 
    Document   : cursoInfo.jsp
    Created on : 8/04/2023, 11:31:45 AM
    Author     : ducar
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Registrar Curso</title>
    </head>
    <body>
        <h1>Información Curso</h1>
        <form action="./CursoServlet" method="POST">
            <table>
                <tr>
                    <td><label for="COD_Curso">Cod Curso</label></td>
                    <td><input type="text" name="COD_Curso" value="${curso.codCurso}" /></td>
                </tr>
                <tr>
                    <td><label for="Nombre">Nombre Curso</label></td>
                    <td><input type="text" name="Nombre" value="${curso.nombreCurso}" /></td>
                </tr>
                <tr>
                    <td><label for="Creditos">Numero de creditos</label></td>
                    <td><input type="text" name="Creditos" value="${curso.numCreditosCurso}" /></td>
                </tr>
                <tr>
                    <td><label for="Semestre">Semestre del curso</label></td>
                    <td><input type="text" name="Semestre" value="${curso.semestreCurso}" /></td>
                </tr>
                <tr>
                    <td><label for="N_Admitidos">Numero de admitidos</label></td>
                    <td><input type="text" name="N_Admitidos" value="${curso.numEstudAdmitidosCurso}" /></td>
                </tr>
                <tr>
                    <td><label for="P_Curso">Precio Curso</label></td>
                    <td><input type="text" name="P_Curso" value="${curso.precioCurso}" /></td>
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
            <th>COD</th>
            <th>Nombre Curso</th>
            <th>Numero de Creditos</th>
            <th>Semestre</th>                
            <th>Admitidos</th>            
            <th>Precio</th>
            <c:forEach items="${allCurs}" var="curs">
                <tr>
                    <td>${curs.codCurso}</td>
                    <td>${curs.nombreCurso}</td>
                    <td>${curs.numCreditosCurso}</td>
                    <td>${curs.semestreCurso}</td>                        
                    <td>${curs.numEstudAdmitidosCurso}</td>                    
                    <td>${curs.precioCurso}</td>
                </tr>
            </c:forEach> 
        </table>
        <br>
        <a href="/EstudianteJEE-war/estudianteInfo.jsp">Panel de Estudiante</a>        
        <a href="/EstudianteJEE-war/cursoInfo.jsp">Panel de Curso</a>
        <a href="/EstudianteJEE-war/matricular.jsp">Matricular Estudiante</a>
    </body>
</html>
