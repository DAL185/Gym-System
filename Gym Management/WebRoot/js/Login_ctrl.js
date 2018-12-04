var app = angular.module("myApp",[]);
app.controller("Login_ctrl",function($scope,$http){
	$scope.username = "";
	$scope.pwd = "";	
	
	
	
	$scope.doLogin = function(){
		//alert($scope.username);
		$scope.user = {"username": $scope.username, "pwd":$scope.pwd};
		$http({
			method : 'POST',
			url	   : 'servlet/Login_servlet',
			data   : $.param($scope.user),
			headers: {'Content-Type': 'application/x-www-form-urlencoded'}
		}).success(function(data){
			if (data=="success"){
				location.href="admin-member_list.html";
			}else if(data=="failed"){
				alert("Wrong username or password！");
				$scope.username="";
				$scope.pwd="";
			}
		});
		
	};
	
	$scope.doRegister=function(){
		
		location.href="admin-register.html";
	};
	
});