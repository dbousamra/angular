package test

import org.specs2.mutable._
import play.api.test._
import play.api.test.Helpers._
import models.{Patient, Patients}
import scala.slick.driver.H2Driver.simple._
import Database.threadLocalSession


class ApplicationSpec extends Specification {
//
//  "Computer model" should {
//
//    "be retrieved by id" in {
//      running(FakeApplication(additionalConfiguration = inMemoryDatabase())) {
//
//        Patients.ddl.create
////        Patients.insert(Patient(None, "foo", 10))
////        val Some(macintosh) = Computer.findById(21)
////
////        macintosh.name must equalTo("Macintosh")
////        macintosh.introduced must beSome.which(dateIs(_, "1984-01-24"))
//
//      }
//    }
}