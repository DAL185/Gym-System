var app = angular.module("myApp",[]);
app.controller("Register_ctrl",function($scope,$http){
	$scope.username = "";
	$scope.pwd = "";	
	
	
	
	$scope.submit = function(){
		//alert($scope.username);
		$scope.user = {"username": $scope.username, "pwd":$scope.pwd};
		$http({
			method : 'POST',
			url	   : 'servlet/Register_servlet',
			data   : $.param($scope.user),
			headers: {'Content-Type': 'application/x-www-form-urlencoded'}
		}).success(function(data){
			if (data=="success"){
				alert("Sign up succesfully!")
				location.href="admin-login.html";
			}else if(data=="failed"){
				alert("Failed to sign up！");
				$scope.username="";
				$scope.pwd="";
			}
		});
		
	};
	
	
});