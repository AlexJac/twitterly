'use strict';

(() => {

  angular
    .module('twitterly.appBar')
    .controller('AppBarController', AppBarController);

  AppBarController.$inject = ['appBar', '$state'];

  function AppBarController(appBar, $state) {
      this.goGlobal = () => {
        $state.go('globalStream');
      }
      this.goHome = () => {
        $state.go('homeStream');
      }
      this.goUser = () => {
        $state.go('userStream');
      }
  }

})();
