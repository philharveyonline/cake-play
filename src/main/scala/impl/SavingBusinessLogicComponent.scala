package impl

import interfaces.BusinessLogicComponent
import interfaces.DaoComponent

trait SavingBusinessLogicComponent extends BusinessLogicComponent {
  this: DaoComponent =>

  class PersistingBusinessLogic extends BusinessLogic {
    println("Creating business logic")

    override def doStuff = {
      println("doing stuff")
      dao.save("[thing to save]")
    }
  }
}