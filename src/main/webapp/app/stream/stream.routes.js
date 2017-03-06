'use strict';

(() => {
  angular
    .module('twitterly.stream')
    .constant('streamRoutes', {
      globalStream: {
        url: '/tweets',
        templateUrl: 'app/stream/global-tweet-stream.template.html',
        controller: 'GlobalStreamController',
        controllerAs: '$globalStream',
        resolve: {
          globalStream: ['streamService', function(streamService) {
            return streamService.list();
          }]
        },
        data: {
          anonymousAllowed: true,
        }
      },
      homeStream: {
        url: '/tweets/{username}/following',
        templateUrl: 'app/stream/home-tweet-stream.template.html',
        controller: 'HomeStreamController',
        controllerAs: '$homeStream',
        resolve: {
          homeStream: ['streamService', '$stateParams', function(streamService, $stateParams) {
            return streamService.followingList($stateParams.username);
          }]
        },
        data: {
          anonymousAllowed: false,
        }
      },
      userStream: {
        url: '/tweets/{username}',
        templateUrl: 'app/stream/user-tweet-stream.template.html',
        controller: 'UserStreamController',
        controllerAs: '$userStream',
        resolve: {
          userStream: ['streamService', '$stateParams', function(streamService, $stateParams){
            return streamService.userList($stateParams.username);
          }]
        },
        data: {
          anonymousAllowed: true,
        }
      }
    });
  })();
