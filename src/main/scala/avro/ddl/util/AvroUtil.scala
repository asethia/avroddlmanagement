package avro.ddl.util

import avro.ddl.types.CommonDataTypes._
import com.sksamuel.avro4s.json.JsonToAvroConverter
import org.apache.avro.Schema

import scala.util.{Success, Try}

/**
  * this is avro Utlility Class
  * provides basic avro related utility code
  * Created by arun_sethia01 on 23/12/17.
  */
trait AvroUtil {

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
