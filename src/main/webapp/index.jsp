<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!doctype html>
<html>
<head>
<spring:url value="/js/jquery-2.1.4.min.js" var="jqueryJs" />
<spring:url value="/js/angular.min.js" var="angularJs" />
<spring:url value="/js/angular-route.min.js" var="angularRouteJs" />
<spring:url value="/js/base.js" var="baseJs" />
<script src="${jqueryJs}"></script>
<script src="${angularJs}"></script>
<script src="${angularRouteJs}"></script>
<script src="${baseJs}"></script>
</head>
<title>JMS Application | Topic Example</title>
<body>
	<div data-ng-app="jmsapp" data-ng-controller="MessageController">
		<form>
			<table>
				<tr>
					<td>Message:</td>
					<td><input type="text"
						data-ng-model="sendMessageFormData.message" /></td>
				</tr>
				<tr>
					<td><button data-ng-click="sendMessage()">Send</button></td>
				</tr>
			</table>
		</form>
		<div id="results">{{result}}</div>
	</div>
</body>
</html>
