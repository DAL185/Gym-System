var app = angular.module("myApp",[]);
app.controller("admin-guest_member_list",function($scope,$http){
	

	$scope.username={
			username:"",
	};
	
	
	$http({
		method : 'POST',
		url    : 'servlet/guest_search_member_servlet',
		data   : $.param($scope.username), 
		headers: { 'Content-Type': 'application/x-www-form-urlencoded'}
	
	}).success(function(res){
		$scope.formData=res;
	}).error(function(data){
		alert("System error!");
		
	});
});
