var app=angular.module("myApp",[]);
app.controller("articleCtrl",function($scope){
	$scope.articleInfo=false;
	$scope.articleList=true;
	$scope.view=function(){
		$scope.articleInfo=true;
		$scope.articleList=false;
	}
	$scope.closeView=function(){
		$scope.articleInfo=false;
		$scope.articleList=true;
	}
	
})