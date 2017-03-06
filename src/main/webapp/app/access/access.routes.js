'use strict';

(() => {
  angular
    .module('twitterly.access')
    .constant('accessRoutes', {
      login: {
        url: '/login',
        templateUrl: 'app/access/login.template.html',
        controller: 'LoginController',
        controllerAs: '$login',
        data: {
          anonymousAllowed: true,
        }
      },
      register: {
        url: '/register',
        templateUrl: 'app/access/register.template.html',
        controller: 'RegisterController',
        controllerAs: '$register',
        data: {
          anonymousAllowed: true,
          loggedIn: false
        }
      }
    });
})();
