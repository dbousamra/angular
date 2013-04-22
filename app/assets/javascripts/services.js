angular.module('someShitServices', ['ngResource']).
    factory('Patient', function($resource){
  return $resource('assets/patients/:patientId.json', {}, {
    query: {method:'GET', params:{patientId:'patients'}, isArray:true}
  });
});