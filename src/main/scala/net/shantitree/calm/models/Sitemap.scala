package net.shantitree.calm.models

import com.orientechnologies.orient.core.`type`.tree.OMVRBTreeRIDSet
import javax.persistence.{Version, Id}
/**
 * Project: calm
 * Developer: BK. Khunakon Shiva
 * Email: bk.koo.s@gmail.com
 * Date: 7/14/13 Time: 9:46 PM
 */
class Sitemap {
  @Id var id: String = _
  @Version var version: String = _
  var uid: String = _
  var name: String = _
  var route: String = _
  var dir: OMVRBTreeRIDSet = null

  override def toString = {
    "uid: " + uid + " name: " + name + " route: " + route
  }
}
