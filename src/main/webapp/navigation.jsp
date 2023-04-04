<div class="row" style="display: inline-block; width: 75%;">
    <c:choose>
        <c:when test="${empty userName}">
            <a href = "logIn">Log in</a>
        </c:when>
        <c:otherwise>
            <h3>Welcome ${userName}</h3>
        </c:otherwise>
    </c:choose>
    <a class="column" href="#" style="display: inline-block;"><button>Log In</button></a>
    <form class="column" action="${pageContext.request.contextPath}/selector" method="post" style="display: inline-block;"><button type="submit">New Recommendation</button></form>
    <a class="column" href="#" style="display: inline-block;"><button>About</button></a>
</div><br>
