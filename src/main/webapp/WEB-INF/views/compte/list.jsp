<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<%@include file="../home/header.jsp" %>
<main id="main" class="main">


    <section class="section">
        <div class="row">
            <c:if test="${success != null }">
		    	<div style="background-color: greenyellow; margin-bottom: 30px; text-align: center; border-radius: 30px; padding: 10px; color: black">${success}</div>
		     </c:if>
		     <c:if test="${error != null }">
		    	<div style="background-color: indianred; margin-bottom: 30px; text-align: center; border-radius: 30px; padding: 10px; color: black">${error}</div>
		     </c:if>
            <div class="col-lg-6">

                <table class="table-info table table-striped">
                    <tr>
                        <td>Id</td>
                        <td>Username</td>
                        <td>Action</td>
                    </tr>
                   <c:forEach items="${comptes }" var="c">
			            <tr>
			                <td> ${c.id} </td>
			                <td>${c.username}  </td>
			            	<td>
			            		<a href="Compte?page=delete&id=${c.id }" onclick="return confirm('Voulez-vous vraiment supprimer?')">Supprimer</a>
			            	</td>
			            </tr>
			        </c:forEach>
                </table>

            </div>


        </div>
    </section>

</main><!-- End #main -->

<%@include file="../home/footer.jsp" %>
</html>
