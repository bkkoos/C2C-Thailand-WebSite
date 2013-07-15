package net.shantitree.calm

/**
 * Project: calm
 * Developer: BK. Khunakon Shiva
 * Email: bk.koo.s@gmail.com
 * Date: 7/15/13 Time: 1:50 PM
 */
trait TDbConnectionConf {

  val dbName = "calm"
  val host = "localhost"
  val username = "admin"
  val password = "admin"
  val connectionString = "remote:" + host + "/" + dbName

}
