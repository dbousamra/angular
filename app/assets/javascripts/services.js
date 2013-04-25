angular.module('someShitServices', ['ngResource'])
  .factory('Patient', function($resource){
    return $resource('/patients/:patientId', {}, {
      query: {method: 'GET', params:{patientId: ''}, isArray:true},
      save:  {method: 'POST'}
    });
  }
);