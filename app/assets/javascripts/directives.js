angular.module('someShitDirectives', [])
  .directive('showTab', function() {
    return {
      link: function (scope, element, attrs) {
        element.click(function (e) {
          e.preventDefault();
          $(element).tab('show');
        });
      }
    };
  });