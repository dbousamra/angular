describe('SomeShit filters', function () {

  beforeEach(module('someShitFilters'));
  var date = 632926800000; //22-01-1990

  describe('years old filter', function () {
    it('should give how many years old from a date', inject(function(yearsOldFilter) {
      expect(yearsOldFilter(date)).toBe("23 years old");
    }));
  });

  describe('pretty filter', function () {
    it('should give a date formatter as DD/MM-YY', inject(function(prettyFilter) {
      expect(prettyFilter(date)).toBe("22/01/1990");
    }));
  });
});