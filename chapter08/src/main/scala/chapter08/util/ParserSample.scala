package chapter08.util

/**
 * @author tanabe
 */
object ParserSample extends App {

  val parser = new IniParser

  val  result = parser.parseAll(parser.sections,
    """
      |[db1]
      |driver=org.postgresql.Driver
      |url=jdbc:postgresql://localhost/testdb1
      |user=postgres
      |password=postgres
      |
      |[db2]
      |driver=org.postgresql.Driver
      |url=jdbc:postgresql://localhost/testdb2
      |user=postgres
      |password=postgres
    """.stripMargin)

  val sections = result.get

  val map = sections.sections.map { section =>
    (section.name.string -> section.properties.map { property =>
      (property.key.string -> property.value.string)
    }.toMap)
  }.toMap

  println(map)
}

import scala.util.parsing.combinator.RegexParsers

class IniParser extends RegexParsers {

  def string: Parser[ASTString] = """[^\[\]=\s]*""".r^^ {
    case value => ASTString(value)
  }

  def property: Parser[ASTProperty] = string~"="~string^^ {
    case (key~_~value) => ASTProperty(key, value)
  }

  def section: Parser[ASTSection] = "["~>string~"]"~rep(property)^^{
    case (section~_~properties) => ASTSection(section, properties)
  }

  def sections: Parser[ASTSections] = rep(section)^^ {
    case sections => ASTSections(sections)
  }
}

trait AST

case class ASTString(string: String) extends AST
case class ASTProperty(key: ASTString, value: ASTString) extends AST
case class ASTSection(name: ASTString, properties: List[ASTProperty]) extends AST
case class ASTSections(sections: List[ASTSection]) extends AST