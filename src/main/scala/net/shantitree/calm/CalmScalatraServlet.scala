package net.shantitree.calm

import org.scalatra._
import scalate.ScalateSupport

class CalmScalatraServlet extends CalmStack {

  get("/") {
    <html>
      <body>
        <h1>Hello, world!</h1>
        Say <a href="hello-scalate">hello to Scalate</a>.
      </body>
    </html>
  }
  
}
