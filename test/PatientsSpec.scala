import java.sql.Date
import models.{Patient, Patients}
import play.api.Play.current
import org.specs2.mutable.Specification
import play.api.db.slick.Config.driver.simple._
import play.api.test.FakeApplication
import play.api.test._
import play.api.test.Helpers._


class PatientsSpec extends Specification {
  "Patient model" should {
    "be retrieved by id" in {
       running(FakeApplication(additionalConfiguration = inMemoryDatabase())) {
         val patient = Patient(None, "Dom", "Bou-Samra", "Male", Date.valueOf("1990-01-22"))
         val insertedPatient = Patients.add(patient)
         Patients.findById(insertedPatient.id.get) must equalTo(insertedPatient)
       }
    }
    "be retrieved by all" in {
       running(FakeApplication(additionalConfiguration = inMemoryDatabase())) {
         val patient = Patient(None, "Dom", "Bou-Samra", "Male", Date.valueOf("1990-01-22"))
         val insertedPatient = Patients.add(patient)
         Patients.add(patient)
         val all = Patients.findAll
         all.size must equalTo(2)
         all.headOption must equalTo(insertedPatient)
       }
    }
  }
}
