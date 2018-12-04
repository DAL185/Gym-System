var app=angular.module("myApp",[]);
app.controller("admin-course_edit",function($scope,$http){
	$scope.course_id="";
	var url=location.search;
	var course_id=url.substring(url.indexOf("course_id=")+10);
    //alert(course_id);

	$http({
		method :'GET',
		url :'servlet/edit_course_servlet?course_id='+course_id,
		data :$.param($scope.course_id),
		headers :{'Content-Type':'application/x-www-form-urlencoded'}
	}).success(function(res){
		//alert(res.course_id);
		$scope.formData=res;
	}).error(function(res){
		alert("System error");
	});


	

	$scope.editCourse=function(){
		//alert("111");
		$http({
			method :'POST',
			url :'servlet/add_course_servlet?action=editcourse',
			data :$.param($scope.formData),
			headers :{'Content-Type':'application/x-www-form-urlencoded'}
		}).success(function(data){
			if(data=="success"){
				alert("Successfully revised!");
			   location.href="admin-course_list.html";
			}else if(data=="failed"){
				alert("Failed to revise");		
			}
		}).error(function(data){
			alert("System error");
		});
	};
	
	$scope.giveup_editCourse=function(){
		location.href="admin-course_list.html";
	};
	
});
