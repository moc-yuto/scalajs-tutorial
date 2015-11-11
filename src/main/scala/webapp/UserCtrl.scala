package webapp

import scala.scalajs.concurrent.JSExecutionContext.Implicits.runNow
import com.greencatsoft.angularjs.core.Location
import com.greencatsoft.angularjs.{AbstractController, injectable}
import scala.scalajs.js.JSConverters.JSRichGenTraversableOnce
import scala.scalajs.js
import org.scalajs.dom.console
import scala.scalajs.js.annotation.JSExport
import scala.util.{Failure, Success}

/**
 * Created by Yuto Suzuki on 15/11/10.
 */
@JSExport
@injectable("userCtrl")
class UserCtrl(scope: UserScope, location: Location, service: UserService) extends AbstractController[UserScope](scope) {

  scope.users = js.Array[Users]()
  service.findAll().onComplete {
    case Success(users) => scope.users = users.toJSArray
    case Failure(t) => handleError(t)
  }

  private def handleError(t: Throwable) {
    console.error(s"An error has occured: $t")
  }
}
