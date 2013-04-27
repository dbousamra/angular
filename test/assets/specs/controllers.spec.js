describe('PhoneCat controllers', function () {

  beforeEach(function () {
    this.addMatchers({
      toEqualData: function (expected) {
        return angular.equals(this.actual, expected);
      }
    });
  });

  beforeEach(module('angularApp'));

  describe('PatientListCtrl', function () {
    var scope, ctrl, $httpBackend;

    beforeEach(inject(function(_$httpBackend_, $rootScope, $controller) {
      $httpBackend = _$httpBackend_;
      $httpBackend.expectGET('/patients').respond([{name: 'Dom'}, {name: 'Bob'}]);
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

   describe('PatientDetailCtrl', function () {
    var scope, ctrl, $httpBackend,
      xyzPatientData = function() {
          return {
            name: 'Dom',
            age: 23,
            id: 1
          }
        };

    beforeEach(inject(function(_$httpBackend_, $rootScope, $routeParams, $controller) {
      $httpBackend = _$httpBackend_;
      $httpBackend.expectGET('/patients/1').respond(xyzPatientData());
      $routeParams.patientId = 1;
      scope = $rootScope.$new();
      ctrl = $controller(PatientDetailCtrl, {$scope: scope});
    }));

    it('should fetch patient details', function() {
      expect(scope.patient).toEqualData({});
      $httpBackend.flush();
      expect(scope.patient).toEqualData(xyzPatientData());
    });
  });
});