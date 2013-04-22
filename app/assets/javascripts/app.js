angular.module('someShit', ['someShitServices', '$strap.directives']).
  config(['$routeProvider', function($routeProvider) {
  $routeProvider.
      when('/dashboard', {templateUrl: '/assets/views/dashboard.html',   controller: DashboardCtrl}).

      when('/patients', {templateUrl: 'assets/views/patients.html',   controller: PatientListCtrl}).
      when('/patients/:patientId', {templateUrl: 'assets/views/partials/patient_detail.html', controller: PatientDetailCtrl}).
      otherwise({redirectTo: '/dashboard'});
}]);