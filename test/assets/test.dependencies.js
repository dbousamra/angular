// Dependencies for the unit test via Jasmine
EnvJasmine.loadGlobal(EnvJasmine.libDir + "jquery-1.9.0.min.js");
EnvJasmine.loadGlobal(EnvJasmine.libDir + "angular.min.js");
EnvJasmine.loadGlobal(EnvJasmine.libDir + "angular-resource.js");
EnvJasmine.loadGlobal(EnvJasmine.libDir + "angular-mocks.js");
EnvJasmine.loadGlobal(EnvJasmine.libDir + "angular-strap.js");
EnvJasmine.loadGlobal(EnvJasmine.libDir + "moment.js");

// Import all modules (in theory this should be done with RequireJs, but it fails for some reason)
// FIXME: check why we can't use RequireJs instead of manually importing files
EnvJasmine.loadGlobal(EnvJasmine.rootDir + "controllers.js");
EnvJasmine.loadGlobal(EnvJasmine.rootDir + "services.js");
EnvJasmine.loadGlobal(EnvJasmine.rootDir + "filters.js");
EnvJasmine.loadGlobal(EnvJasmine.rootDir + "directives.js");
EnvJasmine.loadGlobal(EnvJasmine.rootDir + "app.js");