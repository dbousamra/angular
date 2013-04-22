package models

import scala.slick.driver.H2Driver.simple._
import play.api.db.slick.DB
import play.api.Play.current

case class Patient(id: Option[Int] = None, name: String, age: Int)

// object Patients extends Table[Patient]("patient") {
//   def id = column[Int]("id", O.PrimaryKey, O.AutoInc)
//   def name = column[String]("name")
//   def age = column[Int]("age")
//   def * = id.? ~ name ~ age <>(Patient, Patient.unapply _)
//   val byId = createFinderBy(_.id)
//   def autoInc = * returning id

//   def add(patient: Patient) = DB.withSession { implicit session =>
//     Patients.insert(patient)
//   }

//   def findAll = DB.withSession { implicit session =>
//     (for { c <- Patients } yield c).list
//   }

//   def findById(id: Int): Option[Patient] = DB.withSession { implicit session =>
//       Patients.byId(id).firstOption
//   }
// }
