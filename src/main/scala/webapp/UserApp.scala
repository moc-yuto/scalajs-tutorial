package webapp

import com.greencatsoft.angularjs.Angular

import scala.scalajs.js.JSApp
import scala.scalajs.js.annotation.JSExport

/**
 * Created by Yuto Suzuki on 15/11/10.
 */
@JSExport
object UserApp extends JSApp {
  override def main (){
    val module = Angular.module("usermvc")

    module
        .controller[UserCtrl]
        .directive[UserDirective]
        .factory[UserServiceFactory]
  }
}