
var app = angular.module("myApp",[]);
app.controller("admin-guest_mygoods",function($scope,$http){
	
	$scope.username={
			username:"",
	};
	

		$http({
			method : 'POST',
			url    : 'servlet/search_mygoods_servlet',
			data   : $.param($scope.username), 
			headers: { 'Content-Type': 'application/x-www-form-urlencoded'}
		
		}).success(function(data){
			$scope.mygoods=data;
			//alert("kk")
		}).error(function(data){
			alert("System error!");
			
		});
		

	$scope.delete_myGoods=function(linkgoods_id){
		//alert(ordercourse_id);
		$http({
			method :'GET',
			url :'servlet/delete_mygoods_servlet?linkgoods_id='+linkgoods_id,
			headers :{'Content-Type':'application/x-www-form-urlencoded'}
		}).success(function(data){
			if(data=="success"){
				alert("Canceled Successfully!");
			location.href="admin-guest_mygoods.html";
			}else if(data=="failed"){
				alert("Failed to cancel!");		
			}
		})
		.error(function(ordercourse_id){
			alert("System error!");
		});
	};
	
	
	
});	
		
	