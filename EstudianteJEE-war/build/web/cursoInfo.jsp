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
    <body style="margin: 0; padding: 0; width: 100vw; height: 100vh; box-sizing: border-box; display: flex; align-items: center; justify-content: center; flex-direction: column; background: buttonface">
        <article style="display: flex; gap: 20px; padding: 20px 40px; border-radius: 12px">
            <div style="background: white; padding: 20px 40px; border-radius: 12px; box-shadow: 2px 2px 2px black">
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
