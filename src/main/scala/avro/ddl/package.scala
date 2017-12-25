package avro

import org.apache.avro.Schema
import org.json4s.JsonAST.JValue

/**
  * this provides implicit functions
  * Created by arun_sethia on 25/12/17.
  */
package object ddl {

  /**
    * implicit function to get elements for JValue
    *
    * @param jValue
    */
  implicit class JsonElements(jValue: JValue) {
    def elements = {
      jValue.values.asInstanceOf[Map[String, Any]]
    }
  }

  /**
    * parse Schema defination and get JValue
    *
    * @param schema
    */
  implicit class JsonFromSchemaDef(schema: Schema) {

    import org.json4s._
    import org.json4s.native.JsonMethods._

    /**
      * jvalues
      *
      * @return
      */
    def jValues = parse(schema.toString)

    /**
      * list of Elements
      *
      * @return
      */
    def elements: Map[String, Any] = jValues.elements

  }

  /**
    * find element value
    *
    * @param elements
    */
  implicit class ElementValue(elements: Map[String, Any]) {
    /**
      * element value for given key
      * @param key
      * @return
      */
    def elementVal(key: String) = elements.get(key)

    /**
      * element value for given key if not exist then default value
      * @param key
      * @param default
      * @tparam V
      * @return
      */
    def elementVal[V](key: String,default:V) = elements.getOrElse[V](key,default)

  }

}
