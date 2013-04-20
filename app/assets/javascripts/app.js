angular.module('phonecat', ['phonecatFilters', 'phonecatServices', '$strap.directives']).
  config(['$routeProvider', function($routeProvider) {
  $routeProvider.
      when('/phones', {templateUrl: '/assets/partials/phone_list.html',   controller: PhoneListCtrl}).
      when('/phones/:phoneId', {templateUrl: 'assets/partials/phone_detail.html', controller: PhoneDetailCtrl}).
      otherwise({redirectTo: '/phones'});
}]);