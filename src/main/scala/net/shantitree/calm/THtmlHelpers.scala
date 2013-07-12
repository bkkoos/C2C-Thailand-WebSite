package net.shantitree.calm

import scala.collection.breakOut
import scala.xml.{NodeSeq, Text, UnprefixedAttribute, Elem}

trait THtmlHelpers extends TTypeAlias {
  implicit def pimp(elem:Elem) = new {
    def %(attrs:Map[String,String]) = {
      val seq = for( (n,v) <- attrs ) yield new UnprefixedAttribute(n,v,null)
      (elem /: seq) ( _ % _ )
    }
  }
  def cssList(path: String, files: List[String], attrs: Map[String, String]) = tagFileList(css, path, files, attrs)
  def cssList(path: String, files: String*) = tagFileList(css, path, files)
  def css(path: String, file:String, attrs: Map[String, String]=Map()) = {
    val url = getUrl(path, file, ".css")
    <link rel="stylesheet" type="text/css" href={ url } /> % attrs
  }
  def lessList(path: String, files: List[String], attrs: Map[String, String]) = tagFileList(less, path, files, attrs)
  def lessList(path: String, files: String*) = tagFileList(less, path, files)
  def less(path: String, file:String, attrs: Map[String, String]=Map()) = {
    val url = getUrl(path, file, ".less")
    <link rel="stylesheet/less" type="text/css" href={ url } /> % attrs
  }
  def jsList(path: String, files: List[String], attrs: Map[String, String]) = tagFileList(js, path, files, attrs)
  def jsList(path: String, files: String*) = tagFileList(js, path, files)
  def js(path:String, file:String, attrs: Map[String, String]=Map()) = {
    val url = getUrl(path, file, ".js")
    <script src={ url } type="text/javascript"></script> % attrs
  }
  def img(path:String, file:String, attrs: Map[String, String]=Map()) = {
    val url = getUrl(path, file, "")
    <img src={ url } /> % attrs
  }
  def imgList(path: String, files: Seq[String], attrs: Map[String, String]) = {
    tagFileList(img, path, files, attrs)
  }
  def imgList(path: String, files: String*) = tagFileList(img, path, files)
  def tagFileList(
    tagGen: (String, String, Map[String, String])=> Elem,
    path: String, files: Seq[String],
    attrs: Map[String, String]=Map()) = {

    files.map { file => tagGen(path, file, attrs)}(breakOut)
  }
  def getUrl(path: String, file:String, fileType:String) =
    "public/" + path + "/" + file + fileType
}
