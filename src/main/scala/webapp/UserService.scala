package webapp

import com.greencatsoft.angularjs.core.HttpService
import com.greencatsoft.angularjs.{Factory, Service, injectable}

import scala.concurrent.Future
import scala.scalajs.concurrent.JSExecutionContext.Implicits.runNow
import scala.scalajs.js
import scala.scalajs.js.{ Date, JSON }
import scala.scalajs.js.Any.fromString
import scala.util.{ Failure, Success, Try }
import prickle.{ Pickle, Unpickle }

/**
 * Created by Yuto Suzuki on 15/11/10.
 */
@injectable("userService")
class UserService(http: HttpService) extends Service {
  require(http != null, "Missing argument 'http'.")

  def findAll(): Future[Seq[Users]] = flatten {
    val url = parameterizeUrl("/api/users", Map())

    http.get[js.Any](url)
        .map(JSON.stringify(_))
        .map(Unpickle[Seq[Users]].fromString(_))
  }

  protected def parameterizeUrl(url: String, parameters: Map[String, Any]): String = {
    require(url != null, "Missing argument 'url'.")
    require(parameters != null, "Missing argument 'parameters'.")

    parameters.foldLeft(url)((base, kv) =>
      base ++ { if (base.contains("?")) "&" else "?" } ++ kv._1 ++ "=" + kv._2)
  }
  protected def flatten[T](future: Future[Try[T]]): Future[T] = future flatMap {
    case Success(s) => Future.successful(s)
    case Failure(f) => Future.failed(f)
  }
}

@injectable("userService")
class UserServiceFactory(http: HttpService) extends Factory[UserService] {
  override def apply(): UserService = new UserService(http)
}