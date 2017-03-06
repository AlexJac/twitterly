'use strict';

(() => {
  angular
    .module('twitterly')
    .run(run);

  run.$inject = ['$rootScope', 'accessService', '$state'];

  function run($rootScope, accessService, $state) {
    $rootScope.$on('$stateChangeStart', function(event, toState, toStateParams) {
      let anonymousAllowed = toState.data.anonymousAllowed;
      let allowedRoles = toState.data.allowedRoles;
      let loggedIn = accessService.isLoggedIn();

      if(!anonymousAllowed && !loggedIn) {
        event.preventDefault();
        $state.go('login');
      }
    });
  }
})();
