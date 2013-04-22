angular.module('someShitServices', ['ngResource']).
    factory('Patient', function($resource){
  return $resource('patients/', {}, {
    query: {method:'GET', isArray:true}
  });
});