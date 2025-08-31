<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="graph" value="${applicationScope['model.appGraph']}" />

<!DOCTYPE html>
<html>

    <head>
        <link rel="stylesheet" type="text/css" href="style.css?v=<?= time() ?>">
        <meta charset="UTF-8">
        <title>Finish</title>
    </head>

  <body>
    <h1>${graph.getFinish(sessionScope.level)}</h1>
    <a href="/modul3finalQuest/start" class="sLink">Restart</a>

    <div class="divElement" role="region" aria-label="info" contenteditable="false">
      <div>Session-ID: <c:out value="${pageContext.session.id}"  /></div>
      <div>IP: <c:out value="${pageContext.request.remoteAddr}" /></div>
      <div>Games played: <c:out value="${sessionScope.gamesPlayed}" /></div>
    </div>
  </body>
</html>