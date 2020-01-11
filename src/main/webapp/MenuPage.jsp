<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <body>
        <c:if test="${isAuth}">
            <p>You are authorized</p>
        </c:if>
        <c:if test="${!isAuth}">
            <p>You are not authorized</p>
        </c:if>

        <form method="get" action="${pageContext.request.contextPath}/Authorization" autocomplete="off">
            <button>Authorization Page</button>
        </form>

        <form method="get" action="${pageContext.request.contextPath}/Quit" autocomplete="off">
            <button>Quit account</button>
        </form>

        <form method="get" action="${pageContext.request.contextPath}/Hello" autocomplete="off">
            <button> Hello </button>
        </form>

        <form method="get" action="${pageContext.request.contextPath}/AddMobile" autocomplete="off">
            <button> Add mobile </button>
        </form>

        <form method="get" action="${pageContext.request.contextPath}/DeleteMobile" autocomplete="off">
            <button> Delete mobile by id</button>
        </form>

        <form method="get" action="${pageContext.request.contextPath}/AllTablesList" autocomplete="off">
            <button>All tables</button>
        </form>

        <form method="get" action="${pageContext.request.contextPath}/CreateTable" autocomplete="off" >
            <button>Create table</button>
        </form>

        <form method="get" action="${pageContext.request.contextPath}/DeleteTable" autocomplete="off">
            <button>Delete table</button>
        </form>
    </body>
</html>