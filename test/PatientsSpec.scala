import models.{Patient, Patients}
import play.api.Play.current
import org.specs2.mutable.Specification
import play.api.db.slick.Config.driver.simple._
import play.api.test.FakeApplication
import play.api.test._
import play.api.test.Helpers._


class PatientsSpec extends Specification {
  // "Patient model" should {
  //   "be retrieved by id" in {
  //      running(FakeApplication(additionalConfiguration = inMemoryDatabase())) {
  //        val id = Patients.add(Patient(None, "Dom", 23))
  //        Patients.findById(id) must equalTo(Some(Patient(Some(id), "Dom", 23)))
  //      }
  //   }
  //   "be retrieved by all" in {
  //      running(FakeApplication(additionalConfiguration = inMemoryDatabase())) {
  //        val firstId = Patients.add(Patient(None, "Dom", 23))
  //        Patients.add(Patient(None, "Bob", 24))
  //        Patients.add(Patient(None, "Sam", 25))
  //        val all = Patients.findAll
  //        all.size must equalTo(3)
  //        all.headOption must equalTo(Some(Patient(Some(firstId), "Dom", 23)))
  //      }
  //   }
  // }
}
