'use strict';

(() => {

  angular
    .module('twitterly.stream')
    .controller('GlobalStreamController', GlobalStreamController);

  GlobalStreamController.$inject = ['globalStream'];

  function GlobalStreamController(globalStream) {

    this.tweets = globalStream;

  }

})();
