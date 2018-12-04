var app=angular,module("myApp");
app.controller("homeCtrl",function(){
	$scope.home=true;
	$scope.articleInfo=false;
	$scope.view=function(){
		$scope.home=false;
		$scope.articleInfo=true;
	}
	
})