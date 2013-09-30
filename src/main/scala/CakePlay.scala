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
  
  trait BusinessLogicComponent {
    val businessLogic : BusinessLogic
  }
  
  trait BusinessLogic {
    def doStuff
  }
  
  /*
   * Application
   */ 
  
  trait Service {
    this : BusinessLogicComponent with JmsConfigComponent =>
    
    protected def initialise = {
      println(s"Initialised service with config ${jmsConfig}")
    }
    
    def publishMessage = {
      println(s"About to publish to ${jmsConfig.queueName}")
    }
    
    def runService = {
      businessLogic.doStuff
      publishMessage 
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
  
  trait FooBusinessLogicComponent extends BusinessLogicComponent {
    val businessLogic = new BusinessLogic {
      println("Creating business logic")
      
      override def doStuff = {
        println("doing stuff")
      }
    }
  } 
  
  
  val myServiceComponent = new Service with JmsConfigComponent with FooBusinessLogicComponent {
    val jmsConfig = SingleJmsConfigComponent.jmsConfig
    initialise
  }
  
  myServiceComponent.runService
  myServiceComponent.runService
}	