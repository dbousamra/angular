function DashboardCtrl($scope) { }

function PatientListCtrl($scope, Patient) {
  $scope.patients = Patient.query();
  $scope.orderProp = 'name';
}

function PatientDetailCtrl($scope, $routeParams, $location, Patient) {
  $scope.patient = Patient.get({patientId: $routeParams.patientId});
  $scope.archive = function (patient) {
//    Patient.archive({patientId: patient.id}, function (success) {
//      console.log(patient);
//      $location.path('/app/patients/' + patient.id);
//    }, function (error) {
//      console.log("Error");
//    });
    $scope.patient.archived = true;
    Patient.update($scope.patient, function (success) {
      $location.path('/app/patients/' + $scope.patient.id);
    }, function (error) {
    });
  };
}

function PatientEditCtrl($scope, $routeParams, $location, Patient) {
  $scope.patient = Patient.get({patientId: $routeParams.patientId});
  $scope.save = function () {
    Patient.update($scope.patient, function (success) {
      $location.path('/app/patients/' + $scope.patient.id);
    }, function (error) {
    });
  };
};

function PatientAddCtrl($scope, $location, Patient) {
  $scope.save = function () {
    Patient.save($scope.patient, function (data) {
      $location.path('/app/patients/' + data.id);
    }, function (error) {
    });
  };

  $scope.reset = function () {
    $scope.patient = {};
  };

  $scope.reset();
};