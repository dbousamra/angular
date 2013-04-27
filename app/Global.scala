import models.{Patient, Patients}
import play.api.GlobalSettings
import play.api.Application
import java.sql.Date


case class Dom(id: Int = 10, b: Int)


object Global extends GlobalSettings {
  override def onStart(app: Application) {
    if (Patients.findAll.isEmpty) {
      val patient = Patient(firstName = "Dominic",
                            lastName = "Bou-Samra",
                            gender = "Male",
                            dateOfBirth = Date.valueOf("1990-01-22"),
                            phone = Some("0414213852"),
                            email = Some("domlebo70@gmail.com"),
                            address1 = Some("273 Stanhill Dr"),
                            postcode = Some("4217"))
      Patients.add(patient)
      Patients.add(patient.copy(firstName = "Cosmo", lastName = "Kramer"))
      Patients.add(patient.copy(firstName = "Jerry", lastName = "Seinfeld"))
      Patients.add(patient.copy(firstName = "Bob", lastName = "Sacamano", postcode = None))
    }
  }
}