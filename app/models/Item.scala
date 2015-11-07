package models

import play.api.db.slick.Config.driver.simple._

case class Item(id: String, itemName: String, itemColour: String)

/* Table mapping
 */
class ItemsTable(tag: Tag) extends Table[Item](tag, "ITEM") {

  def id = column[String]("id", O.PrimaryKey, O.AutoInc)
  def itemName = column[String]("itemName", O.NotNull)
  def itemColour = column[String]("itemColour", O.NotNull)

  def * = (id, itemName, itemColour) <> (Item.tupled, Item.unapply _)
}
