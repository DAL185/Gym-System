var app=angular.module("myApp",[]);
app.controller("admin-guest-info_list",function($scope,$http){
	$scope.guest_phone="";
	var url=location.search;
	var id=url.substring(url.indexOf("guest_phone=")+12);
	alert(guest_phone);

	$http({
		method :'GET',
		url :'servlet/edit_member_servlet?guest_phone='+guest_phone,
		data :$.param($scope.guest_phone),
		headers :{'Content-Type':'application/x-www-form-urlencoded'}
	}).success(function(res){
		//alert(res.id);
		$scope.formData=res;
	}).error(function(res){
		alert("System error!");
	});

});
