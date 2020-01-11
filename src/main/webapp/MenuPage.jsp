<html>
    <body>
        <form method="get" action="${pageContext.request.contextPath}/Hello" autocomplete="off">
            <button> Hello </button>
        </form>

        <form method="get" action="${pageContext.request.contextPath}/AddMobile" autocomplete="off">
            <button> Add mobile </button>
        </form>

        <form method="get" action="${pageContext.request.contextPath}/DeleteMobile" autocomplete="off">
            <button> Delete mobile by id</button>
        </form>

        <form method="get" action="${pageContext.request.contextPath}/MobileList" autocomplete="off">
            <button>Mobile list</button>
        </form>

        <form method="get" action="${pageContext.request.contextPath}/CreateTable" autocomplete="off" >
            <button>Create table</button>
        </form>

        <form method="get" action="${pageContext.request.contextPath}/DeleteTable" autocomplete="off">
            <button>Delete table</button>
        </form>
    </body>
</html>