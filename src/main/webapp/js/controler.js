var Controllers = angular.module('Controllers',[]);


//写法一，这种方法不要servicr.js
/*phonecatControllers2.controller( 'PhoneListCtrl',function($scope, $http) {
    $http.get('phones/phones.json').success(function(data) {
        $scope.phones = data;
    });
    $scope.orderProp = 'age';
});
phonecatControllers2.controller('PhoneDetailCtrl', function ($scope, $routeParams,$http) {
    $http.get('phones/' + $routeParams.phoneId + '.json').success(function(data) {
        $scope.phone = data;
        $scope.mainImageUrl = data.images[0];
    });
    $scope.setImage = function(imageUrl){
        $scope.mainImageUrl = imageUrl;
    }
});*/

//写法二，需要service.js
Controllers.controller('NewsListCtrl',['$scope','News','$http',
	function($scope,News,$http){
		layer.load(1);


		$http({
			url:'http://localhost:8080/zhihu/getNews',
			method:'GET'
			},{ cache: true }).success(function(data,header,config,status){
			//响应成功
				$scope.stories = data.stories;
				$scope.top_stories = data.top_stories;
				layer.closeAll('loading');
			}).error(function(data,header,config,status){
				console.log("加载失败");
			//处理响应失败
			});
		$scope.loadBanner = function(){
			var mySwiper = new Swiper('.swiper-container',{

				loop : true,//可选选项，开启循环
				pagination : '.pagination'

			});
		}
	}
	  
]);

Controllers.controller('CategoryCtrl',['$scope','$http','Categorys',
	function($scope,$http){
		layer.load(1);
		$http({
			url:'http://localhost:8080/zhihu/getthemes',
			method:'GET'
		},{ cache: true }).success(function(data,header,config,status){
			//响应成功

			$scope.themes = data.others;
			layer.closeAll('loading');

		}).error(function(data,header,config,status){
			layer.msg("服务器连接失败");


		});

		$scope.loadCategorySuccess = function(){
			console.log("load success");
			var a = new sHover("sHoverItem","sIntro");
			a.set({
				slideSpeed:5,
				opacityChange:true,
				opacity:80
			});
		}

		
	}
	  
]);
Controllers.controller('CategoryDetailCtrl',['$scope','$http','$stateParams',
	function($scope,$http,$stateParams){

		layer.load(1);
		$http({
			url:'http://localhost:8080/zhihu/theme/'+$stateParams.id,
			method:'GET'
		},{ cache: true }).success(function(data,header,config,status){
			//响应成功
			$scope.themeDetailImg = data.image;
			$scope.themeDetailBg = data.background;
			$scope.themeDetailDesc = data.description;
			$scope.themeStoryllist = data.stories;
			$scope.themeDetailName = data.name;
			$scope.editors = data.editors;

			layer.closeAll('loading');

		}).error(function(data,header,config,status){
			layer.msg("服务器连接失败");


		});

		$scope.loadCategorySuccess = function(){
			console.log("load success");
			var a = new sHover("sHoverItem","sIntro");
			a.set({
				slideSpeed:5,
				opacityChange:true,
				opacity:80
			});
		}


	}

]);
