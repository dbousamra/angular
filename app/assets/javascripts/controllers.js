function DashboardCtrl($scope) { }

function PatientListCtrl($scope, Patient) {
  $scope.patients = Patient.getList();
  $scope.orderProp = 'name';
}

function PatientDetailCtrl($scope, $routeParams, $location, Restangular) {
  $scope.patient = Restangular.one("patients", $routeParams.patientId).get();
  $scope.toggleArchive = function() {
    $scope.patient.archived = !$scope.patient.archived;
    $scope.patient.put().then(function(){
      $location.path('/app/patients/' + $scope.patient.id);
    });
  }
}

function PatientEditCtrl($scope, $routeParams, $location, Restangular) {
  $scope.patient = Restangular.one("patients", $routeParams.patientId).get();
//  $scope.save = function () {
//    $scope.patient.put().then(function (success) {
//      $location.path('/app/patients/' + $scope.patient.id);
//     });
//  };
};

function PatientAddCtrl($scope, $location, Patient) {
  $scope.save = function () {
    $scope.patient.archived = false;
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