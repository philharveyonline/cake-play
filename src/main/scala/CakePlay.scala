object CakePlay extends App {

  /*
   * Interfaces
   */
  
  trait JmsConfigComponent {
    def jmsConfig : JmsConfig
  }
  
  trait JmsConfig {
    def queueName : String 
  }
  
  /*
   * Application
   */ 
  
  trait Service {
    this : JmsConfigComponent =>
    def publishMessage = {
      println(s"About to publish to ${jmsConfig.queueName}")
    }
  }
  
  trait DefaultJmsConfigComponent extends JmsConfigComponent {
    def jmsConfig = new DefaultJmsConfig
  }
  
  class DefaultJmsConfig extends JmsConfig {
    println("Created DefaultJmsConfig")
    
    def queueName = "defaultQueueName"
  }

  object SingleJmsConfigComponent extends JmsConfigComponent {
    lazy val jmsConfig = new JmsConfig {
      println("Created single JMS config")
      
      def queueName = "singletonQueueName"
    }
  } 
  
  val myServiceComponent = new Service with JmsConfigComponent {
    val jmsConfig = SingleJmsConfigComponent.jmsConfig
  }
  
  myServiceComponent.publishMessage
  myServiceComponent.publishMessage
}