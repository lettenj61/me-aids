package object mavo {

  import scalatags.JsDom

  object tagdsl extends helpers.TagExtensions(JsDom)
}