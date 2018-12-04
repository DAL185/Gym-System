
var app = angular.module("myApp",[]);
app.controller("admin-guest_mycourse",function($scope,$http){
	
	$scope.username={
			username:"",
	};
	

		$http({
			method : 'POST',
			url    : 'servlet/search_mycourse_servlet',
			data   : $.param($scope.username), 
			headers: { 'Content-Type': 'application/x-www-form-urlencoded'}
		
		}).success(function(data){
			$scope.mycourses=data;
		}).error(function(data){
			alert("System error!");
			
		});
		

	$scope.delete_myCourse=function(ordercourse_id){
		//alert(ordercourse_id);
		$http({
			method :'GET',
			url :'servlet/delete_mycourse_servlet?ordercourse_id='+ordercourse_id,
			headers :{'Content-Type':'application/x-www-form-urlencoded'}
		}).success(function(data){
			if(data=="success"){
				alert("Successfully deleted!");
			location.href="admin-guest_mycourse_list.html";
			}else if(data=="failed"){
				alert("Failed to delete!");		
			}
		})
		.error(function(ordercourse_id){
			alert("System error!");
		});
	};
	
	
	
});	
		
	