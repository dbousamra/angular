angular.module('someShit', ['someShitServices', '$strap.directives']).
  config(['$routeProvider', function($routeProvider) {
    var base = "assets/views/";
    $routeProvider.
        when('/dashboard', {templateUrl: '/assets/views/dashboard.html',   controller: DashboardCtrl}).
        when('/patients/add', {templateUrl: base + 'patients/patient_add.html', controller: PatientAddCtrl}).
        when('/patients/:patientId', {templateUrl: base + 'patients/patient_detail.html', controller: PatientDetailCtrl}).
        when('/patients', {templateUrl: base + 'patients/patients.html',   controller: PatientListCtrl}).
        otherwise({redirectTo: '/dashboard'});
}]);