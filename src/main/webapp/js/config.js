var zhihuApp = angular.module('zhihuApp',[
	'ui.router',
	'Controllers',
	'Services'
]);


zhihuApp.config(['$stateProvider', '$urlRouterProvider',
	function($stateProvider,$urlRouterProvider){

		$urlRouterProvider.otherwise('latest');
		$stateProvider.state('latest', {
			url : '/latest',
			templateUrl:'template/latest.html',
			controller: 'NewsListCtrl'
		}).state('category', {
			url : '/category',
			templateUrl:'template/category.html',
			controller: 'CategoryCtrl'
		}).state('categorys',{
			url : '/categorys/{:id}',
			templateUrl:'template/category_list.html',
			controller: 'CategoryDetailCtrl'

		});

	}]);

zhihuApp.factory("Categorys",['$http', '$q',function($http, $q){
	return {  
    query : function() {  
      var deferred = $q.defer(); // 声明延后执行，表示要去监控后面的执行  
      $http({method: 'GET', url: '/'}).
      success(function(data, status, headers, config) {  
        deferred.resolve(data);  // 声明执行成功，即http请求数据成功，可以返回数据了  
      }).  
      error(function(data, status, headers, config) {  
        deferred.reject(data);   // 声明执行失败，即服务器返回错误  
      });  
      return deferred.promise;   // 返回承诺，这里并不是最终数据，而是访问最终数据的API  
    } // end query  
  };  
}]);

zhihuApp.directive('repeatFinish',function(){
	return {
		restrict:"A",
		link:function(scope,element,attr){
			if(scope.$first==true){

			}
			if(scope.$last==true){

				scope.loadCategorySuccess();
			}
		}
	}
});

zhihuApp.directive('repeatFinish2',function(){
	return {
		restrict:"A",
		link:function(scope,element,attr){
			if(scope.$first==true){

			}
			if(scope.$last==true){

				scope.loadBanner();
			}
		}
	}
});
