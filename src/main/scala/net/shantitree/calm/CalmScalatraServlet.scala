package net.shantitree.calm

import scala.collection.mutable.{ Map => MMap }
import Db._
import net.shantitree.calm.models.Sitemap

class CalmScalatraServlet extends CalmStack with TTypeAlias {

  def addition:Addition = MMap()

  get("/") {
    contentType="text/html"
    val title = "Choose to be Calm : เลือกทางที่สงบ"
    val contentHeader = "หน้าหลัก"

    jade("index", "title" -> title, "addition" -> addition, "contentHeader" -> contentHeader)

  }

  get("/3-minutes-of-calm") {
    contentType="text/html"
    val title = "Choose to be Calm : เลือกทางที่สงบ"
    val contentHeader = "3 นาที แห่งความสงบเย็น"
    jade("calm3mins", "title" -> title, "addition" -> addition, "contentHeader" -> contentHeader)
  }

  get("/calm-room/calm-card") {
    contentType="text/html"
    val title = "Choose to be Calm : เลือกทางที่สงบ"
    val contentHeader = "หยิบบัตรคุณค่า 16 ประการ"
    jade("calmCard", "title" -> title, "addition" -> addition, "contentHeader" -> contentHeader)
  }

  get("/news-and-event") {
    contentType="text/html"
    val title = "Choose to be Calm : เลือกทางที่สงบ"
    val contentHeader = "ข่าวสาร / กิจกรรม"
    jade("newsAndEvent", "title" -> title, "addition" -> addition, "contentHeader" -> contentHeader)
  }

  get("/test") {
    contentType="text/html"
    val title = "Choose to be Calm : เลือกทางที่สงบ"
    val contentHeader = "ทดสอบ"
    jade("siteMenu", "title" -> title, "addition" -> addition, "contentHeader" -> contentHeader)
  }
  
  get("/under") {
    contentType="text/html"
    val title = "Choose to be Calm : เลือกทางที่สงบ"
    val contentHeader = "อยู่ระหว่างการสร้าง"
    jade("underconstruction", "title" -> title, "addition" -> addition, "contentHeader" -> contentHeader)
  }

}
