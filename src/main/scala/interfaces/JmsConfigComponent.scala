package interfaces

trait JmsConfigComponent {
  def jmsConfig : JmsConfig

  trait JmsConfig {
    def queueName : String
  }
}