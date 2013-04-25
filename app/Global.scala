import models.{Patient, Patients}
import play.api.GlobalSettings
import play.api.Application
import java.sql.Date


object Global extends GlobalSettings {
  override def onStart(app: Application) {
    if (Patients.findAll.isEmpty) {
      Patients.add(Patient(None, "Dominic", "Bou-Samra", "Male", Date.valueOf("1990-01-22"), Some("0414213852"), Some("domlebo70@gmail.com"), Some("273 Stanhill Dr"), Some("4217")))
      Patients.add(Patient(None, "Cosmo", "Kramer", "Male", Date.valueOf("1990-01-22"), Some("0414213852"), Some("domlebo70@gmail.com"), Some("273 Stanhill Dr"), Some("3100")))
      Patients.add(Patient(None, "Jerry", "Seinfeld", "Male", Date.valueOf("1990-01-22"), Some("0414213852"), Some("domlebo70@gmail.com"), Some("273 Stanhill Dr"), None))
      Patients.add(Patient(None, "Bob", "Sacamano", "Male", Date.valueOf("1990-01-22"), Some("0414213852"), Some("domlebo70@gmail.com"), Some("273 Stanhill Dr"), None))
    }
  }
}