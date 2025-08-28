<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="graph" value="${applicationScope['model.appGraph']}" />
<%-- <%@ page isELIgnored="false" %> --%>

<!DOCTYPE html>
<html>

    <head>
        <link rel="stylesheet" type="text/css" href="style.css?v=<?= time() ?>">
        <meta charset="UTF-8">
        <title>Quest</title>
    </head>

  <body>
    <h1>Question ${sessionScope.level + 1}</h1>
    <h2>${graph.getQuestion(sessionScope.level)}</h2>

    <form class="form1" method="post" action="${pageContext.request.contextPath}/answer">
        <c:forEach var="opt" items="${graph.getOption(sessionScope.level)}" varStatus="status">
            <label for="it">
                <input type="radio" id="it" name="choose" value="${status.index}"/>
                <span style="font-size:1.1em; font-weight:bold"><c:out value="${opt}"/></span>
            </label><br>
        </c:forEach><br>
        <button type="submit" class="button">Submit</button>
    </form>

    <div class="divElement" role="region" aria-label="info" contenteditable="false">
      <div>Session-ID: <c:out value="${pageContext.session.id}"  /></div>
      <div>IP: <c:out value="${pageContext.request.remoteAddr}" /></div>
      <div>Games played: <c:out value="${sessionScope.gamesPlayed}" /></div>
    </div>
  </body>
</html>