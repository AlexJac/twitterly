'use strict';

(() => {
  angular
    .module('twitterly',
              [
                'ui.router',
                'dtrw.bcrypt',
                'twitterly.access',
                'twitterly.stream'
              ]);
})();
