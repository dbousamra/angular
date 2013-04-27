package models

import scala.slick.driver.H2Driver.simple._
import play.api.db.slick.DB
import play.api.Play.current
import java.sql.Date

case class Patient(
   id: Option[Long] = None,
   archived: Boolean = false,
   firstName: String,
   lastName: String,
   gender: String,
   dateOfBirth: Date,
   phone: Option[String] = None,
   email: Option[String] = None,
   address1: Option[String] = None,
   postcode: Option[String] = None)

object Patients extends Table[Patient]("patient") {
   def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
   def archived = column[Boolean]("archived")
   def firstName = column[String]("firstName")
   def lastName = column[String]("lastName")
   def gender = column[String]("gender")
   def dateOfBirth = column[Date]("dateOfBirth")
   def phone = column[String]("phone", O.Nullable)
   def email = column[String]("email", O.Nullable)
   def address1= column[String]("address1", O.Nullable)
   def postcode = column[String]("postcode", O.Nullable)

   def * = id.? ~ archived ~
     firstName ~ lastName ~ gender ~ dateOfBirth ~ phone.? ~ email.? ~ address1.? ~ postcode.? <>(Patient, Patient.unapply _)
   def autoInc = * returning id
   val byId = createFinderBy(_.id)

   def add(patient: Patient) = DB.withSession { implicit session =>
     val insertedId = Patients.autoInc.insert(patient)
     patient.copy(id = Some(insertedId))
   }

  def update(patient: Patient) = DB.withSession { implicit session =>
    val patientToUpdate = for (c <- Patients if c.id === patient.id) yield c
    patientToUpdate.update(patient)
  }

  def archive(id: Long) = DB.withSession { implicit session =>
    val patientToUpdate = for (c <- Patients if c.id === id) yield c
    patientToUpdate.update(patientToUpdate.first.copy(archived = true))
  }

   def findAll = DB.withSession { implicit session =>
     (for { c <- Patients } yield c).list
   }

   def findById(id: Long): Patient = DB.withSession { implicit session =>
     byId(id).first
   }
}
