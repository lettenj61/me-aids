package com.github.lettenj61.mavoapp

import scala.scalajs.js
import scalatags.JsDom.all._
import org.scalajs.dom

import mavo.tagdsl._

object MavoApp extends js.JSApp {

  val Components = div(
    mvApp := "mavo-app",
    mvStorage.none,
    h4("Properties"),
    p(property := "exampleText", "Hello"),
    p(property := "exampleText2", "Mavo")
  )

  def main(): Unit = {
    val wrapper = dom.document.getElementById("wrapper")
    wrapper.appendChild(
      Components.render
    )
  }
}
