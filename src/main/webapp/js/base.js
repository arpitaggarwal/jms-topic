var jmsapp = angular.module("jmsapp", [ 'ngRoute' ]);
jmsapp.controller('MessageController', function($scope, $http) {
	$scope.sendMessageFormData = {
		message : ""
	};
	$scope.sendMessage = function() {
		$http({
			method : 'POST',
			url : '/jms-topic/sendMessage',
			data : $scope.sendMessageFormData,
		});
	};
});
