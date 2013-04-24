import models.{Patient, Patients}
import play.api.GlobalSettings
import play.api.Application
import java.sql.Date
 
 
object Global extends GlobalSettings {
  override def onStart(app: Application) {
    if (Patients.findAll.isEmpty) {
      Patients.add(Patient(None, "Dominic", "Bou-Samra", "Male", Date.valueOf("1990-01-22")))
      Patients.add(Patient(None, "Cosmo", "Kramer", "Male", Date.valueOf("1990-01-22")))
      Patients.add(Patient(None, "Jerry", "Seinfeld", "Male", Date.valueOf("1990-01-22")))
      Patients.add(Patient(None, "Bob", "Sacamano", "Male", Date.valueOf("1990-01-22")))
    }
  }
}