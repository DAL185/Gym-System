var app = angular.module("myApp",[]);
app.controller("admin-goods_add",function($scope,$http){
	$scope.reader = new FileReader();  
	
	$scope.images="";
	$scope.formData={
			goods_id:"",
			goods_name:"",
			goods_price:"",
			goods_stock:"",
			goods_shelf:"",
			goods_image:"",
			
	};
	
	
	$scope.img_upload = function(files) {   
		//alert("kks");//单次提交图片的函数
        //$scope.guid = (new Date()).valueOf();   //通过时间戳创建一个随机数，作为键名使用
        $scope.reader.readAsDataURL(files[0]);  //FileReader的方法，把图片转成base64
        $scope.reader.onload = function(ev) {
            $scope.$apply(function(){
            	$scope.images=ev.target.result,
            	//alert($scope.images);
                $scope.formData = {
                    goods_image : $scope.images,  //接收base64
                };
            });
        };
	};
	
	$scope.addGoods=function(){
		//alert("kk");
	$http({
		method : 'POST',
		url	   : 'servlet/add_goods_servlet?action=addgoods', 
		data   : $.param($scope.formData),
		headers: {'Content-Type': 'application/x-www-form-urlencoded'}
	})
	.success(function(data){
		if (data=="success"){
			alert("Successfully added！");
			location.href="admin-goods_list.html";
		}else if(data=="failed"){
			alert("Failed to add！");
		 }
	})
	.error(function(data){
		alert("System error!");
	});
	
	};
	
	$scope.giveup_addGoods=function(){
		location.href="admin-goods_list.html";
	};
	
});