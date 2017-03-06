'use strict';

(() => {
  angular
    .module('twitterly.stream')
    .config(config)

  config.$inject = ['streamRoutes', '$stateProvider'];

  function config(streamRoutes, $stateProvider) {
    Object.keys(streamRoutes)
      .forEach(key => {
        $stateProvider
          .state(key, streamRoutes[key]);
      });
  }
})();
