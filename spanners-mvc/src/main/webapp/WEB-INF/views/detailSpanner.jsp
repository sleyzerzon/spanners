<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<p>

    <h1>Spanner</h1>
    <p>Spanner id: <c:out value="${spanner.id}"/></p>
    <p>Spanner name:<c:out value="${spanner.name}"/></p>
    <p>Spanner size: <c:out value="${spanner.size}"/></p>
    <p>Spanner owner: <c:out value="${spanner.owner}"/></p>

     <p><a href="<c:url value="/displaySpanners"/>">Back</a></p>

</p>