var app = angular.module("myApp",[]);
app.controller("admin-guest-course_list",function($scope,$http){
	
	
	
	
	
	//$scope.memberContent=null;
	
		$http({
			method : 'POST',
			url    : 'servlet/guest_search_course_servlet',
			data   : $.param($scope), 
			headers: { 'Content-Type': 'application/x-www-form-urlencoded'}
		
		}).success(function(data){
			$scope.guest_courses=data;
		}).error(function(data){
			alert("System error!");
		});

});	
		
	