'use strict';

(() => {
  angular
    .module('twitterly.appBar')
    .config(config)

  config.$inject = ['appBarRoutes', '$stateProvider'];

  function config(appBarRoutes, $stateProvider) {
    Object.keys(appBarRoutes)
      .forEach(key => {
        $stateProvider
          .state(key, appBarRoutes[key]);
      });
  }
})();
