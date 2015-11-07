package dao

import models._
import play.api.Play.current
import play.api.db.slick.Config.driver.simple._
import play.api.db.slick._
import javax.inject.Singleton

import scala.slick.lifted.TableQuery

/**
 * Created by John Gordon on 06/11/2015.
 */
abstract class AbstractDao

@Singleton
class Dao extends AbstractDao{

  val items = TableQuery[ItemsTable]

  def retrieveAllItems = DB.withSession {
    implicit rs =>
      items.list
  }

  def insertItem(item: Item) = DB.withSession {
    implicit rs =>
      items.insert(item)
  }

  def deleteItem(id: String) = DB.withSession {
    implicit rs => items.filter(i => i.id === id)
      .delete
  }

  def updateItem(item: Item) = DB.withSession {
    implicit rs => items.filter(_.id === item.id)
      .map(i => (i.id,i.itemName, i.itemColour))
      .update((item.id,item.itemName,item.itemColour))
  }

  def retrieveItem(id: String) = DB.withSession {
    implicit rs => items.filter(i => i.id === id).run
  }
}
