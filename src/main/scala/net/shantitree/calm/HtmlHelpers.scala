package net.shantitree.calm

import scala.xml.NodeBuffer
import scala.xml.Elem
import scala.xml.Node
import scala.collection.mutable.{ Map => MMap }

object HtmlHelpers extends THtmlHelpers {

  def additionalHeaders(addition: Addition):Option[NodeBuffer] = {
    addition.get("headers")
  }
  def addToHeader(addition: Addition, header:Node) {
    addition.get("headers") match { 
      case Some(x) =>
        x += header
      case None =>
        addition put ("headers", (new NodeBuffer) += header)
    }
  }
  def addToHeader(addition:Addition, headers: NodeBuffer) {
    headers foreach { h => addToHeader(addition, h) }
  }
}
