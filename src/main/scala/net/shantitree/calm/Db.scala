package net.shantitree.calm

import com.orientechnologies.orient.core.db.graph.{OGraphDatabase, OGraphDatabasePool}
import com.orientechnologies.orient.core.db.document.{ODatabaseDocument, ODatabaseDocumentPool}
import com.orientechnologies.orient.core.sql.query.OSQLSynchQuery
import scala.collection.JavaConverters._
import com.orientechnologies.orient.core.record.impl.ODocument
import java.util.{List => JList}
import scala.reflect.runtime.{universe => ru}
import scala.reflect.ClassTag
import com.orientechnologies.orient.core.`type`.tree.OMVRBTreeRIDSet

/**
 * Project: calm
 * Developer: BK. Khunakon Shiva
 * Email: bk.koo.s@gmail.com
 * Date: 7/15/13 Time: 1:52 PM
 */
object Db extends TDbConnectionConf {

  def graphDb = OGraphDatabasePool.global().acquire(connectionString, username, password)
  def docDb = ODatabaseDocumentPool.global().acquire(connectionString, username, password)

  val runtimeMirror = ru.runtimeMirror(getClass.getClassLoader)

  implicit def graphDbWrapper(db: OGraphDatabase) = new {
    def queryBySql[T](sql: String, params: AnyRef*)(implicit ev0: ru.TypeTag[T], ev1: ClassTag[T]): List[T] = {
      toListOf[T](db.query(new OSQLSynchQuery(sql), params.toArray: _*))
    }
  }
  implicit def docDbWrapper(db: ODatabaseDocument) = new {
    def queryBySql[T](sql: String, params: AnyRef*)(implicit ev0: ru.TypeTag[T], ev1: ClassTag[T]): List[T] = {
      toListOf[T](db.query(new OSQLSynchQuery(sql), params.toArray: _*))
    }
  }
  implicit def linkSetToListOf[T](set: OMVRBTreeRIDSet)(implicit ev0: ru.TypeTag[T], ev1: ClassTag[T]): List[T] = {
    if (set == null) {
      List()
    } else {
      set
        .asScala
        .map { rid => oDocumentTo[T](rid.asInstanceOf[ODocument])}
        .toList
    }
  }

  def newInstanceOf[T](ctorm: ru.MethodMirror):T = ctorm().asInstanceOf[T]
  def toListOf[T](recs: JList[AnyRef])(implicit ev0: ru.TypeTag[T], ev1: ClassTag[T]): List[T] = {
    lazy val ctorm = getCtormOf[T]
    recs
      .asScala
      .map { r => r.asInstanceOf[ODocument]}
      .map { d => oDocumentTo(newInstanceOf[T](ctorm), d)}
      .toList
  }
  def getCtormOf[T](implicit ev0: ru.TypeTag[T]) = {
    val classT = ru.typeOf[T].typeSymbol.asClass
    val classMirrorT = runtimeMirror.reflectClass(classT)
    val ctor = ru.typeOf[T].declaration(ru.nme.CONSTRUCTOR).asMethod
    classMirrorT.reflectConstructor(ctor)
  }

  def oDocumentTo[T](doc: ODocument)(implicit ev0: ru.TypeTag[T], ev1: ClassTag[T]): T = {
    oDocumentTo(newInstanceOf[T](getCtormOf[T]), doc)
  }
  def oDocumentTo[T](t: T, doc: ODocument)(implicit ev0: ru.TypeTag[T], ev1: ClassTag[T]): T = {
    doc.fieldNames.foreach { f =>
      val fSymbol = ev0.tpe.member(ru.newTermName(f))
      if (fSymbol.isTerm) {
        val field = runtimeMirror.reflect(t).reflectField(fSymbol.asTerm)
        field.set(doc.field(f))
      }
    }
    t
  }
}
