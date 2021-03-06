<%@ tag description="Page Components" language="java"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ attribute name="title" required="true"%>
<%@ attribute name="script" fragment="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>${title}</title>
<jsp:include page="/framework-resource.jsp" />
<jsp:invoke fragment="script" />
</head>
<body>
	<jsp:include page="/logoutbar.jsp" />
	<div class="container">
		<div class="row">
			<jsp:include page="/sidebar.jsp" />
			<jsp:doBody />
		</div>
	</div>
	<footer>
	<div class="row">
		<div class="col-sm-12" style="text-align: center">&copy;
			Champ.com</div>
		<!--/.col-->
	</div>
	</footer>
</body>
</html>
