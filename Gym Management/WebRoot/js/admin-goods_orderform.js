
var app = angular.module("myApp",[]);
app.controller("admin-goods_orderform",function($scope,$http){
	
	$scope.username={
			username:"",
	};
	

		$http({
			method : 'POST',
			url    : 'servlet/search_mygoods_servlet',
			data   : $.param($scope.username), 
			headers: { 'Content-Type': 'application/x-www-form-urlencoded'}
		
		}).success(function(data){
			$scope.goods_orderforms=data;
			//alert("kk")
		}).error(function(data){
			alert("System error!");
			
		});
		

	$scope.delete_Goods_orderform=function(linkgoods_id){
		//alert(ordercourse_id);
		$http({
			method :'GET',
			url :'servlet/delete_mygoods_servlet?linkgoods_id='+linkgoods_id,
			headers :{'Content-Type':'application/x-www-form-urlencoded'}
		}).success(function(data){
			if(data=="success"){
				alert("Successfully deleted!");
			location.href="admin-goods_orderform.html";
			}else if(data=="failed"){
				alert("Failed to delete");		
			}
		})
		.error(function(ordercourse_id){
			alert("System error!");
		});
	};
	
	$scope.Sendout_Goods=function(linkgoods_id){
		//alert(linkgoods_id);
		$http({
			method :'POST',
			url :'servlet/sendout_goods_servlet?linkgoods_id='+linkgoods_id,
		
			headers :{'Content-Type':'application/x-www-form-urlencoded'}
		}).success(function(data){
			if (data=="success"){
				alert("Successfully send out!");
				location.href="admin-goods_orderform.html";
			}else if(data=="failed"){
				alert("Failed to send out!");
			 }
		})
		.error(function(data){
			alert("System error!");
		});
		    
	};
	
});	
		
	