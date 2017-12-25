package avro.ddl.util

import avro.ddl.types.CommonDataTypes._
import com.sksamuel.avro4s.json.JsonToAvroConverter
import org.apache.avro.Schema
import org.json4s._

import scala.util.{Success, Try}

/**
  * this is avro Utility Class
  * provides basic avro related utility code
  * Created by arun_sethia on 23/12/17.
  */
trait AvroUtil {

  import avro.ddl._

  /**
    * traverse Json Tree for given schema
    *
    * @param schema
    */
  def traverseTree(schema: Schema) = {


  }

  /**
    * find root node
    *
    * @param schema
    * @return
    */
  private def findRootNode(schema: Schema): List[Map[String, Any]] = {

    val elements: Map[String, Any] = schema.elements

    //root name of schema
    val rootName: JsonData = elements.elementVal("name", "dana")

    //root name space of elements
    val rootNs: JsonData = elements.elementVal("namespace", "mcc.dana.json")

    //find root level fields
    elements.elementVal("fields", List.empty[Map[String, Any]])
  }


  /**
    * this will generate schema for given Json data, namespace and schema name
    *
    * @param jsonData   jsonData
    * @param nameSpace  namespace
    * @param schemaName schema name
    * @return Schema if valid json else None
    */
  def generateSchema(jsonData: JsonData,
                     nameSpace: JsonDataNameSpace,
                     schemaName: JsonDataSchemaName): Option[Schema] = {
    Try {
      val converter = new JsonToAvroConverter(nameSpace)
      converter.convert(schemaName, jsonData)
    } match {
      case Success(v) => Some(v)
      case _ => None
    }
  }
}
