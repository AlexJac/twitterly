'use strict';

(() => {
  angular
    .module('twitterly.appBar')
    .service('AppBarService', AppBarService);

  AppBarService.$inject = ['$http', 'streamService', 'username'];

  function AppBarService($http, streamService, username) {
      this.findUser = () => {
        streamService
          .userList(username)
      }
})();
