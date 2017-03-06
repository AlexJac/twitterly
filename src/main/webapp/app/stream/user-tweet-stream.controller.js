'use strict';

(() => {

  angular
    .module('twitterly.stream')
    .controller('UserStreamController', UserStreamController);

  UserStreamController.$inject = ['userStream'];

  function UserStreamController(userStream) {

    this.tweets = userStream;

  }

})();
