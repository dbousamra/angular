import models.{Patient, Patients}
import play.api.GlobalSettings
import play.api.Application
 
 
object Global extends GlobalSettings {
  override def onStart(app: Application) {
    Patients.add(Patient(None, "Dom", 23))
    Patients.add(Patient(None, "Bob", 24))
  }
}