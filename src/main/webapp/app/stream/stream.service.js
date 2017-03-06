'use strict';

(() => {
  angular
    .module('twitterly.stream')
    .service('streamService', StreamService);

  StreamService.$inject = ['$http'];

  function StreamService($http) {
    
    this.list = function() {
      return $http
        .get('./api/tweets')
        .then(response => response.data);
    };

    this.followingList = function(username) {
      return $http
        .get('./api/tweets/' + username + '/following')
        .then(response => response.data);
    };

    this.userList = function(username) {
      return $http
        .get('./api/tweets/' + username)
        .then(response => response.data);
    }
  };

})();
