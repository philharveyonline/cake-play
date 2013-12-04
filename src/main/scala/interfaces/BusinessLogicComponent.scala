package interfaces

trait BusinessLogicComponent {

  def businessLogic: BusinessLogic

  trait BusinessLogic {
    def doStuff
  }
}