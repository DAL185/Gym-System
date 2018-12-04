var app=angular.module("myApp",[]);
app.controller("admin-guest_goods_buy",function($scope,$http){
	$scope.goods_id="";
	var url=location.search;
	var goods_id=url.substring(url.indexOf("goods_id=")+9);
    //alert(goods_id);

	$http({
		method :'GET',
		url :'servlet/guest_buy_goods_servlet?goods_id='+goods_id,
		data :$.param($scope.goods_id),
		headers :{'Content-Type':'application/x-www-form-urlencoded'}
	}).success(function(res){
		//alert(res.goods_id);
		$scope.formData=res;
	}).error(function(res){
		alert("System error!");
	});

	$scope.formData={
			goods_id:"",
			goods_name:"",
			goods_price:"",
			goods_stock:"",
			goods_shelf:"",
			customer_name:"",
			customer_phone:"",
			customer_address:"",
	};
	
	$scope.payGoods=function(){
		//alert("kk");
		$http({
			method :'POST',
			url :'servlet/guest_pay_goods_servlet',
			data :$.param($scope.formData),
			headers :{'Content-Type':'application/x-www-form-urlencoded'}
		
		}).success(function(data){
			if(data=="success"){
				alert("Successfully paid!");
			   location.href="admin-guest_mygoods.html";
			}else if(data=="failed"){
				alert("Faile to pay!");		
			}
		}).error(function(data){
			alert("System error!");
		});
	};
	
	$scope.giveup_payGoods=function(){
		location.href="admin-guest_goods_list.html";
	};
	
});
