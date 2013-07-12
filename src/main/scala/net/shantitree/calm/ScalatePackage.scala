package net.shantitree.calm

import org.fusesource.scalate.support.TemplatePackage
import org.fusesource.scalate.{Binding, TemplateSource}

/**
 * Defines some common imports, attributes and methods 
 * across templates in package this package and below
 */
class ScalatePackage extends TemplatePackage {
  def header(source: TemplateSource, bindings: List[Binding]) = """
    import net.shantitree.calm.HtmlHelpers._
  """
}
