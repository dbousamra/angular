var filtersModule = angular.module('someShitFilters', []);

filtersModule.filter('yearsOld', function () {
  return function (input) {
    return moment(input).fromNow(true) + " old";
  };
});

filtersModule.filter('pretty', function () {
  return function (input) {
    return moment(input).format("DD/MM/YYYY");
  };
});

filtersModule.filter('notAvailable', function () {
  return function (input) {
    return input || "N/A";
  };
});