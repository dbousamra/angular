describe('PhoneCat controllers', function () {

  beforeEach(function () {
    this.addMatchers({
      toEqualData: function (expected) {
        return angular.equals(this.actual, expected);
      }
    });
  });

  beforeEach(module('someShitServices'));

  describe('PatientListCtrl', function () {
    var scope, ctrl, $httpBackend;

    beforeEach(inject(function(_$httpBackend_, $rootScope, $controller) {
      $httpBackend = _$httpBackend_;
      $httpBackend.expectGET('assets/patients/patients.json').respond([{name: 'Dom'}, {name: 'Bob'}]);
      scope = $rootScope.$new();
      ctrl = $controller(PatientListCtrl, {$scope: scope});
    }));

    it('should create "patients" model with 2 patients fetched from xhr', function() {
      expect(scope.patients).toEqual([]);
      $httpBackend.flush();
      expect(scope.patients).toEqualData([{name: 'Dom'}, {name: "Bob"}]);
    });

    it('should set the default value of orderProp model', function() {
      expect(scope.orderProp).toBe('name');
    });

  });
});