package models

import scala.slick.driver.H2Driver.simple._
import play.api.db.slick.DB
import play.api.Play.current
import java.sql.Date

case class Patient(id: Option[Long] = None,
                   firstName: String,
                   lastName: String,
                   gender: String,
                   dateOfBirth: Date,
                   phone: Option[String],
                   email: Option[String])

object Patients extends Table[Patient]("patient") {
   def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
   def firstName = column[String]("firstName")
   def lastName = column[String]("lastName")
   def gender = column[String]("gender")
   def dateOfBirth = column[Date]("dateOfBirth")
   def phone = column[String]("phone", O.Nullable)
   def email = column[String]("email", O.Nullable)
   def * = id.? ~ firstName ~ lastName ~ gender ~ dateOfBirth ~ phone.? ~ email.? <>(Patient, Patient.unapply _)
   def autoInc = * returning id
   val byId = createFinderBy(_.id)

   def add(patient: Patient) = DB.withSession { implicit session =>
     val insertedId = Patients.autoInc.insert(patient)
     patient.copy(id = Some(insertedId))
   }

   def findAll = DB.withSession { implicit session =>
     (for { c <- Patients } yield c).list
   }

   def findById(id: Long): Option[Patient] = DB.withSession { implicit session =>
     Patients.byId(id).firstOption
   }
}
