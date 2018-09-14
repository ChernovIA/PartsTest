<%@ page import="parts.model.PartType" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>add/edit part</title>
</head>
<body>

    <form name="part" style="align-content: center" action="/addEditPart" method="POST">

        <c:if test="${part.id > 0}">
            <p>ID: <input name="id" type="text" readonly="readonly" value="<c:out value="${part.id}" />" /></p>
        </c:if>

        <p>Name: <input name="name" type="text" value="<c:out value="${part.name}" />" /></p>
        <p>Count: <input name="countInt" type="text" value="<c:out value="${part.countInt}" />" /></p>

        <p>Required:
        <c:choose>
            <c:when test="${part.required == true}">
                <p>true<input checked="checked" name="required" type="radio" value="1" /></p>
                <p>false<input name="required" type="radio" value="0" /></p>
            </c:when>
            <c:otherwise>
                <p>true<input name="required" type="radio" value="1" /></p>
                <p>false<input checked="checked" name="required" type="radio" value="0" /></p>
            </c:otherwise>
        </c:choose>
        </p>

        <p>Type:
        <select name="type">
            <c:forEach items="${types}" var="type">
                <c:choose>
                    <c:when test="${type == part.type}">
                        <option value="${type.name()}" selected="true">${type.name()}</option>
                    </c:when>
                    <c:otherwise>
                        <option value="${type.name()}">${type.name()}</option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </select>
        </p>

        <c:choose>
            <c:when test="${part.id > 0}">
                <p><input type="submit" value="save part"/></p>
            </c:when>
            <c:otherwise>
                <p><input type="submit" value="add part"/></p>
            </c:otherwise>
        </c:choose>

    </form>

</body>
</html>
