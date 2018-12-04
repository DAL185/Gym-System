var app = angular.module("myApp",[]);
app.controller("admin-member_add",function($scope,$http){
	
	
	
	$scope.formData={
			name:"",
			gender:"",
			type:"",
			duetime:"",
			phone:"",
			height:"",
			weight:"",
			surround:"",
			fatrate:"",
			heartrate:"",
			advice:"",
			remark:"",
			id:"",
	};
	
	$scope.addMember=function(){
		//alert("kk");
	$http({
		method : 'POST',
		url	   : 'servlet/add_member_servlet?action=addmember',
		data   : $.param($scope.formData),
		headers: {'Content-Type': 'application/x-www-form-urlencoded'}
	})
	.success(function(data){
		if (data=="success"){
			alert("Successfully added!");
			location.href="admin-member_list.html";
		}else if(data=="failed"){
			alert("Failed to add!");
		 }
	})
	.error(function(data){
		alert("System error!");
	});
	
	};
	
	$scope.giveup_addMember=function(){
		location.href="admin-member_list.html";
	};
	
});