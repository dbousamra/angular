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

function PatientAddCtrl($scope, $routeParams, $location, Patient) {
  $scope.save = function () {
    Patient.save($scope.patient, function (data) {
      $location.path('/patients/' + data.id);

    }, function (error) {
      $scope.invalidUsernamePassword = true;
    });
  };

  $scope.reset = function () {
    $scope.patient = {};
  };

  $scope.reset();
}