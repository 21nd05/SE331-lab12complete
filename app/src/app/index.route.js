(function() {
  'use strict';

  angular
    .module('app')
    .config(routeConfig);

  function routeConfig($routeProvider) {
    $routeProvider.
    when('/addProduct',{
      templateUrl: 'app/product/editProduct.html',
      controller: 'addProductController',
      controllerAs: 'vm'
    }).
    when('/editProduct/:id',{
      templateUrl: 'app/product/editProduct.html',
      controller: 'editProductController',
      controllerAs: 'vm'
    }).
    when('/listProduct',{
      templateUrl: 'app/product/productList.html',
      controller: 'listProductController',
      controllerAs: 'vm'
    }).
    when('/shoppingCart/:id',{
      templateUrl: 'app/shoppingcart/shoppingCart.html',
      controller: 'showShoppingCartController',
      controllerAs: 'vm'
    }).
    when('/shoppingCart',{
      templateUrl: 'app/shoppingcart/shoppingCart.html',
      controller: 'shoppingCartController',
      controllerAs: 'vm'

    }).
    when('/productDetail/:id', {
      templateUrl: 'app/product/productDetail.html',
      controller: 'editProductController',
      controllerAs: 'vm'
    }).
    otherwise({redirectTo: '/listProduct'});

  }

})();
