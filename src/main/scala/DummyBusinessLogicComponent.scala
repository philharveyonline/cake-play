import interfaces.BusinessLogicComponent

trait DummyBusinessLogicComponent extends BusinessLogicComponent {
  override val businessLogic = new DummyBusinessLogic

  class DummyBusinessLogic extends BusinessLogic {
    override def doStuff = {
      println("!!!pretending to do stuff!!!")
    }
  }
}