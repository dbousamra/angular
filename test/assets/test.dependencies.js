// Dependencies for the unit test via Jasmine
EnvJasmine.loadGlobal(EnvJasmine.libDir + "jquery-1.9.0.min.js");
EnvJasmine.loadGlobal(EnvJasmine.libDir + "angular.min.js");

// Import all modules (in theory this should be done with RequireJs, but it fails for some reason)
// FIXME: check why we can't use RequireJs instead of manually importing files
EnvJasmine.loadGlobal(EnvJasmine.rootDir + "controllers.js");