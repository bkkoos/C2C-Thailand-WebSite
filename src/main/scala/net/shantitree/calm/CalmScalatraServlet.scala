package net.shantitree.calm

import org.scalatra._
import scalate.ScalateSupport
import scala.xml.NodeBuffer
import scala.collection.mutable.{ Map => MMap }

class CalmScalatraServlet extends CalmStack with TTypeAlias {

  def addition:Addition = MMap()

  get("/") {

    contentType="text/html"
    val title = "Choose to be Calm : เลือกทางที่สงบ"
    val contentHeader = "หน้าหลัก"
    jade("index", "title" -> title, "addition" -> addition, "contentHeader" -> contentHeader)
  }

}
