'use strict';

(() => {

  angular
    .module('twitterly.stream')
    .controller('HomeStreamController', HomeStreamController);

  HomeStreamController.$inject = ['homeStream'];

  function HomeStreamController(homeStream) {

    this.tweets = homeStream;

  }

})();
