var app = angular.module("myApp",[]);
app.controller("admin-course_add",function($scope,$http){
	
	
	
	$scope.formData={
			course_id:"",
			course_name:"",
			course_date:"",
			course_time:"",
			course_coach:"",
			course_room:"",	
	};
	
	$scope.addcourse=function(){
		//alert("kk");
	$http({
		method : 'POST',
		url	   : 'servlet/add_course_servlet?action=addcourse', 
		data   : $.param($scope.formData),
		headers: {'Content-Type': 'application/x-www-form-urlencoded'}
	})
	.success(function(data){
		if (data=="success"){
			alert("Successfully added");
			location.href="admin-course_list.html";
		}else if(data=="failed"){
			alert("Failed to add!");
		 }
	})
	.error(function(data){
		alert("System error！");
	});
	
	};
	
	$scope.giveup_addcourse=function(){
		location.href="admin-course_list.html";
	};
	
});