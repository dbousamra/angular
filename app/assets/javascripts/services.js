var servicesModule = angular.module('angularServices', ['ngResource'])

servicesModule.factory('Patient', function($resource){
    return $resource('/patients/:patientId', {}, {
      query: {method: 'GET', params:{patientId: ''}, isArray:true},
      save:  {method: 'POST'},
      update: {method:'PUT'},
      archive: {method: 'DELETE'}
    });
  }
);



