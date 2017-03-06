'use strict';

(() => {
  angular
    .module('twitterly.appBar')
    .constant('appBarRoutes', {
      appBar: {
        url: '/',
        templateUrl: 'app/appBar/appBar.template.html',
        controller: 'AppBarController',
        controllerAs: '$appBar',
        data: {
          anonymousAllowed: true,
        }
      }
    });
})();
