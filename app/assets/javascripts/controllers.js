function DashboardCtrl($scope) {
  $scope.title = 'Dom';
}

function PatientListCtrl($scope, Patient) {
  $scope.patients = Patient.query();
  $scope.orderProp = 'name';
}

function PatientDetailCtrl($scope, $routeParams, Patient) {
  $scope.patient = Patient.get({patientId: $routeParams.patientId});
}

function PatientAddCtrl($scope, $location, Patient, $anchorScroll) {

  $scope.scrollTo = function(id) {
    $location.hash(id);
    $anchorScroll();
  };

  $scope.save = function () {
    Patient.save($scope.patient, function (data) {
      $location.path('/app/patients/' + data.id);

    }, function (error) {
      $scope.invalidUsernamePassword = true;
    });
  };

  $scope.reset = function () {
    $scope.patient = {};
  };

  $scope.reset();
}