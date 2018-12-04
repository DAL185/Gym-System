var app=angular.module("myApp",[]);
app.controller("article",function($scope){
	$scope.articleList=true;
	$scope.articleEdit=false;
	$scope.t="text"
	$scope.edit=function(){
		$scope.articleList=false;
		$scope.articleEdit=true;
	}
});