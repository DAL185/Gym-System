
var app = angular.module("myApp",[]);
app.controller("admin-course_list",function($scope,$http){
	
	$scope.username={
			username:"",
	};
	$scope.keywords="";
	
	
	//$scope.memberContent=null;
	
		$http({
			method : 'POST',
			url    : 'servlet/search_course_servlet',
			data   : $.param($scope.username), 
			headers: { 'Content-Type': 'application/x-www-form-urlencoded'}
		
		}).success(function(data){
			$scope.courses=data;
		}).error(function(data){
			alert("System error!");
		});
		
		$scope.findCourse=function(){
			
			$scope.keywords=$("input[name='keywords']").val();
			
			$scope.keyword = {"keywords": $scope.keywords};
			
			$http({
				method : 'POST',
				url	   : 'servlet/find_course_servlet', 
				data   : $.param($scope.keyword),
				headers: {'Content-Type': 'application/x-www-form-urlencoded'}
			})
			//alert("kk")
			.success(function(data){
			
				$scope.courses=data;
				
				
			})
			.error(function(data){
				alert("System error!");
			});
			
			};
	
	$scope.edit=function(course_id){
		location.href='admin-course_edit.html?course_id='+course_id;
	};	
	
	$scope.del=function(course_id){
		//alert(course_id);
		$http({
			method :'GET',
			url :'servlet/delete_course_servlet?course_id='+course_id,
			headers :{'Content-Type':'application/x-www-form-urlencoded'}
		}).success(function(data){
			if(data=="success"){
				alert("Successfully deleted!");
			location.href="admin-course_list.html";
			}else if(data=="failed"){
				alert("Failed to delete!");		
			}
		})
		.error(function(course_id){
			alert("System error!");
		});
	};
	
	
	
});	
		
	