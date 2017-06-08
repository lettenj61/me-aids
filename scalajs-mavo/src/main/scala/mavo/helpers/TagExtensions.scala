package mavo
package helpers

import scalatags.generic
import generic.{ Attr, AttrPair }

/** Generic Mavo attribute / element binding for Scalatags DSL.
  */
abstract class TagExtensions[Builder, Output <: FragT, FragT](
    val bundle: generic.Bundle[Builder, Output, FragT]
) {

  import bundle.all._

  abstract class AttrProxy(name: String) {
    def :=[A](v: A)(implicit ev: AttrValue[A]) =
      AttrPair(Attr(name), v, ev)
  }

  // Mavo crucial & misc attributes
  /** Represents Mavo `typeof` attribute */
  lazy val mavoTypeOf = attr("typeof")
  /** Attribute for Mavo root element. */
  lazy val mvApp = attr("mv-app")
  lazy val mvAutoSave = attr("mv-autosave")
  lazy val mvBar = attr("mv-bar")
  lazy val mvFormat = attr("mv-format")

  // Collections
  lazy val mvAccepts = attr("mv-accepts")
  lazy val mvOrder = attr("mv-order")
  /** Attribute for Mavo collections. */
  lazy val mvMultiple = attr("mv-multiple")

  // Expressions
  lazy val mvExpr = attr("mv-expressions")
  lazy val mvIf = attr("mv-if")
  lazy val mvValue = attr("mv-value")

  // Properties
  object mvAttr extends AttrProxy("mv-attribute") {
    lazy val none = this := "none"
  }
  lazy val mvAlias = attr("mv-alias")
  lazy val mvDefault = attr("mv-default")
  object mvEdit extends DataAttribute(List("mv-edit"))
  def mvEdit(suffix: String) = Attr("mv-edit-" + suffix)
  object mvMode extends AttrProxy("mv-mode") {
    lazy val edit = this := "edit"
    lazy val read = this := "read"
  }
  lazy val mvPath = attr("mv-path")
  lazy val property = attr("property")

  // Storage
  lazy val mvInit = attr("mv-init")
  lazy val mvSource = attr("mv-source")
  object mvStorage extends AttrProxy("mv-storage") {
    lazy val none = this := "none"
    lazy val local = this := "local"
  }

  // Mavo classes
  lazy val mvAutoEdit = cls := "mv-autoedit"
}
