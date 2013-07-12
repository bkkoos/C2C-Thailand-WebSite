package net.shantitree.calm
import scala.collection.mutable.{ Map => MMap }
import scala.xml.NodeBuffer

trait TTypeAlias {
  type Addition = MMap[String, NodeBuffer]
}
