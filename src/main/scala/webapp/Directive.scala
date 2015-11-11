package webapp

import com.greencatsoft.angularjs.{IsolatedScope, TemplatedDirective, ElementDirective, injectable}

import scala.scalajs.js.annotation.JSExport

@JSExport
@injectable("userItem")
class UserDirective extends ElementDirective with TemplatedDirective with IsolatedScope {
  override val templateUrl = "user-item.html"
  bindings ++= Seq(
    "name":= "item"
  )
}