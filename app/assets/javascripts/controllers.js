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

function PatientAddCtrl($scope, $routeParams, Patient) {
  $scope.patientDetails = {};

  $scope.save = function() {
//    Patient.save($scope.patient);
      Patient.save($scope.patient, function(data) {
        alert("Success")
      }, function(error) {
        alert("Error");
      });
  };

  $scope.reset = function() {
    $scope.patient = {};
  };

  $scope.reset();
}