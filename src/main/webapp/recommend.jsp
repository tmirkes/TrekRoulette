<%@include file="taglib.jsp"%>
<!doctype html>
<html lang="en">
    <%@include file="head.jsp"%>
    <body>
        <%@include file="navigation.jsp"%>
        <div class="container">
            <div class="row" style="display: inline-block;">
                <table class="column" style="text-align: left;">
                    <thead>
                    <tr>
                        <th colspan="4" style="width: 75%;">You should watch...</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td></td>
                        <td colspan="4"><h2>${selection.episode.title}<h2></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td colspan="3"><em>${selection.episode.series.title} (S${selection.episode.seasonNumber}E${selection.episode.episodeNumber})</em></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>Starring:</td>
                        <td colspan="2" style="vertical-align: top;">
                            <c:forEach items="${selection.episode.performers}" var="performer" varStatus="status">
                                ${performer.name}<c:if test="${!status.last}">, </c:if>
                            </c:forEach>
                        </td>
                    </tr>
                    <c:if test="${!empty selection.episode.directors}">
                        <tr>
                            <td></td>
                            <td>Directed by:</td>
                            <td colspan="2" style="vertical-align: top;">
                                <c:forEach items="${selection.episode.directors}" var="director" varStatus="status">
                                    ${director.name}<c:if test="${!status.last}">, </c:if>
                                </c:forEach>
                            </td>
                        </tr>
                    </c:if>
                    <c:if test="${!empty selection.episode.writers}">
                        <tr>
                            <td></td>
                            <td>Written by:</td>
                            <td colspan="2" style="vertical-align: top;">
                                <c:forEach items="${selection.episode.writers}" var="writer" varStatus="status">
                                    ${writer.name}<c:if test="${!status.last}">, </c:if>
                                </c:forEach>
                            </td>
                        </tr>
                    </c:if>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
    <%@include file="scripts.jsp"%>
</html>