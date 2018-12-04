var app = angular.module("myApp",[]);
app.controller("admin-guest_course_list",function($scope,$http){
	$scope.username={
			username:"",
	};
	
		$http({
			method : 'POST',
			url    : 'servlet/search_course_servlet',
			data   : $.param($scope.username),
			headers: {'Content-Type': 'application/x-www-form-urlencoded'}
		
		}).success(function(data){
			$scope.guest_courses=data;
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
			
				$scope.guest_courses=data;
				
				
			})
			.error(function(data){
				alert("System error!");
			});
			
			};
			
		$scope.orderCourse=function(course_id){
			//alert(course_id);
			$http({
				method :'POST',
				url :'servlet/order_course_servlet?course_id='+course_id,
			
				headers :{'Content-Type':'application/x-www-form-urlencoded'}
			}).success(function(data){
				if (data=="success"){
					alert("Successfully ordered!");
					location.href="admin-guest_mycourse_list.html";
				}else if(data=="failed"){
					alert("Failed to order!");
				 }
			})
			.error(function(data){
				alert("System error!");
			});
			    
		};

});	
		
	