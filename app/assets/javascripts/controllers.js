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