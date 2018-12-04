var app = angular.module("myApp",[]);
app.controller("guest_Register_ctrl",function($scope,$http){
	$scope.guest_phone = "";
	$scope.guest_pwd = "";	
	
	
	
	$scope.submit = function(){
		//alert($scope.username);
		$scope.guest = {"guest_phone": $scope.guest_phone, "guest_pwd":$scope.guest_pwd};
		$http({
			method : 'POST',
			url	   : 'servlet/guest_Register_servlet',
			data   : $.param($scope.guest),
			headers: {'Content-Type': 'application/x-www-form-urlencoded'}
		}).success(function(data){
			if (data=="success"){
				alert("Sign up successfully!")
				location.href="admin-guest_login.html";
			}else if(data=="failed"){
				alert("Failed to sign up！");
				$scope.guest_phone="";
				$scope.guest_pwd="";
			}
		});
		
	};

	
});