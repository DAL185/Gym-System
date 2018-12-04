
app.controller("Login_ctrl", 
	function($scope,$http){
		$scope.usernam;
		$scope.pwd;
		
		
		$scope.doLogin=function(){
			$scope.user={"username":$scope.username,"pwd":$scope.pwd};	
			$http({
				method  : 'POST',
				url     : 'servlet/Login_servlet',
				data    : $.param($scope.user),  // pass in data as strings
				headers : { 'Content-Type': 'application/x-www-form-urlencoded' } 
			})
			.success(function(data) {
				if (data=="success") {
					location.href="admin_home.html";
				} else {
					alert("用户名或密码错误！");
				}
			})
			.error(function(data){
				alert("系统错误，请联系管理员！");
			});
				
		};
});
