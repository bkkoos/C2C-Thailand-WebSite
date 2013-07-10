package net.shantitree.calm

import org.scalatra._
import scalate.ScalateSupport

class CalmScalatraServlet extends CalmStack {

  get("/") {

    contentType="text/html"
    jade("index", "title"->"Choose to be Calm", "headline"->"welcome")
  }

}
