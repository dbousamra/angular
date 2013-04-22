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

  def insert = Action { request =>
//    val blah = parse(request.body.asText.get).as[Patient]
//    println(blah)
    val user = request.body.asJson.map(_.as[Patient]).getOrElse(
      throw new RuntimeException("could not create user")
    )

    Ok(toJson(models.Patients.findAll))
  }
}
