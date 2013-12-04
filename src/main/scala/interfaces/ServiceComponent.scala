package interfaces

trait ServiceComponent {
  def service: Service

  trait Service {
    def runService: Unit
  }
}