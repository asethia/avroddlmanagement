package avro.ddl.model

/**
  * these are model classes used for Json Treee
  * Created by arun_sethia on 25/12/17.
  */
object JsonTree {

  //tree abstract class
  abstract class Tree

  /**
    * branch tree
    * @param left
    * @param right
    * @param typeOfTree
    */
  case class Branch(left:Tree,right:Tree,typeOfTree:) extends Tree

  /**
    * leaf of a tree
    * @param name
    * @param typeOfData
    */
  case class Leaf(name:String, typeOfData:String) extends Tree

  /**
    * tree relationship
    */
  abstract class TreeRealtionShip

  /**
    * one to many relationship
    */
  case object OneToMany extends TreeRealtionShip


  /**
    * one to one relationship
    */
  case object OneToOne extends TreeRealtionShip

}
