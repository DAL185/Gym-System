var app=angular.module("myApp",[]);
app.controller("admin-member_edit",function($scope,$http){
	$scope.id="";
	var url=location.search;
	var id=url.substring(url.indexOf("id=")+3);
    //alert(id);

	$http({
		method :'GET',
		url :'servlet/edit_member_servlet?id='+id,
		data :$.param($scope.id),
		headers :{'Content-Type':'application/x-www-form-urlencoded'}
	}).success(function(res){
		//alert(res.id);
		$scope.formData=res;
	}).error(function(res){
		alert("System error!");
	});


	

	$scope.editMember=function(){
		//alert("111");
		$http({
			method :'POST',
			url :'servlet/add_member_servlet?action=editmember',
			data :$.param($scope.formData),
			headers :{'Content-Type':'application/x-www-form-urlencoded'}
		}).success(function(data){
			if(data=="success"){
				alert("Successfully revised!");
			   location.href="admin-member_list.html";
			}else if(data=="failed"){
				alert("Failed to revise");		
			}
		}).error(function(data){
			alert("System error!");
		});
	};
	
	$scope.giveup_editMember=function(){
		location.href="admin-member_list.html";
	};
	
});
