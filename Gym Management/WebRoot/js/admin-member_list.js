
var app = angular.module("myApp",[]);
app.controller("admin-member_list",function($scope,$http){
	
	$scope.username={
			username:"",
	};
	
	$scope.keywords="";
	
	$http({
		method : 'POST',
		url    : 'servlet/search_member_servlet',
		data   : $.param($scope.username), 
		headers: { 'Content-Type': 'application/x-www-form-urlencoded'}
	
	}).success(function(data){
		$scope.members=data;
	}).error(function(data){
		alert("System error!");
		
	});
	
	$scope.findMember=function(){
		$scope.keywords=$("input[name='keywords']").val();
		
	
		$scope.keyword = {"keywords": $scope.keywords};
		
		$http({
			method : 'POST',
			url	   : 'servlet/find_member_servlet', 
			data   : $.param($scope.keyword),
			headers: {'Content-Type': 'application/x-www-form-urlencoded'}
		})
		
		
		
		.success(function(data){
		
			$scope.members=data;
			
			
		})
		.error(function(data){
			alert("System error!");
		});
		
	};
	
	$scope.edit=function(id){
		location.href='admin-member_edit.html?id='+id;
	};	
	
	$scope.del=function(id){
		//alert(id);
		$http({
			method :'GET',
			url :'servlet/delete_member_servlet?id='+id,
			headers :{'Content-Type':'application/x-www-form-urlencoded'}
		}).success(function(data){
			if(data=="success"){
				alert("Successfully deleted!");
			location.href="admin-member_list.html";
			}else if(data=="failed"){
				alert("Failed to delete!");		
			}
		})
		.error(function(id){
			alert("System error!");
		});
	};
	
	
});	
		
	