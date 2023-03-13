<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">

<%@include file="../home/header.jsp" %>
<main id="main" class="main">


    <section class="section">
        <div class="row">
            <c:if test="${success != null }">
            <div style="background-color: greenyellow; margin-bottom: 30px; text-align: center; border-radius: 30px; padding: 10px; color: black">${success}</div>
            </c:if>
            <div class="col-lg-6 m-auto">

                <form action="Droit" method="post" class="form p-5 form-control bg-info-light">
                	<input type="text" hidden name="id" value="${droit.id }">
                    <label>Nom Droit</label>
                    <input type="text" name="name" value="${droit.name }" class="form form-control mt-2">
                    <input type="submit" class="btn btn-success mt-2" value="Enregistrer"> <br>

                    <a href="Home">Allez à l'accueil</a>
                </form>

            </div>


        </div>
    </section>

</main><!-- End #main -->
<%@include file="../home/footer.jsp" %>