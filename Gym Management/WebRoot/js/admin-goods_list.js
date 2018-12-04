
var app = angular.module("myApp",[]);
app.controller("admin-goods_list",function($scope,$http){
		//alert("kk");
		$scope.username={
				username:"",
		};
	
		$http({
			method : 'POST',
			url    : 'servlet/search_goods_servlet',
			data   : $.param($scope.username),
			headers: { 'Content-Type': 'application/x-www-form-urlencoded'}
		
		}).success(function(data){
			$scope.goods_infos=data;
		}).error(function(data){
			alert("System error!");
		});
		
		
	$scope.edit_goods=function(goods_id){
		//alert("kk");
		location.href='admin-goods_edit.html?goods_id='+goods_id;
	};	
	
	$scope.delete_Goods=function(goods_id){
		//alert(ordercourse_id);
		$http({
			method :'GET',
			url :'servlet/delete_goods_servlet?goods_id='+goods_id,
			headers :{'Content-Type':'application/x-www-form-urlencoded'}
		}).success(function(data){
			if(data=="success"){
				alert("Successfully deleted!");
			location.href="admin-goods_list.html";
			}else if(data=="failed"){
				alert("Failed to delete!");		
			}
		})
		.error(function(ordercourse_id){
			alert("System error!");
		});
	};
	
});	
		
	