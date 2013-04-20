package controllers

import play.api.mvc._
import play.api.libs.json.Json
import scala.io.Source

object Application extends Controller {
  
  def index = Action {
    Ok(views.html.index())
  }
}