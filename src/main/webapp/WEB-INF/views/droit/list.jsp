<!-- controle, iterations, tests, variables -->

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="../home/header.jsp" %>
<main id="main" class="main">
	<c:if test="${success != null }">
    	<div style="background-color: greenyellow; margin-bottom: 30px; text-align: center; border-radius: 30px; padding: 10px; color: black">${success}</div>
     </c:if>
     <c:if test="${error != null }">
    	<div style="background-color: indianred; margin-bottom: 30px; text-align: center; border-radius: 30px; padding: 10px; color: black">${error}</div>
     </c:if>
    <table class="table w-50 table-striped table-info">
        <tr>
            <td>Id</td>
            <td>Nom Droit</td>
            <td>Action</td>
        </tr>
        <c:forEach items="${droits }" var="droit">
            <tr>
                <td> <c:out value="${droit.id}"></c:out> </td>
                <td>${droit.name}  </td>
                <td>
					<a href="Droit?page=edit&id=${droit.id}">Editer</a>
                	<a href="Droit?page=delete&id=${droit.id}" onclick="return confirm('Voulez-vous vraiment supprimer?')">Supprimer</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</main><!-- End #main -->

<!-- ======= Footer ======= -->
<%@include file="../home/footer.jsp" %>