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
    <body style="margin: 0; padding: 0; width: 100vw; height: 100vh; box-sizing: border-box; display: flex; align-items: center; justify-content: center; flex-direction: column; background: buttonface">
        <article style="display: flex; gap: 20px; padding: 20px 40px; border-radius: 12px">
            <div style="background: white; padding: 20px 40px; border-radius: 12px; box-shadow: 2px 2px 2px black">
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
                            <tr style="display: grid;">
                            <td colspan="2" style="display: grid; grid-auto-flow: column; gap:10px; margin-top: 20px">
                                <input type="submit" name="action" value="Add" style="padding: 10px; border-radius: 8px; border: 1px solid black"/>
                                <input type="submit" name="action" value="Delete" style="padding: 10px; border-radius: 8px; border: 1px solid black"/>
                                <input type="submit" name="action" value="Search" style="padding: 10px; border-radius: 8px; border: 1px solid black"/>
                            </td>
                        </tr>                   
                        </tr>
                    </table>
                </form>
            </div>
            <div style="display: flex; align-items: center; justify-content: center; background: white; padding: 20px 40px; border-radius: 12px; box-shadow: 2px 2px 2px black">
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
