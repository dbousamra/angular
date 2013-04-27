var directivesModule = angular.module('someShitDirectives', []);

directivesModule.directive('showTab', function () {
  return {
    link: function (scope, element, attrs) {
      element.click(function (e) {
        e.preventDefault();
        $(element).tab('show');
      });
    }
  };
});