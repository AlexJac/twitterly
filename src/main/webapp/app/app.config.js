'use strict';

(() => {
  angular
    .module('twitterly')
    .config(config);

    config.$inject = ['$locationProvider', '$urlRouterProvider'];

    function config($locationProvider, $urlRouterProvider) {
          $urlRouterProvider.otherwise('/tweets');
    }
})();
