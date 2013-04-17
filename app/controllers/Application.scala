package controllers

import play.api._
import play.api.mvc._
import play.api.libs.json.Json

object Application extends Controller {
  
  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def emails = Action {
    val json = Json.obj(
      "users" -> Json.arr(
        Json.obj(
          "name" -> "bob",
          "age" -> 31,
          "email" -> "bob@gmail.com"      
        ),
        Json.obj(
          "name" -> "kiki",
          "age" -> 25,
          "email" -> "kiki@gmail.com"     
        ) 
      )
    )
    Ok(json).as("application/json")
  }
  
}
