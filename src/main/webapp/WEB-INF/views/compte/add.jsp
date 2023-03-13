<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<%@include file="../home/header.jsp" %>
<main id="main" class="main">


    <section class="section">
        <div class="row">
        	<c:if test="${success != null }">
            <div style="background-color: greenyellow; margin-bottom: 30px; text-align: center; border-radius: 30px; padding: 10px; color: black">${success}</div>
            </c:if>
            <div class="col-lg-6 m-auto ">

                <form action="Compte" method="post" class="form p-5 form-control bg-info-light">
                    <label>Username Compte</label>
                    <input type="text" name="username" class="form-control form mt-2"> <br>
                    <label>Password Compte</label>
                    <input type="password" name="pass" class="form-control form mt-2"> <br>
                    <label>Droit Compte</label>
                    <select name="droits" id="" class="form-control form mt-2">
                    <c:if test="${droit != null }">
                    	<c:forEach items="${droits }" var="d">
                    		<option value="${d.id}">${d.name}</option>
                    	</c:forEach>
					</c:if>
                    </select>
                    <input type="submit" value="Enregistrer" class="btn btn-success mt-2"> <br>

                    <a href="Home">Allez à l'accueil</a>
                </form>

            </div>


        </div>
    </section>

</main><!-- End #main -->

<%@include file="../home/footer.jsp" %>

</html>
