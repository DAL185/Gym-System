
var app = angular.module("myApp",[]);
app.controller("guest_Login_ctrl",function($scope,$http){
	$scope.guest_phone = "";
	$scope.guest_pwd = "";	
	
	
	
	$scope.guest_doLogin = function(){
		//alert("kk");
		$scope.guest = {"guest_phone": $scope.guest_phone, "guest_pwd":$scope.guest_pwd};
		//alert($scope.guest_phone);
		//alert($scope.guest)
		$http({
			method : 'POST',
			url	   : 'servlet/guest_Login_servlet',
			data   : $.param($scope.guest),
			headers: {'Content-Type': 'application/x-www-form-urlencoded'}
		}).success(function(data){
			//alert(data);
			if (data == "success"){
				location.href='admin-guest_member_list.html';
			}else if(data == "failed"){
				alert("Wrong username or password!");
				$scope.guest_phone="";
				$scope.guest_pwd="";
			}
		});
		
	};
	
	$scope.guest_doRegister=function(){
		location.href="admin-guest_register.html";
	};
	
});