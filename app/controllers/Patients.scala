package controllers

import play.api.mvc._
import models.{Patients, Patient}

import play.api.libs.json.Json._

object Patients extends Controller {

  implicit val patientsToJson = format[Patient]
  implicit val jsonToPatient = writes[Patient]

  def all = Action { request =>
    Ok(toJson(models.Patients.findAll))
  }

  def show(id: Long) = Action { request =>
    Ok(toJson(models.Patients.findById(id)))
  }

  def save = Action { request =>
    println(request.body.asJson)
    println(toJson(Patient(None, "Dom", 23)))
    val patientFromForm = request.body.asJson.map(_.as[Patient]).getOrElse(
      throw new RuntimeException("could not create user")
    )
    println(patientFromForm)
    Ok(toJson(models.Patients.findAll))
  }
}
