describe('PhoneCat controllers', function() {

  describe('PhoneListCtrl', function(){

    it('should create "resources.phones" model with 3 resources.phones', function() {
      var scope = {},
          ctrl = new PhoneListCtrl(scope);

      expect(scope.phones.length).toBe(3);
    });
  });
});