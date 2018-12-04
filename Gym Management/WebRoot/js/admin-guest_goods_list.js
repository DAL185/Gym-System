
var app = angular.module("myApp",[]);
app.controller("admin-guest_goods_list",function($scope,$http){
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
		
		$scope.buy_goods=function(goods_id){
			//alert("kk");
			location.href='admin-guest_goods_buy.html?goods_id='+goods_id;
		};	
});	
		
	