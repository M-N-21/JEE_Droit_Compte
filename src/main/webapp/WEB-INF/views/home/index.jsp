<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<%@include file="header.jsp" %>

<main id="main" class="main">

    <div class="pagetitle">
        <h1>Home Page</h1>
        <nav>
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="index.html">Home</a></li>
                <li class="breadcrumb-item">Home</li>
                <li class="breadcrumb-item active">Home</li>
            </ol>
        </nav>
    </div><!-- End Page Title -->

    <section class="section">
        <div class="row">
        	<c:if test="${success != null }">
        	
        	
            <%-- if(request.getAttribute("success") != null) {--%>
            <div style="background-color: greenyellow; margin-bottom: 30px; text-align: center; border-radius: 30px; padding: 10px; color: black"><%=request.getAttribute("success")%></div>
           	</c:if>
            <%--}--%>
            <div class="col-lg-6">

                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">ICI ON CODE</h5>
                    </div>
                </div>

            </div>

        </div>
    </section>

</main><!-- End #main -->

<%@include file="footer.jsp" %>

</html>