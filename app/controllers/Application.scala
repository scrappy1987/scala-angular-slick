package controllers

import dao.Dao
import models._
import play.api.db.slick._
import play.api.mvc._
import play.api.Play.current
import play.api.libs.json.Json
import play.api.libs.json.Json._
import javax.inject.{Singleton, Inject}



@Singleton
class Application @Inject() (d: Dao) extends Controller{

  implicit val itemFormat = Json.format[Item]

  def findAllItems = Action {
    Ok(toJson(d.retrieveAllItems))
  }

  def insertItem = DBAction(parse.json) {rs =>
    rs.request.body.validate[Item].map { item =>
        d.insertItem(item)
        Ok(toJson(item))
    }.getOrElse(BadRequest("invalid json"))
  }

  def deleteItem(id: String) = Action {
    d.deleteItem(id)
    Ok("succesful")
  }

  def updateItem = DBAction(parse.json) {rs =>
    rs.request.body.validate[Item].map { item =>
      d.updateItem(item)
      Ok(toJson(item))
    }.getOrElse(BadRequest("invalid json"))
  }

  def retrieveItem(id: String) = Action {
    Ok(toJson(d.retrieveItem(id).head))
  }

}
