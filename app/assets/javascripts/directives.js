angular.module("phonecat", ["controllers"])
  .directive("bootstrapNavbar", function() { // (1)
  return {
    restrict: "E",         // (2)
    replace: true,         // (3)
    transclude: true,      // (4)
    templateUrl: "bootstrapNavbar.html"    // (5)
  }});
;