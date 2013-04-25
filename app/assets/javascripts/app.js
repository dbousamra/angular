var app = angular.module('someShit', ['someShitServices', '$strap.directives', 'someShitFilters']);
app.config(['$routeProvider', '$locationProvider', function($routeProvider, $locationProvider) {
    var base = "/assets/views/";
    $locationProvider.html5Mode(true);
    $routeProvider.
        when('/app/dashboard', {templateUrl: base + 'dashboard.html',   controller: DashboardCtrl}).
        when('/app/patients/add', {templateUrl: base + 'patients/patient_add.html', controller: PatientAddCtrl}).
        when('/app/patients/:patientId', {templateUrl: base + 'patients/patient_detail.html', controller: PatientDetailCtrl}).
        when('/app/patients', {templateUrl: base + 'patients/patients.html',   controller: PatientListCtrl}).
        otherwise({redirectTo: '/app/dashboard'});
}]);
