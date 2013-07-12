package net.shantitree.calm

import scala.collection.breakOut
import scala.xml.{NodeSeq, Text, UnprefixedAttribute, Elem}
import net.shantitree.calm.{ HtmlHelpers => H }

object C2CHtmlHelpers extends THtmlHelpers {

  def getC2CPath(section: String, path: String) =  "c2c/" + section + "/" + path
  def defaultFile(path: String, file: String) = if (file == null) { path } else { file } 

  override def css(path: String, file: String=null, attrs: Map[String, String]=Map()) = {
    super.css(getC2CPath(path, "styles"), defaultFile(path, file), attrs)
  }
  override def img(path: String, file: String, attrs: Map[String, String]=Map()) = {
    super.img(getC2CPath(path, "imgs"), file, attrs)
  }
  override def js(path: String, file: String=null, attrs: Map[String, String]=Map()) = {
    super.js(getC2CPath(path, "js"), defaultFile(path, file), attrs)
  }
  override def less(path: String, file: String=null, attrs: Map[String, String]=Map()) = {
    super.less(getC2CPath(path, "styles"), defaultFile(path, file), attrs)
  }
}
