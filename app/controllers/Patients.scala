package controllers

import play.api.mvc._
import models.Patient

import play.api.libs.json.Json._
import play.api.libs.json.JsError

object Patients extends Controller {

  implicit val patientsToJson = format[Patient]
  implicit val jsonToPatient = writes[Patient]

  def all = Action { request =>
    Ok(toJson(models.Patients.findAll))
  }

  def show(id: Long) = Action  { request =>
    Ok(toJson(models.Patients.findById(id)))
  }

  def save = Action(parse.json) { request =>
    request.body.validate[Patient].map {
      case patient => {
        val id = models.Patients.add(patient);
        Ok(toJson(id))
      }
    }.recoverTotal{
      e => BadRequest(JsError.toFlatJson(e))
    }
  }

  def update = Action(parse.json) { request =>
    request.body.validate[Patient].map {
      case patient => {
        models.Patients.update(patient);
        Ok(toJson(patient.id.get))
      }
    }.recoverTotal{
      e => BadRequest(JsError.toFlatJson(e))
    }
  }

  def archive = Action(parse.json) { request =>
    request.body.validate[Patient].map {
      case patient => {
        println("Archived")
        models.Patients.archive(patient);
        Ok(toJson(patient.id.get))
      }
    }.recoverTotal{
      e => BadRequest(JsError.toFlatJson(e))
    }
  }
}
