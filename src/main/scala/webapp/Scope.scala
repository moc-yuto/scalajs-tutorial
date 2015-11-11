package webapp

import com.greencatsoft.angularjs.core.Scope

import scala.scalajs.js

/**
 * Created by Yuto Suzuki on 15/11/10.
 */

@js.native
trait UserScope extends Scope {
  var users: js.Array[Users] = js.native
}

@js.native
trait UserStuffScope extends Scope {
  var name: String = js.native
  var id: Long = js.native
  def user: Users = js.native
}