angular.module('someShitFilters', [])
  .filter('yearsOld', function() {
    return function(input) {
      return moment(input).fromNow(true) + " old";
    };
  })
  .filter('pretty', function() {
    return function(input) {
      return moment(input).format("DD/MM/YYYY");
    };
  });