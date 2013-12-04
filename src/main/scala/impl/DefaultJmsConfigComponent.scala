package impl

import interfaces.JmsConfigComponent

trait DefaultJmsConfigComponent extends JmsConfigComponent {

  class DefaultJmsConfig extends JmsConfig {
    println("Created DefaultJmsConfig")

    def queueName = "defaultQueueName"
  }
}