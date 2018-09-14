<%@ page import="parts.utils.Filters" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="parts" class="java.util.ArrayList" scope="session"/>

<html>
<head>
    <title>Parts list</title>
</head>
<body>
<table border="0" cellpadding="1" cellspacing="1" style="width:500px">

    <form action="/list" id="Apply" method="get" name="SearchOption">
        <p align="center"><br>
            <input <c:if test="${sort == Filters.ALL}"> checked="checked"</c:if> name="sort" type="radio" value="ALL">ALL
            <input <c:if test="${sort == Filters.REQUIRED}"> checked="checked"</c:if> name="sort" type="radio" value="REQUIRED">REQUIRED
            <input <c:if test="${sort == Filters.OPTIONAL}"> checked="checked"</c:if> name="sort" type="radio" value="OPTIONAL">OPTIONAL
        </p>
        <p align="center">Search:
            <input type="text" name="search" value="<c:out value="${search}"/>">
            <input type="hidden" name="currentPage" value="<c:out value="1"/>">
            <input type="submit" value="Apply">
        </p>
    </form>

    <table align="center" border="1" cellpadding="1" cellspacing="1" style="width:600px">
        <caption><p>Parts list</p></caption>
        <tbody>
        <tr>
            <td style="text-align:center"><b>Name</b> <a href="/addPart">add new</a></td>
            <td style="text-align:center"><b>Type</b></td>
            <td style="text-align:center"><b>Required/Optional</b></td>
            <td style="text-align:center"><b>Count</b></td>
            <td style="text-align:center"><b>edit</b></td>
            <td style="text-align:center"><b>delete</b></td>
        </tr>

        <c:forEach items="${parts}" var="part">
            <tr><td style="text-align:center">${part.name}</td>
                <td style="text-align:center">${part.type}</td>
                <td style="text-align:center">${part.required}</td>
                <td style="text-align:center">${part.count}</td>
                <td style="text-align:center"><a href="/editPart?id=<c:out value="${part.id}"/>">edit</a></td>
                <td style="text-align:center"><a href="/deletePart?&id=<c:out value="${part.id}"/>">delete</a></td>

            </tr>
        </c:forEach>
        </tbody>
    </table>
    <p></p>
    <table align="center" border="1" cellpadding="1" cellspacing="1" style="width:600px">
        <tbody>
        <tr>
            <td style="text-align:center">Can make:</td>
            <td style="text-align:center">${comp}</td>
            <td style="text-align:center">computers</td>
        </tr>
        </tbody>
    </table>

    <p style="text-align: center;">&lt;&nbsp;
        <c:forEach items="${pages}" var="listpage">
            <a href="/list?sort=<c:out value="${sort}"/>&search=<c:out value="${search}"/>&currentPage=<c:out value="${listpage}"/>">

                <c:choose>
                    <c:when test="${listpage == currentPage}">
                        <span style="font-size:18px"><strong><c:out value="${listpage}"/></strong></span>
                    </c:when>
                    <c:otherwise>
                        <span style="font-size:14px"><c:out value="${listpage}"/></span>
                    </c:otherwise>
                </c:choose>

                &nbsp;
            </a>
        </c:forEach>
        &gt;
    </p>

</table>


</body>
</html>
